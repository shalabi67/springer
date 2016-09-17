package com.springer.challenge.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests ColorFillCommand. It covers the following test cases:
 * valid ColorFillCommand commands
 * out of range
 * wrong number of parameters
 * non integer parameters
 */
public class ColorFillCommandTests {
    @Before
    public void setup() {
        Command command = Command.create("c " + canvasWidth + " " + canvasHeight);
        command.execute();
    }
    @Test
    public void validColorFillCommandsTest() {
        for(String input : valid) {
            Command.create(input);
        }
    }
    @Test
    public void wongArgumentsNumberTest() {
        negativeTest(wongArgumentsNumber);
    }
    @Test
    public void outOfRangeTest() {
        negativeTest(outOfRange);
    }

    @Test
    public void nonIntegerParameterTest() {
        negativeTest(nonIntegerParameter);
    }

    private void negativeTest(String[] list) {
        for(String input : list) {
            try {
                Command.create(input);
                Assert.fail(input);
            }catch(InvalidParameterException e) {

            }
        }
    }


    int canvasWidth = 40;
    int canvasHeight = 30;

    String[] valid = {
            String.format("b %s %s c", canvasWidth -1 , canvasHeight -1),
            "b 0 0 o",
            "B 5 4 d"
    };
    String[] outOfRange = {
            String.format("b %s  %s c", canvasWidth , canvasHeight),
            String.format("b %s  %s c", canvasWidth +1 , canvasHeight+1),
            String.format("b %s  %s c", canvasWidth , canvasHeight),
            "b -1 1 c",
            "B 0 -1 d"
    };

    String[] wongArgumentsNumber  = {
            "B",
            "B 1",
            "B 1 2"
    };

    String[] nonIntegerParameter  = {
            "l aa 1 c",
            "l 1 aa c",
            "l 1 2 aa"
    };
}
