package com.springer.challenge.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class QuitCommandTests {
    @Test
    public void quitTest() {
        Command command = Command.create("q");
        command.execute();

        if(!QuitCommand.isQuit())
            Assert.fail();
    }
}
