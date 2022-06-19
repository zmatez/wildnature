/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.matez.wildnature.common.objects.structures.WNStructure;
import net.matez.wildnature.common.objects.structures.WNStructures;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class WNStructureArgument implements ArgumentType<ResourceLocation> {
    private static final DynamicCommandExceptionType ERROR_UNKNOWN_STRUCTURE = new DynamicCommandExceptionType((p_107010_) -> {
        return new TranslatableComponent("advancement.advancementNotFound", p_107010_); //todo change structure argument
    });

    public static ArrayList<String> EXAMPLES = new ArrayList<>();

    public static WNStructureArgument structure() {
        return new WNStructureArgument();
    }


    public static WNStructure getStructure(CommandContext<CommandSourceStack> context, String name) throws CommandSyntaxException {
        ResourceLocation resourcelocation = context.getArgument(name, ResourceLocation.class);
        WNStructure structure = WNStructures.STRUCTURES.get(resourcelocation);

        if (structure == null) {
            throw ERROR_UNKNOWN_STRUCTURE.create(resourcelocation);
        } else {
            return structure;
        }
    }

    @Override
    public ResourceLocation parse(StringReader reader) throws CommandSyntaxException {
        return ResourceLocation.read(reader);
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return SharedSuggestionProvider.suggestResource(WNStructures.STRUCTURES.keySet().stream(), builder);
    }

    @Override
    public Collection<String> getExamples() {
        if (EXAMPLES.isEmpty()) {
            for (ResourceLocation location : WNStructures.STRUCTURES.keySet()) {
                EXAMPLES.add(location.toString());
            }
        }
        return EXAMPLES;
    }
}
