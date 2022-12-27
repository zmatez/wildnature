/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.structure.server;

import net.matez.wildnature.common.structure.WNDevStructureSelection;
import net.matez.wildnature.api.client.chat.ChatHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;

import java.util.LinkedHashMap;

/**
 * Server only
 */
public class WNDevServerStructureManager {
    public static final LinkedHashMap<ServerPlayer, WNDevServerStructureSelection> STRUCTURE_SELECTIONS = new LinkedHashMap<>();

    public static WNDevStructureSelection get(ServerPlayer player) {
        return STRUCTURE_SELECTIONS.get(player);
    }

    public static WNDevStructureSelection getOrCreate(ServerPlayer player, BlockPos clickPos, boolean use) {
        if (STRUCTURE_SELECTIONS.containsKey(player)) {
            var selection = STRUCTURE_SELECTIONS.get(player);
            if (selection.getLevel() == player.getLevel()) {
                if (use) {
                    ChatHelper.send(player, "Set &vpos1&r to &v" + clickPos.getX() + " " + clickPos.getY() + " " + clickPos.getZ(), true);
                    selection.setPos1(clickPos);
                } else {
                    ChatHelper.send(player, "Set &vpos2&r to &v" + clickPos.getX() + " " + clickPos.getY() + " " + clickPos.getZ(), true);
                    selection.setPos2(clickPos);
                }

                selection.send();

                return selection;
            }
        }
        var selection = new WNDevServerStructureSelection(player);
        if (use) {
            ChatHelper.send(player, "Created and set &vpos1&r to &v" + clickPos.getX() + " " + clickPos.getY() + " " + clickPos.getZ(), true);
            selection.setPos1(clickPos);
        } else {
            ChatHelper.send(player, "Created and set &vpos2&r to &v" + clickPos.getX() + " " + clickPos.getY() + " " + clickPos.getZ(), true);
            selection.setPos2(clickPos);
        }

        STRUCTURE_SELECTIONS.put(player, selection);
        selection.send();
        return selection;
    }

    public static boolean delete(ServerPlayer player) {
        if (STRUCTURE_SELECTIONS.containsKey(player)) {
            var sel = STRUCTURE_SELECTIONS.remove(player);
            sel.remove();
            sel.send();
            return true;
        }
        return false;
    }
}
