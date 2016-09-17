package com.springer.challenge.TestFramework;

import com.springer.challenge.graphics.Line;
import com.springer.challenge.graphics.Rectangle;

/**
 * This will provide need functions related to tests
 */
public class RectangleAdapter {
    public static  int getPoints(Rectangle rectangle) {
        Line line = new Line(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY1());
        int count = LineAdapter.getLineLength(line);

        line = new Line(rectangle.getX1(), rectangle.getY1() + 1, rectangle.getX1(), rectangle.getY2() - 1);
        count += LineAdapter.getLineLength(line);

        line = new Line(rectangle.getX1(), rectangle.getY2(), rectangle.getX2(), rectangle.getY2());
        count += LineAdapter.getLineLength(line);

        line = new Line(rectangle.getX2(), rectangle.getY1() + 1, rectangle.getX2(), rectangle.getY2() - 1);
        count += LineAdapter.getLineLength(line);

        return count;
    }
    public static void isCorrect(Rectangle rectangle) {

    }
}
