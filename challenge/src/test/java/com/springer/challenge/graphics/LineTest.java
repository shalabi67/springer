package com.springer.challenge.graphics;

import com.springer.challenge.Logger;
import com.springer.challenge.TestFramework.CanvasMock;
import com.springer.challenge.TestFramework.LineAdapter;
import com.springer.challenge.commands.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This tests the Line class. it provides the following test cases:
 * valid input
 * diagonal lines.
 */
public class LineTest {
    @Before
    public void setup() {
        Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
    }
    @Test
    public void validTest() {
        Command command;
        for(Line line : valid) {
            CanvasMock.get().resetPixelPutCount();
            line.draw();
            Canvas.get().print();
            LineAdapter.isCorrect(line);
            Assert.assertEquals(LineAdapter.getLineLength(line), CanvasMock.get().getPixelPutCount());
            Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
        }
    }

    int canvasWidth = 40;
    int canvasHeight = 39;

    Line[] valid = {
            new Line(0, 14, canvasWidth -1 , 14),
            new Line(14, 0,  14, canvasHeight -1),
            //valid edge horizontal
            new Line(0, 0, canvasWidth/4 , 0),
            new Line(canvasWidth/2, 0, canvasWidth -1 , 0),
            new Line(0, canvasHeight -1, canvasWidth/4 , canvasHeight -1),
            new Line(canvasWidth/2, canvasHeight -1, canvasWidth -1 , canvasHeight -1),
            //valid vertical edge
            new Line(0, 0, 0 , canvasHeight/4),
            new Line(0, canvasHeight/2, 0 , canvasHeight-1),
            new Line(canvasWidth -1, 0, canvasWidth -1 , canvasHeight/4),
            new Line(canvasWidth -1, canvasHeight/2, canvasWidth -1 , canvasHeight-1),
            //from low to heigh
            new Line(0, canvasHeight/4, 0 , 0),
            new Line(canvasWidth/4, 0, 0 , 0)
    };
}
