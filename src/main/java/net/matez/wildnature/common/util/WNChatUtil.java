/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.util;

import com.mojang.brigadier.context.CommandContext;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

public class WNChatUtil {
    private final static char[] SMALL = new char[]{'f', 'i', 'l', 't', '!', '|', 'I'};
    public static String ACCENT_COLOR = "#49A3FF"; //V
    public static String BRIGHT_ACCENT_COLOR = "#BFE8F3"; //W
    public static String DARK_ACCENT_COLOR = "#5EA01F"; //X
    public static String FAIL_COLOR = "#e3152e"; //Y
    public static String SUCCESS_COLOR = "#6CE700"; //Z
    public static String GRAY_COLOR = "#2F4139"; //G
    public static String SIGN_ACCENT = "#27402B";
    // -------------------------------------
    private static LinkedHashMap<Character, String> colors = new LinkedHashMap<>();

    static {
        colors.put('1', "#4F47AC");
        colors.put('2', "#4A8536");
        colors.put('3', "#36857D");
        colors.put('4', "#853232");
        colors.put('5', "#853676");
        colors.put('6', "#FBB731");
        colors.put('7', "#CBC6CB");
        colors.put('8', "#636063");
        colors.put('9', "#5867FF");
        colors.put('a', "#5FFF18");
        colors.put('b', "#4DFAFF");
        colors.put('c', "#FF5D5D");
        colors.put('d', "#FF63BD");
        colors.put('e', "#FFF924");
        colors.put('f', "#ffffff");
        colors.put('v', ACCENT_COLOR);
        colors.put('w', BRIGHT_ACCENT_COLOR);
        colors.put('x', DARK_ACCENT_COLOR);
        colors.put('y', FAIL_COLOR);
        colors.put('z', SUCCESS_COLOR);
        colors.put('g', GRAY_COLOR);
    }

