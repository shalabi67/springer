package com.springer.challenge.graphics;

import com.springer.challenge.TestFramework.CanvasMock;
import com.springer.challenge.commands.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test FillColor by providing the following test cases:
 * open area: fill color for empty area
 * Outside closed objects: have closed objects and fill outside them.
 * fill inside closed object
 * non a closed structure
 */
public class FillColorTests {
    @Before
    public void setup() {
        Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
        CanvasMock.get().resetPixelPutCount();
    }

    @Test
    public void openAreaTest() {
        Command command = Command.create("b 0 0 o");
        command.execute();
        Assert.assertEquals(canvasWidth * canvasHeight, CanvasMock.get().getPixelPutCount());
    }

    @Test
    public void outsideClosedObjectsTest() {
        Command command;
        int index = 0;
        for(String[] commands : outsideClosedObjects) {
            for(String input : commands) {
                command = Command.create(input);
                command.execute();
            }
            CanvasMock.get().resetPixelPutCount();
            command = Command.create("b 0 0 o");
            command.execute();
            Assert.assertEquals(outsideClosedObjectsResult[index], CanvasMock.get().getPixelPutCount());

            Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
            index++;
        }
    }
    @Test
    public void notClosedObjectsTest() {
        Command command;
        int index = 0;
        for(String[] commands : notClosedObjects) {
            for(String input : commands) {
                command = Command.create(input);
                command.execute();
            }
            CanvasMock.get().resetPixelPutCount();
            command = Command.create("b 0 0 o");
            command.execute();
            Assert.assertEquals(notClosedObjectsResult[index], CanvasMock.get().getPixelPutCount());

            Canvas.create(new CanvasMock(), canvasWidth, canvasHeight);
            index++;
        }
    }

    @Test
    public void insideClosedObjectTest() {
        Command command =  Command.create("R 5 5 8 8");
        command.execute();
        CanvasMock.get().resetPixelPutCount();
        command = Command.create("b 6 6 o");
        command.execute();
        Assert.assertEquals(4, CanvasMock.get().getPixelPutCount());
    }


    int canvasWidth = 40;
    int canvasHeight = 40;


    String[][] outsideClosedObjects = {
            {"l 5 5 8 5 "},
            {"r 5 5 8 8 "},
            {"r 5 5 8 8 ", "l 5 3 8 3 "}
    };
    int[] outsideClosedObjectsResult = {
            canvasWidth * canvasHeight - 4,
            canvasWidth * canvasHeight - 16,
            canvasWidth * canvasHeight - 20
    };

    String[][] notClosedObjects = {
            {"l 0 3 5 3 ", "l 5 1 5 2 "},

    };
    int[] notClosedObjectsResult = {
            canvasWidth * canvasHeight - 8,

    };
}
