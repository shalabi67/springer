package com.springer.challenge.TestFramework;

import com.springer.challenge.commands.InvalidParameterException;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.Line;

import static java.lang.Math.abs;

/**
 * This will provide need functions related to tests
 */
public class LineAdapter {
    public static  int getLineLength(Line line) {
        if(line.isHorizontalLine())
            return abs(line.getX1() - line.getX2()) + 1;
        else if(line.isVerticalLine())
            return abs(line.getY1() - line.getY2()) + 1;
        throw new InvalidParameterException("invalid line");
    }

    public static void isCorrect(Line line) {
        int start, end;
        if(line.isHorizontalLine()) {
            if(line.getX2() >= line.getX1()) {
                start = line.getX1();
                end = line.getX2();
            }
            else {
                start = line.getX2();
                end = line.getX1();
            }
            char ch = Canvas.point;
            for(int i=start; i<=end; i++) {
                if(ch != Canvas.get().getPixel(i, line.getY1()))
                    throw new InvalidPointException("Point not found");
            }

        } else if(line.isVerticalLine()) {
            if(line.getY2() >= line.getY1()) {
                start = line.getY1();
                end = line.getY2();
            }
            else {
                start = line.getY2();
                end = line.getY1();
            }
            char ch = Canvas.point;
            for(int i=start; i<=end; i++) {
                if(ch != Canvas.get().getPixel(line.getX1(), i))
                    throw new InvalidPointException("Point not found");
            }

        } else {
            throw new InvalidPointException("Point not found");
        }

    }
}
