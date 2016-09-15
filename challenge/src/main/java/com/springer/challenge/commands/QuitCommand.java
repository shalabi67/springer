package com.springer.challenge.commands;

import java.util.List;

/**
 *
 */
public class QuitCommand extends Command {
    private static boolean quit = false;
    public static boolean isQuit() {
        return quit;
    }



    @Override
    protected void init(List<String> parameters) {

    }

    @Override
    public void execute() {
        quit = true;
    }
}
