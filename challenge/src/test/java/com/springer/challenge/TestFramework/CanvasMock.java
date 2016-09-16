package com.springer.challenge.TestFramework;

import com.springer.challenge.graphics.Canvas;

/**
 * This will mock canvas object. it will override PutPixel to count number of written pixels.
 */
public class CanvasMock extends Canvas {
    public static CanvasMock get() {
        return (CanvasMock)(Canvas.get());
    }
    private int pixelPutCount;
    public int getPixelPutCount() {
        return pixelPutCount;
    }
    public void resetPixelPutCount() {
        pixelPutCount = 0;
    }

    @Override
    public void putPixel(char data, int x, int y) {
        pixelPutCount++;
        super.putPixel(data, x, y);
    }


}
