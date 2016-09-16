package com.springer.challenge.graphics;

import com.springer.challenge.commands.InvalidParameterException;
import org.junit.Assert;
import org.junit.Test;

/**
 * This will test canvas graphics object. it provides the following test cases:
 * canvas putPixel and getPixel
 * canvas putPixel out of range
 * canvas getPixel out of range.
 */
public class CanvasTests {
    int width = 10;
    int height = 15;
    char ch = 's';
    @Test
    public void pixelTest() {
        Canvas canvas = Canvas.create(width, height);
        for(int i=0; i<validX.length; i++) {
            canvas.putPixel(ch, validX[i], validY[i]);
            char out = canvas.getPixel(validX[i], validY[i]);
            Assert.assertEquals(ch, out);
        }
    }

    @Test
    public void putPixelOutOfXRangeTest() {
        Canvas canvas = Canvas.create(width, height);
        for(int i=0; i<invalidWidthParam.length; i++) {
            try {
                canvas.putPixel(ch, invalidWidthParam[i], 0);
                Assert.fail();
            } catch(InvalidParameterException e) {
            }
        }
    }

    @Test
    public void getPixelOutOfXRangeTest() {
        Canvas canvas = Canvas.create(width, height);
        for(int i=0; i<invalidWidthParam.length; i++) {
            try {
                canvas.getPixel(invalidWidthParam[i], 0);
                Assert.fail();
            } catch(InvalidParameterException e) {
            }
        }
    }

    @Test
    public void putPixelOutOfYRangeTest() {
        Canvas canvas = Canvas.create(width, height);
        for(int i=0; i<invalidHeightParam.length; i++) {
            try {
                canvas.putPixel(ch, 0, invalidHeightParam[i]);
                Assert.fail();
            } catch(InvalidParameterException e) {
            }
        }
    }

    @Test
    public void getPixelOutOfYRangeTest() {
        Canvas canvas = Canvas.create(width, height);
        for(int i=0; i<invalidHeightParam.length; i++) {
            try {
                canvas.getPixel(0, invalidHeightParam[i]);
                Assert.fail();
            } catch(InvalidParameterException e) {
            }
        }
    }

    int[] invalidHeightParam = {height, -1, height + 1 };
    int[] invalidWidthParam = {width, -1, width + 1 };

    int[] validX = {0, width-1,  width-1, 0};
    int[] validY = {0, height-1, 0,     height-1};
}
