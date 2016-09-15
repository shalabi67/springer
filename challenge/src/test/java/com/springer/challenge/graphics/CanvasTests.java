package com.springer.challenge.graphics;

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
    @Test
    public void pixelTest() {
        Assert.fail();
    }

    @Test
    public void putPixelOutOfXRangeTest() {
        Assert.fail();
    }

    @Test
    public void gutPixelOutOfXRangeTest() {
        Assert.fail();
    }

    @Test
    public void putPixelOutOfYRangeTest() {
        Assert.fail();
    }

    @Test
    public void gutPixelOutOfYRangeTest() {
        Assert.fail();
    }

    int[] invalidHeightParam = {height, -1, height + 1 };
    int[] invalidWidthParam = {width, -1, width + 1 };
}
