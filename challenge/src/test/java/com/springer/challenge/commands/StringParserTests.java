package com.springer.challenge.commands;

import com.springer.challenge.commands.StringParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Tests pars function of StringParser object. this will provide the following test cases:
 * input split by spaces.
 * input split by tab
 * input split by tab and spaces
 * input is empty
 * input is null
 * input without spaces
 * input ends with space
 * input starts with spaces
 *
 */
public class StringParserTests {
    @Test
    public void validInputTest() {
        String[] inputs = {
                "aa bb cc", //single space
                "aa   bb       ccc", //multible spaces
                "aa  bb  cc     ", //ends with spaces
                "aa   bb  cc\t", //ends with tab
                "aa   bb  ccc  \t", //ends with spaces tab
                "aa   bb  cc\t  ", //ends with tab and spaces
                "   aa   bb  cc", //starts with spaces
                "\taa   bb  cc", //starts with tab
                "\t  aa   bb  cc", //starts with tab and spaces
                "   \taa   bb  cc", //starts with spaces and tab
                "aa\tbb\tcc", //tab split
                "\t\t\taa\t\t\tbb\t\t\tcc\t\t\t", //multi tab plit
            };
        for(String input : inputs) {
            List<String> list = StringParser.parse(input);
            Assert.assertNotNull(list);
            Assert.assertEquals(input, 3, list.size());
        }
    }

    @Test
    public void nullTests() {
        List<String> list = StringParser.parse(null);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void emptyTests() {
        List<String> list = StringParser.parse("");
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
    }
    @Test
    public void noSpacesTests() {
        List<String> list = StringParser.parse("aaaaa");
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
    }
}
