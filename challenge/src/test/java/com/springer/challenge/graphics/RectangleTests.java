package com.springer.challenge.graphics;

import com.springer.challenge.TestFramework.CanvasMock;
import com.springer.challenge.TestFramework.LineAdapter;
import com.springer.challenge.TestFramework.RectangleAdapter;
import com.springer.challenge.commands.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This tests the Rectangle class. it provides the following test cases:
 * valid input
 */
public class RectangleTests {
    @Before
    public void setup() {
        Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
    }
    @Test
    public void validTest() {
        Command command;
        for(Rectangle rectangle : valid) {
            CanvasMock.get().resetPixelPutCount();
            rectangle.draw();
            Canvas.get().print();
            RectangleAdapter.isCorrect(rectangle);
            Assert.assertEquals(RectangleAdapter.getPoints(rectangle), CanvasMock.get().getPixelPutCount());
            Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
        }
    }


    int canvasWidth = 40;
    int canvasHeight = 30;

    Rectangle[] valid = {
            new Rectangle(0, 14, canvasWidth -1 , canvasHeight -1),
            new Rectangle(0, 0, canvasWidth -1 , canvasHeight -1),
            new Rectangle(0, 0, (canvasWidth -1)/2 , (canvasHeight -1)/2),
            new Rectangle((canvasWidth -1)/2, 0, 0 , (canvasHeight -1)/2), //first point on lower right corner
            new Rectangle((canvasWidth -1)/2, (canvasHeight -1)/2, 0 , 0), //first point on upper right corner
            new Rectangle(0, (canvasHeight -1)/2, (canvasWidth -1)/2 , 0), //first point on upper left corner

            //valid edge horizontal
            new Rectangle(0, 0, canvasWidth/4 , canvasHeight/4),
            new Rectangle(canvasWidth/2, 0, canvasWidth -1 , canvasHeight/4),
            new Rectangle(0, canvasHeight/4, canvasWidth/4 , canvasHeight -1),
            new Rectangle(canvasWidth/2, canvasHeight/4, canvasWidth -1 , canvasHeight -1),
    };
}
