package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.ColorFill;
import com.springer.challenge.graphics.Point;

import java.util.List;

/**
 * Should fill the entire area connected to (x,y) with "colour" c.
 * The behaviour of this is the same as that of the "bucket fill" tool in paint programs.
 * R x y c
 */
public class ColorFillCommand extends Command {
    int x;
    int y;
    char color;
    @Override
    protected void init(List<String> parameters) {
        if(parameters.size() < 4) {
            String message = "Invalid Color Fill command expected x y c parameters.";
            Logger.LogError(message);
            throw new InvalidParameterException(message);
        }

        getData(parameters);
    }

    private void getData(List<String> parameters) {
        Parameter param = new Parameter(parameters);

        Point point = param.getPoint(1);
        x = point.getX();
        y = point.getY();

        String color = parameters.get(3).trim();
        if(color.length() != 1) {
            String message = "Invalid color. Color is single character.";
            Logger.LogError(message);
            throw new InvalidParameterException(message);
        }
        this.color = color.charAt(0);
    }


    @Override
    public void execute() {
        ColorFill colorFill = new ColorFill(x, y, color);
        colorFill.draw();

        Canvas.get().print();
    }
}
