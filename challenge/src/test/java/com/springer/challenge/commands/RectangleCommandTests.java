package com.springer.challenge.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests RectangleCommand. It covers the following test cases:
 * valid rectangle commands
 * out of range
 * wrong number of parameters
 * non integer parameters
 */
public class RectangleCommandTests {
    @Before
    public void setup() {
        Command command = Command.create("c " + canvasWidth + " " + canvasHeight);
        command.execute();
    }
    @Test
    public void validLineCommandsTest() {
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
            String.format("r 0 0 %s  %s", canvasWidth -1 , canvasHeight -1),
            String.format("r %s %s 0 0", canvasWidth -1 , canvasHeight -1),
            "R 0 1 8 9",
            "R 0 1 8 9 111"
    };
    String[] outOfRange = {
            String.format("r 0 0 %s  %s", canvasWidth , canvasHeight),
            String.format("r 0 0 %s  %s", canvasWidth +1 , canvasHeight+1),
            String.format("r 1 1 %s  %s", canvasWidth , canvasHeight),
            "R -1 1 8 9",
            "R 0 -1 8 9"
    };

    String[] wongArgumentsNumber  = {
            "r",
            "r 1",
            "r 1 2",
            "r 1 2 3"
    };

    String[] nonIntegerParameter  = {
            "r aa 1 2 2",
            "r 1 aa 2 2",
            "r 1 2 aa 2",
            "r 1 2 3 aa"
    };
}
