package com.springer.challenge.commands;

import com.springer.challenge.graphics.GraphicsException;
import org.junit.Assert;
import org.junit.Test;

/**
 * This will test Command.create function. it will cover the following test cases:
 * valid commands
 * invalid command
 * upper an lower case commands.
 * Invalid input
 * valid command but no canvas available
 */
public class CreateCommandTests {
    @Test
    public void validCommandTest() throws InvalidParameterException {
        String[] commands = { "c 40 40",
                "C 10 20",
                "l 1 2 1 4",
                "L 1 2 3 2",
                "R 1 2 3 4",
                "r 1 2 3 4",
                "b 1 3 3",
                "B 1 2 3",
                "Q",
                "q"
        };

        Command command = null;
        for(String input : commands) {
            command = Command.create(input);
            if(command instanceof InvalidCommand) {
                Assert.fail();
            }
            command.execute();
        }

    }
    @Test
    public void inValidCommandTest()  {
        String[] commands = { "D 10 20", //not a command
                "d 10 20",
                "fdh",  //not a single char command
                null, // null command
                "" //empty string command
        };

        Command command = null;
        for(String input : commands) {
            try {
                command = Command.create(input);
                if (!(command instanceof InvalidCommand)) {
                    Assert.fail();
                }
                command.execute();
            }
            catch(InvalidParameterException e) {

            }
        }
    }



}
