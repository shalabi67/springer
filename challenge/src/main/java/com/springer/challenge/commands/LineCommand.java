package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.GraphicsException;
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
            throw new InvalidParameterException("Invalid Canvas command expected x1, y1, x2, y2 parameters.");
        }

        isValidIntegers(parameters);
    }


    private void isValidIntegers(List<String> parameters) {
        Canvas canvas = Canvas.get();
        if(canvas == null) {
            throw new GraphicsException("Canvas not exist. use Canvas command to create canvas C width height");
        }

        int width = canvas.getWidth() - 1;
        int height = canvas.getHeight() - 1;

        String value = parameters.get(1);
        x1 = getValidInteger(value, width, "x1");

        value = parameters.get(2);
        y1 = getValidInteger(value, height, "y1");

        value = parameters.get(3);
        x2 = getValidInteger(value, width, "x2");

        value = parameters.get(4);
        y2 = getValidInteger(value, height, "y2");

    }



    @Override
    public void execute() {
        Line line = new Line(x1,y1,x2,y2);
        line.draw();
        Canvas.get().print();
    }



}
