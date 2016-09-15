package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.Line;

import java.util.List;

/**
 * This class will be responsible to draw a line into canvas. the command is L x1 y1 x2 y2
 * where:
 * Should create a new line from (x1,y1) to (x2,y2). Currently only
 * horizontal or vertical lines are supported. Horizontal and vertical lines
 * will be drawn using the 'x' character.
 */
public class LineCommand extends Command {
    int x1;
    int y1;
    int x2;
    int y2;
    @Override
    protected void init(List<String> parameters) {
        if(parameters.size() < 5) {
            Logger.LogError("Invalid Canvas command expected x1, y1, x2, y2 parameters.");
            throw new InvalidParameter("Invalid Canvas command expected x1, y1, x2, y2 parameters.");
        }

        isValidIntegers(parameters);
    }


    private void isValidIntegers(List<String> parameters) {
        int width = Canvas.get().getWidth();
        int height = Canvas.get().getHeight();
        try {
            x1 = Integer.parseInt(parameters.get(1));
            validateParameter(x1, width);
        }catch(NumberFormatException e) {
            Logger.LogException("x1 should be an integer number.");
            throw new InvalidParameter("x1 should be an integer number.");
        }
        try {
            y1 = Integer.parseInt(parameters.get(2));
            validateParameter(y1, height);
        }catch(NumberFormatException e) {
            Logger.LogException("y1 should be an integer number.");
            throw new InvalidParameter("y1 should be an integer number.");
        }
        try {
            x2 = Integer.parseInt(parameters.get(3));
            validateParameter(x2, width);
        }catch(NumberFormatException e) {
            Logger.LogException("x2 should be an integer number.");
            throw new InvalidParameter("x2 should be an integer number.");
        }
        try {
            y2 = Integer.parseInt(parameters.get(4));
            validateParameter(y2, height);
        }catch(NumberFormatException e) {
            Logger.LogException("y2 should be an integer number.");
            throw new InvalidParameter("y2 should be an integer number.");
        }
    }


    private void validateParameter(int parameter, int width) {
        if(parameter<0 || parameter>width){
            Logger.LogError("Parameter out of range. " + parameter);
            throw new InvalidParameter("Parameter out of range. " + parameter);
        }
    }

    @Override
    public void execute() {
        Line line = new Line(x1,y1,x2,y2);
        line.draw();
        Canvas.get().print();
    }



}
