package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.Point;
import com.springer.challenge.graphics.Rectangle;

import java.util.List;

/**
 * Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
 * It will be drawn using the 'x' character.
 */
public class RectangleCommand extends Command{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Override
    protected void init(List<String> parameters) {
        if(parameters.size() < 5) {
            Logger.LogError("Invalid Line command expected x1, y1, x2, y2 parameters.");
            throw new InvalidParameterException("Invalid Line command expected x1, y1, x2, y2 parameters.");
        }

        initValidIntegers(parameters);
    }
    private void initValidIntegers(List<String> parameters) {
        Parameter param = new Parameter(parameters);

        Point point = param.getPoint(1);
        x1 = point.getX();
        y1 = point.getY();

        point = param.getPoint(2);
        x2 = point.getX();
        y2 = point.getY();
    }

    @Override
    public void execute() {
        Rectangle rectangle = new Rectangle(x1,y1,x2,y2);
        rectangle.draw();
        Canvas.get().print();
    }
}
