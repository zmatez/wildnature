/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.zip.InflaterInputStream;

public class WNStructure {
    private static final WNLogger log = WildNature.getLogger();

    protected final ResourceLocation location;
    protected final LinkedHashMap<BlockPos, BlockState> blocks = new LinkedHashMap<>();
    protected final ArrayList<String> missingStates = new ArrayList<>();
    protected CompoundTag options = new CompoundTag();
    private BlockPos min, max;

    public WNStructure(ResourceLocation location) {
        this.location = location;
    }

    //# -----------------------------------------------------------------
    public static WNStructureEntry load(ResourceLocation location) {
        String file = getFile(location);
        if (file == null) {
            return null;
        }

        var object = JsonParser.parseString(file).getAsJsonObject();
        var blocks = object.getAsJsonArray("blocks");

        CompoundTag optionsNbt = new CompoundTag();


        if (object.has("options")) {
            var options = object.getAsJsonObject("options");
            optionsNbt = readTag(options);
        }

        return new WNStructureEntry(location, blocks, optionsNbt);
    }

    private static String getFile(ResourceLocation location) {
        String path = "data/" + location.getNamespace() + "/" + WNStructures.directory + "/" + location.getPath() + WNStructures.extension;
        try {
            var inputStream = getResourceAsStream(path);
            var inflater = new InflaterInputStream(inputStream);

            ArrayList<Byte> bytes = new ArrayList<>();
            int i;
            while ((i = inflater.read()) != -1) {
                bytes.add((byte) i);
            }

            inflater.close();
            inputStream.close();

            Byte[] byteArray = bytes.toArray(new Byte[0]);
            return new String(ArrayUtils.toPrimitive(byteArray));
        } catch (IOException e) {
            log.error("Unable to load structure " + location + ": " + e.getMessage());
        }
        return null;
    }

    private static CompoundTag readTag(JsonObject options) {
        CompoundTag tag = new CompoundTag();
        for (String key : options.keySet()) {
            var value = options.get(key);
            if (value.isJsonObject()) {
                tag.put(key, readTag(value.getAsJsonObject()));
            } else {
                String val = value.getAsString();
                try {
                    int i = Integer.parseInt(val);
                    tag.putInt(key, i);
                    continue;
                } catch (NumberFormatException e) {
                }
                try {
                    double d = Double.parseDouble(val);
                    tag.putDouble(key, d);
                    continue;
                } catch (NumberFormatException e) {
                }
                try {
                    float f = Float.parseFloat(val);
                    tag.putFloat(key, f);
                    continue;
                } catch (NumberFormatException e) {
                }
                try {
                    long l = Long.parseLong(val);
                    tag.putLong(key, l);
                    continue;
                } catch (NumberFormatException e) {
                }

                tag.putString(key, val);
            }
        }
        return tag;
    }

    private static InputStream getResourceAsStream(String resource) {
        final InputStream in = getContextClassLoader().getResourceAsStream(resource);

        return in == null ? WNStructure.getResourceAsStream(resource) : in;
    }

    private static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Nullable
    private static String getType(CompoundTag options) {
        return options.contains("type") ? options.getString("type") : null;
    }

    public void load(WNStructureEntry entry) {
        for (JsonElement block : entry.blocks) {
            var obj = block.getAsJsonObject();
            BlockPos pos = BlockPos.of(obj.get("pos").getAsLong());

            try {
                BlockStateParser parser = new BlockStateParser(new StringReader(obj.get("block").getAsString()), false).parse(true);
                BlockState state = parser.getState();

                if (state == null) {
                    if (!missingStates.contains(obj.get("block").getAsString())) {
                        missingStates.add(obj.get("block").getAsString());
                    }
                    continue;
                }
                this.blocks.put(pos, state);
            } catch (CommandSyntaxException e) {
                log.error("Unable to load block at " + pos.toShortString() + " in structure " + location + ": " + e.getMessage());
            } catch (Exception e) {
                if (!missingStates.contains(obj.get("block").getAsString())) {
                    missingStates.add(obj.get("block").getAsString());
                }
            }
        }

        this.options = entry.options;

        if (!missingStates.isEmpty()) {
            log.error("----------------");
            log.error("Found " + missingStates.size() + " missing states in structure: " + this.getLocation().toString());
            for (String missingState : missingStates) {
                log.error("- " + missingState);
            }
        }

        onLoad();
    }

