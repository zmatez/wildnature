/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.commands.dev.structure;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.matez.wildnature.common.managers.structure.server.WNDevServerStructureManager;
import net.matez.wildnature.common.registry.commands.IWNCommand;
import net.matez.wildnature.common.util.WNChatUtil;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.CompoundTagArgument;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.zip.DeflaterOutputStream;

public class WNCommandDevStructureSave implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var save = Commands.literal("save");
        save.then(Commands.argument("name", StringArgumentType.string()).executes(context -> {
            String name = StringArgumentType.getString(context, "name");

            return save(context, context.getSource().getPlayerOrException(), name, new CompoundTag()) ? 1 : 0;
        }).then(Commands.argument("options", CompoundTagArgument.compoundTag()).executes((context -> {
            String name = StringArgumentType.getString(context, "name");
            CompoundTag options = CompoundTagArgument.getCompoundTag(context, "options");

            return save(context, context.getSource().getPlayerOrException(), name, options) ? 1 : 0;
        }))));

        stack.then(save);
    }


    private boolean save(CommandContext<CommandSourceStack> context, ServerPlayer player, String name, CompoundTag options) {
        var selection = WNDevServerStructureManager.get(player);
        if (selection == null) {
            WNChatUtil.respond(context, false, "No selection found");
            return false;
        }
        if (!selection.isComplete()) {
            WNChatUtil.respond(context, false, "Selection is not complete, you need to select two points.");
            return false;
        }
        WNChatUtil.respond(context, true, "Saving structure to &v" + name + ".wnstruct&r...");

        // settings
        boolean center = true;
        boolean saveAir = false;
        String customSetting = "";
        if (options.contains("center")) {
            center = options.getBoolean("center");
            customSetting += "\n&g- &vcenter &r= &x" + center;
        }
        if (options.contains("air")) {
            saveAir = options.getBoolean("air");
            customSetting += "\n&g- &vair &r= &x" + saveAir;
        }
        if (!customSetting.isEmpty()) {
            WNChatUtil.respond(context, true, "Applied custom options: " + customSetting);
        }

        // blocks and its positions (relative or not)
        LinkedHashMap<BlockPos, BlockState> blocks = new LinkedHashMap<>();

        // centers
        selection.findCenters();
        var centers = selection.getCenters();
        BlockPos centerPos = null;
        if (center) {
            if (centers.isEmpty()) {
                WNChatUtil.respond(context, false, "No center block found.");
                return false;
            } else if (centers.size() > 1) {
                WNChatUtil.respond(context, false, "Only one center block is allowed, but found &v" + centers.size());
                return false;
            }
            centerPos = centers.get(0);
        }

        // loading states
        for (BlockPos blockPos : selection.stream()) {
            BlockState state = player.getLevel().getBlockState(blockPos);
            if (state.isAir() && !saveAir) {
                continue;
            }


            if (!center) {
                blocks.put(blockPos, state);
            } else {
                BlockPos centered = new BlockPos(blockPos.getX() - centerPos.getX(), blockPos.getY() - centerPos.getY(), blockPos.getZ() - centerPos.getZ());
                blocks.put(centered, state);
            }
        }

        File file = new File(FMLPaths.GAMEDIR.get().resolve("wildnature/export/" + name + ".wnstruct").toString());
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            WNChatUtil.respond(context, false, "Unable to create directory at " + file.getPath());
            return false;
        }
        if (file.exists()) {
            WNChatUtil.respond(context, false, "File already exists at " + file.getPath());
            return false;
        }

        // serializing
        JsonObject json = new JsonObject();
        if (!options.isEmpty()) {
            JsonObject jsonOptions = new JsonObject();
            saveCompound(options, jsonOptions);
            json.add("options", jsonOptions);
        }
        JsonArray jsonBlocks = new JsonArray();
        blocks.forEach((pos, state) -> {
            JsonObject block = new JsonObject();
            block.addProperty("pos", pos.asLong());
            block.addProperty("block", BlockStateParser.serialize(state));
            jsonBlocks.add(block);
        });
        json.add("blocks", jsonBlocks);

        String jsonOutput = json.toString();

        try {
            if (!file.createNewFile()) {
                WNChatUtil.respond(context, false, "Unable to create new file at " + file.getPath());
                return false;
            }


            var fOut = new FileOutputStream(file);
            var out = new DeflaterOutputStream(fOut);

            for (byte aByte : jsonOutput.getBytes(StandardCharsets.UTF_8)) {
                out.write(aByte);
                out.flush();
            }

            out.close();
            fOut.close();
        } catch (IOException e) {
            WNChatUtil.respond(context, false, "Unable to create new file at " + file.getPath() + ": &v" + e.getMessage());
            return false;
        }

        String size = "";
        if (file.length() >= 1024) {
            size = String.format("%.1f", ((float) file.length() / 1024)) + "KB";
        } else {
            size = file.length() + "B";
        }

        WNChatUtil.respond(context, true, "Saved structure with &v" + blocks.size() + " blocks&r taking &v" + size);

        return true;
    }

    private void saveCompound(CompoundTag tag, JsonObject object) {
        for (String key : tag.getAllKeys()) {
            if (tag.contains(key, 10)) {
                saveCompound(tag.getCompound(key), object);
            } else {
                Tag value = tag.get(key);
                if (value != null) {
                    object.addProperty(key, value.getAsString());
                }
            }
        }
    }
}
