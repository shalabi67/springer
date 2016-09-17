package com.springer.challenge.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests LineCommand. It covers the following test cases:
 * valid line commands
 * out of range
 * wrong number of parameters
 * non integer parameters
 */
public class LineCommandTests {
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
            String.format("l 0 0 %s  %s", canvasWidth -1 , canvasHeight -1),
            String.format("l %s %s 0 0", canvasWidth -1 , canvasHeight -1),
            "L 0 1 8 9",
            "L 0 1 8 9 111"
    };
    String[] outOfRange = {
            String.format("l 0 0 %s  %s", canvasWidth , canvasHeight),
            String.format("l 0 0 %s  %s", canvasWidth +1 , canvasHeight+1),
            String.format("l 1 1 %s  %s", canvasWidth , canvasHeight),
            "L -1 1 8 9",
            "L 0 -1 8 9"
    };

    String[] wongArgumentsNumber  = {
        "l",
        "l 1",
        "l 1 2",
        "l 1 2 3"
    };

    String[] nonIntegerParameter  = {
            "l aa 1 2 2",
            "l 1 aa 2 2",
            "l 1 2 aa 2",
            "l 1 2 3 aa"
    };

}
