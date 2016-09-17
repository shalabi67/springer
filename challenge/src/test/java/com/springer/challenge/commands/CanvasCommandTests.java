package com.springer.challenge.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test CanvasCommand. this covers the following test cases:
 * wrong number of parameters
 * string parameters
 * invalid parameters
 */
public class CanvasCommandTests {
    @Test
    public void invalidParameters() {
        Command command;
        for(String input : commands) {
            try {
                command = Command.create(input);
                command.execute();
                Assert.fail(input);
            }
            catch(InvalidParameterException e) {

            }
        }
    }

    private String[] commands = {
        "c 10",
            "c as 10",
            "c 15 as",
            "c -1 5",
            "c 5 -1"
    };
}