    public static MutableComponent getLogo() {
        return
                new TextComponent("[")
                        .withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false))
                        .append(new TextComponent("WN")
                                .withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR).withBold(true)
                                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"))
                                        .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                                new TextComponent("WildNature Mod\n").withStyle(WNChatUtil.format(ACCENT_COLOR))
                                                        .append(new TextComponent("v" + WildNature.getVersion() + "\n").withStyle(WNChatUtil.format(DARK_ACCENT_COLOR)))
                                                        .append(new TextComponent("---\n").withStyle(WNChatUtil.format(GRAY_COLOR)))
                                                        .append(new TextComponent("Click to go to the official page").withStyle(WNChatUtil.format(BRIGHT_ACCENT_COLOR)))
                                        ))
                                ))
                        .append(new TextComponent("] ")
                                .withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false)))
                        .append(new TextComponent("").withStyle(WNChatUtil.format(WNChatUtil.BRIGHT_ACCENT_COLOR)));
    }

    public static MutableComponent getHeader(String title) {
        return new TextComponent("------------ ").withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false))
                .append(new TextComponent("WN").withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR).withBold(true)))
                .append(new TextComponent(" >> ").withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false)))
                .append(new TextComponent(title).withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR).withBold(false)))
                .append(new TextComponent(" ------------\n").withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false)))
                ;
    }

    public static MutableComponent getFooter(String header) {
        String footer = "";
        LinkedHashMap<Character, Integer> small = new LinkedHashMap<>();
        for (char c : SMALL) {
            small.put(c, 0);
        }
        for (int i = 0; i < header.length(); i++) {
            char c = header.charAt(i);
            if (small.containsKey(c)) {
                if (small.get(c) >= 3) {
                    footer += "-";
                    small.put(c, 0);
                } else {
                    small.put(c, small.get(c) + 1);
                }
            } else {
                footer += "-";
            }
        }
        return new TextComponent(footer).withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR).withBold(false));
    }

    public static MutableComponent lineStarter() {
        return new TextComponent("- ").withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR));
    }

    public static MutableComponent lineStarter(int count) {
        String start = "";
        for (int i = 0; i < count; i++) {
            start += "-";
        }
        return new TextComponent(start + " ").withStyle(WNChatUtil.format(WNChatUtil.GRAY_COLOR));
    }
    // -------------------------------------

    public static Style format(String color) {
        return Style.EMPTY.withColor(TextColor.parseColor(color));
    }

    public static void respond(CommandContext<CommandSourceStack> stack, boolean success, String message) {
        MutableComponent component = getLogo().append(parseMessage(message, success ? BRIGHT_ACCENT_COLOR : FAIL_COLOR));
        if (success) {
            stack.getSource().sendSuccess(component, true);
        } else {
            stack.getSource().sendFailure(component);
        }
    }

    public static void respond(CommandContext<CommandSourceStack> stack, boolean success, MutableComponent component) {
        if (success) {
            stack.getSource().sendSuccess(component, true);
        } else {
            stack.getSource().sendFailure(component);
        }
    }

    public static void send(Player player, String message, boolean success) {
        MutableComponent component = getLogo().append(parseMessage(message, success ? BRIGHT_ACCENT_COLOR : FAIL_COLOR));
        player.sendMessage(component, Util.NIL_UUID);
    }

    public static void send(Player player, MutableComponent component) {
        player.sendMessage(component, Util.NIL_UUID);
    }

    // -------------------------------------

    public static MutableComponent parseMessage(String message, String defaultColor) {
        MutableComponent component = new TextComponent("");
        StringBuilder prev = new StringBuilder();
        Style defaultStyle = format(defaultColor)
                .withBold(false)
                .withUnderlined(false)
                .withHoverEvent(null)
                .withClickEvent(null)
                .withStrikethrough(false)
                .withItalic(false)
                .withObfuscated(false);
        Style style = defaultStyle;
        boolean escaped = false;
        for (int i = 0; i < message.toCharArray().length; i++) {
            char c = message.charAt(i);
            if (c == '\\') {
                escaped = true;
                continue;
            }
            if (c == '&' && !escaped) {
                try {
                    boolean success = true;
                    char next = message.charAt(i + 1);
                    Style newStyle = style;
                    boolean changeStyle = true;
                    if (next == 'r') {
                        newStyle = defaultStyle;
                    } else if (next == 'l') {
                        newStyle = style.withBold(!style.isBold());
                    } else if (next == 'i') {
                        newStyle = style.withItalic(!style.isItalic());
                    } else if (next == 'u') {
                        newStyle = style.withUnderlined(!style.isUnderlined());
                    } else if (next == 's') {
                        newStyle = style.withStrikethrough(!style.isStrikethrough());
                    } else if (next == '%') {
                        //hex
                        String hex = "";
                        for (int j = 2; j <= 7; j++) {
                            if (message.length() > i + j) {
                                char n = message.charAt(i + j);

                                if (n == '1' || n == '2' || n == '3' || n == '4' || n == '5' || n == '6' || n == '7' || n == '8' || n == '9' || n == '0' || n == 'a' || n == 'b' || n == 'c' || n == 'd' || n == 'e' || n == 'f') {
                                    hex += n;
                                } else {
                                    break;
                                }
                            }
                        }

                        if (hex.length() >= 3) {
                            newStyle = style.withColor(TextColor.parseColor('#' + hex));
                        }
                        i += hex.length() + 1;//skip until %
                    } else {
                        if (colors.containsKey(next)) {
                            newStyle = style.withColor(TextColor.parseColor(colors.get(next)));
                        } else {
                            success = false;
                        }
                    }

                    if (changeStyle && success) {
                        component.append(new TextComponent(prev.toString()).withStyle(style));
                        style = newStyle;
                        prev = new StringBuilder();
                    }

                    if (success) {
                        i++;//skip next letter
                        continue;
                    }
                } catch (Exception e) {
                }
            }

            prev.append(c);
        }
        if (!prev.isEmpty()) {
            component.append(new TextComponent(prev.toString()).withStyle(style));
        }
        return component.append("").withStyle(ChatFormatting.RESET);
    }


    public static String capitalize(final String str, final char... delimiters) {
        final int delimLen = delimiters == null ? -1 : delimiters.length;
        if (StringUtils.isEmpty(str) || delimLen == 0) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (isDelimiter(ch, delimiters)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer[i] = Character.toTitleCase(ch);
                capitalizeNext = false;
            }
        }
        return new String(buffer);
    }

    private static boolean isDelimiter(final char ch, final char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }
        for (final char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }
}