    protected void onLoad() {
        loadMin();
        loadMax();
    }

    public void place(LevelAccessor level, BlockPos pos, @Nullable Rotation rotation, Random random, int placeData) {
        place(level, pos, rotation, null, random, placeData);
    }

    public void place(LevelAccessor level, BlockPos pos, @Nullable Rotation rotation, @Nullable WNStructureConfig config, Random random, int placeData) {
        LinkedHashMap<BlockPos, BlockState> secondary = new LinkedHashMap<>();
        this.blocks.forEach((blockPos, blockState) -> {
            BlockPos newPos = null;
            BlockState newState = blockState;

            if (rotation != null) {
                newPos = blockPos.rotate(rotation).offset(pos);
                newState = newState.rotate(level, newPos, rotation);
            } else {
                newPos = blockPos.offset(pos);
            }

            if (newState.hasProperty(BlockStateProperties.WATERLOGGED)) {
                if (level.getBlockState(newPos).getFluidState().is(Fluids.WATER)) {
                    newState = newState.setValue(BlockStateProperties.WATERLOGGED, true);
                }
            }

            if (config != null) {
                newState = config.processState(level, newState, newPos, random, rotation);
            }

            newState = processState(level, newState, newPos, random, rotation);

            if (newState.canSurvive(level, newPos)) {
                level.setBlock(newPos, newState, placeData);
            } else {
                secondary.put(newPos, newState);
            }
        });

        secondary.forEach((blockPos, blockState) -> {
            level.setBlock(blockPos, blockState, placeData);
        });
    }

    public BlockState processState(LevelAccessor level, BlockState state, BlockPos pos, Random random, @Nullable Rotation rotation) {
        return state.getBlock() instanceof WNBlock wnBlock ? wnBlock.processStateOnPlace(level, state, pos, this, random, rotation) : state;
    }

    public boolean isCentered() {
        return !this.options.contains("center") || this.options.getBoolean("center");
    }

    public int getBlockAmount() {
        return this.blocks.size();
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public String getName() {
        return location.getPath().substring(location.getPath().lastIndexOf("/") + 1);
    }

    @Nullable
    public String getType() {
        return getType(this.options);
    }

    private void loadMin() {
        BlockPos min = null;
        for (BlockPos blockPos : this.blocks.keySet()) {
            if (min == null) {
                min = blockPos;
            } else {
                min = new BlockPos(Math.min(blockPos.getX(), min.getX()), Math.min(blockPos.getY(), min.getY()), Math.min(blockPos.getZ(), min.getZ()));
            }
        }
        this.min = min;
    }

    public void loadMax() {
        BlockPos max = null;
        for (BlockPos blockPos : this.blocks.keySet()) {
            if (max == null) {
                max = blockPos;
            } else {
                max = new BlockPos(Math.max(blockPos.getX(), max.getX()), Math.max(blockPos.getY(), max.getY()), Math.max(blockPos.getZ(), max.getZ()));
            }
        }
        this.max = max;
    }

    public BlockPos getMin() {
        return min;
    }

    public BlockPos getMax() {
        return max;
    }

    public LinkedHashMap<BlockState, Integer> getBlockOccurrences(Function<BlockState, Boolean> canCount) {
        LinkedHashMap<BlockState, Integer> blocks = new LinkedHashMap<>();
        for (Map.Entry<BlockPos, BlockState> entry : this.blocks.entrySet()) {
            if (canCount.apply(entry.getValue())) {
                if (blocks.containsKey(entry.getValue())) {
                    blocks.put(entry.getValue(), blocks.get(entry.getValue()) + 1);
                } else {
                    blocks.put(entry.getValue(), 1);
                }
            }
        }
        return blocks;
    }

    public record WNStructureEntry(ResourceLocation location, JsonArray blocks,
                                   CompoundTag options) {
        @Nullable
        public String getType() {
            return WNStructure.getType(options);
        }
    }
}
