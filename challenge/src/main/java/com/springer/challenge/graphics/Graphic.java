package com.springer.challenge.graphics;

/**
 * This class is responsible to draw object into Canvas.
 * This abstract class that will be implemented by Line, Rectangle and other graphics objects.
 */
public abstract class Graphic {
    public void draw() throws GraphicsException {
        Canvas canvas = Canvas.get();
        if(null == canvas) {
            throw new GraphicsException("Canvas does not exist. Use Canvas command to create a canvas.");
        }
        draw(canvas);
    }
    protected abstract void draw(Canvas canvas) throws GraphicsException;
}
