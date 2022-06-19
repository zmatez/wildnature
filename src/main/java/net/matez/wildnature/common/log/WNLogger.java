/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WNLogger {
    private final boolean debugMode;
    private static boolean progressPending = false;
    private static boolean lastMessageIsAProgress = false;

    public WNLogger(boolean debug) {
        this.debugMode = debug;
    }

    private String currentTime() {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void debug(String message){
        if(debugMode) {
            pre();
            System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.BLUE_BRIGHT + "[DEBUG]: " + ConsoleColors.BLUE + message + ConsoleColors.RESET);
        }
    }
    public void log(String message){
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.YELLOW_BRIGHT + "[INFO]: " + ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }
    public void progress(String message){
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.PURPLE_BRIGHT + "[PROGRESS]: " + ConsoleColors.PURPLE + message + ConsoleColors.RESET);
    }
    public void success(String message){
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.GREEN_BRIGHT + "[SUCCESS]: " + ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }
    public void warn(String message){
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.YELLOW_BRIGHT + "[WARN]: " + ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }

    public void error(String message) {
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.RED_BRIGHT + "[ERROR]: " + ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    public void fatal(String message) {
        pre();
        System.out.println(ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + ConsoleColors.BLACK + ConsoleColors.RED_BACKGROUND + "[FATAL]" + ConsoleColors.RESET + ConsoleColors.RED_BRIGHT + ": " + ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    private void pre() {
        if (progressPending && lastMessageIsAProgress) {
            System.out.println("");
        }
        lastMessageIsAProgress = false;
    }

    public void startProgress() {
        progressPending = true;
    }

    public void endProgress() {
        progressPending = false;
        System.out.print("\n");
    }

    public void progressPercentage(int done, int total) {
        int size = 20;
        String iconLeftBoundary = ConsoleColors.BLACK_BRIGHT + "[" + ConsoleColors.RESET;
        String iconDone = ConsoleColors.YELLOW_BRIGHT + "=" + ConsoleColors.RESET;
        String iconRemain = ConsoleColors.RED + "-" + ConsoleColors.RESET;
        String iconRightBoundary = ConsoleColors.BLACK_BRIGHT + "]" + ConsoleColors.RESET;

        if (done > total) {
            throw new IllegalArgumentException();
        }
        int donePercents = (100 * done) / total;
        int doneLength = size * donePercents / 100;

        StringBuilder bar = new StringBuilder(iconLeftBoundary);
        for (int i = 0; i < size; i++) {
            if (i < doneLength) {
                bar.append(iconDone);
            } else {
                bar.append(iconRemain);
            }
        }
        bar.append(iconRightBoundary);

        lastMessageIsAProgress = true;
        System.out.print("\r" + ConsoleColors.BLACK_BRIGHT + "[" + currentTime() + "] " + bar + " " + ConsoleColors.GREEN_BRIGHT + donePercents + "%");
    }

    //debug alternatives
    public void debug(int message){
        debug(message+"");
    }
    public void debug(double message){
        debug(message+"");
    }
    public void debug(long message){
        debug(message+"");
    }
    public void debug(short message){
        debug(message+"");
    }
    public void debug(char message){
        debug(message+"");
    }
    public void debug(boolean message){
        debug(message+"");
    }
    public void debug(Object message){
        debug((message == null ? "null" : message.toString())+"");
    }

    //log alternatives
    public void log(int message){
        log(message+"");
    }
    public void log(double message){
        log(message+"");
    }
    public void log(long message){
        log(message+"");
    }
    public void log(short message){
        log(message+"");
    }
    public void log(char message){
        log(message+"");
    }
    public void log(boolean message){
        log(message+"");
    }
    public void log(Object message){
        log((message == null ? "null" : message.toString())+"");
    }

    //success alternatives
    public void success(int message){
        success(message+"");
    }
    public void success(double message){
        success(message+"");
    }
    public void success(long message){
        success(message+"");
    }
    public void success(short message){
        success(message+"");
    }
    public void success(char message){
        success(message+"");
    }
    public void success(boolean message){
        success(message+"");
    }
    public void success(Object message){
        success((message == null ? "null" : message.toString())+"");
    }

    //error alternatives
    public void error(int message){
        error(message+"");
    }
    public void error(double message){
        error(message+"");
    }
    public void error(long message){
        error(message+"");
    }
    public void error(short message){
        error(message+"");
    }
    public void error(char message){
        error(message+"");
    }
    public void error(boolean message){
        error(message+"");
    }
    public void error(Object message){
        error((message == null ? "null" : message.toString())+"");
    }

    //fatal alternatives
    public void fatal(int message){
        fatal(message+"");
    }
    public void fatal(double message){
        fatal(message+"");
    }
    public void fatal(long message){
        fatal(message+"");
    }
    public void fatal(short message){
        fatal(message+"");
    }
    public void fatal(char message){
        fatal(message+"");
    }
    public void fatal(boolean message){
        fatal(message+"");
    }
    public void fatal(Object message){
        fatal((message == null ? "null" : message.toString())+"");
    }


}
