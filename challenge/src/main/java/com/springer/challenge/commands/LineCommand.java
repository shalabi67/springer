package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.Line;
import com.springer.challenge.graphics.Point;

import java.util.List;

/**
 * This class will be responsible to draw a line into canvas. the command is L x1 y1 x2 y2
 * where:
 * Should create a new line from (x1,y1) to (x2,y2). Currently only
 * horizontal or vertical lines are supported. Horizontal and vertical lines
 * will be drawn using the 'x' character.
 */
public class LineCommand extends Command {
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
        Line line = new Line(x1,y1,x2,y2);
        line.draw();
        Canvas.get().print();
    }



}
