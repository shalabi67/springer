package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;

import java.util.List;

/**
 * The canvas command will be responsible to create a canvas by executing a canvas string command.
 * the string command is c w h. where w is the width and h is height. Canvas starts from (0,0).
 */
public class CanvasCommand extends Command {
    private int width;
    private int height;
    @Override
    protected void init(List<String> parameters) throws InvalidParameterException {
        if(parameters.size() < 3) {
            Logger.LogError("Invalid Canvas command expected width and height parameters.");
            throw new InvalidParameterException("Invalid Canvas command expected width and height parameters.");
        }

        try {
            width = Integer.parseInt(parameters.get(1));
        }catch(NumberFormatException e) {
            Logger.LogException("Width should be an integer number.");
            throw new InvalidParameterException("Width should be an integer number.");
        }
        try {
            height = Integer.parseInt(parameters.get(2));
        }catch(NumberFormatException e) {
            Logger.LogException("Height should be an integer number.");
            throw new InvalidParameterException("Height should be an integer number.");
        }
    }

    @Override
    public void execute() {
        Canvas.create(width, height);
        Canvas.get().print();
    }
}
