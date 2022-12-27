/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.command.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.matez.wildnature.common.structures.WNStructure;
import net.matez.wildnature.common.structures.WNStructures;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class WNStructurePathArgument implements ArgumentType<ResourceLocation> {
    public static ArrayList<ResourceLocation> PATHS = new ArrayList<>();
    public static ArrayList<String> EXAMPLES = new ArrayList<>();

    public static WNStructurePathArgument path() {
        return new WNStructurePathArgument();
    }

    public static PathValidator getValidator(CommandContext<CommandSourceStack> context, String name) {
        ResourceLocation resourcelocation = context.getArgument(name, ResourceLocation.class);

        return (structure) -> {
            if (structure.getLocation().getNamespace().equals(resourcelocation.getNamespace())) {
                return structure.getLocation().getPath().contains(resourcelocation.getPath());
            }
            return false;
        };
    }

    @Override
    public ResourceLocation parse(StringReader reader) throws CommandSyntaxException {
        return ResourceLocation.read(reader);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        if (PATHS.isEmpty()) {
            for (ResourceLocation location : WNStructures.STRUCTURES.keySet()) {
                String path = location.getPath();
                while (path.contains("/")) {
                    path = path.substring(0, path.lastIndexOf("/"));
                    boolean contains = false;
                    for (ResourceLocation loc : PATHS) {
                        if (loc.toString().equals(path.toString())) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        PATHS.add(new ResourceLocation(location.getNamespace(), path));
                    }
                }
            }
        }
        return SharedSuggestionProvider.suggestResource(PATHS.stream(), builder);
    }

    @Override
    public Collection<String> getExamples() {
        if (EXAMPLES.isEmpty()) {
            for (ResourceLocation location : WNStructures.STRUCTURES.keySet()) {
                String path = location.getPath();
                while (path.contains("/")) {
                    path = path.substring(0, path.lastIndexOf("/"));
                    boolean contains = false;
                    for (String loc : EXAMPLES) {
                        if (loc.equals(path.toString())) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        EXAMPLES.add(new ResourceLocation(location.getNamespace(), path).toString());
                    }
                }
            }
        }
        return EXAMPLES;
    }

    public interface PathValidator {
        boolean isIn(WNStructure structure);
    }
}
