package com.springer.challenge.graphics;

import com.springer.challenge.commands.InvalidParameter;
import org.junit.Assert;
import org.junit.Test;

/**
 * This will test Canvas Singleton nature. It will cover the following test cases:
 * Invalid parameter exception
 * canvas singleton works
 *
 */
public class CanvasSingletonTests {
    @Test
    public void singletonTest() throws InvalidParameter {
        Canvas canvas = Canvas.create(10,20);
        Canvas canvas1 = Canvas.get();
        Assert.assertTrue(canvas == canvas1);
        canvas = Canvas.get();
        Assert.assertTrue(canvas == canvas1);
    }

    @Test //(expected=InvalidParameter.class) not used since we want to test multi values
    public void exceptionTest() throws InvalidParameter {
        int[] widths = {-1, 0 , 5 , 7, 0, -7};
        int[] hights = {20, 10, -1, 0, 0, -5};
        for(int i=0; i<widths.length; i++) {
            try {
                Canvas canvas = Canvas.create(widths[i], hights[i]);
                Assert.fail();
            } catch(InvalidParameter e) {
            }
        }
    }

}
