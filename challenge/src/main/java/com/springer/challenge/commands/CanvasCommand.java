package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;

import java.util.List;

/**
 * The canvas command will be resposible to create a canavs by executing a canvas string command.
 * the string command is c w h. where w is the width and h is height
 */
public class CanvasCommand extends Command {
    int width;
    int height;
    @Override
    protected void init(List<String> parameters) throws InvalidParameter {
        if(parameters.size() < 3) {
            Logger.LogError("Invalid Canvas command expected width and height parameters.");
            throw new InvalidParameter("Invalid Canvas command expected width and height parameters.");
        }

        width = Integer.parseInt(parameters.get(1));
        height = Integer.parseInt(parameters.get(2));
    }

    @Override
    public void execute() {
        Canvas.create(width, height);
    }
}
