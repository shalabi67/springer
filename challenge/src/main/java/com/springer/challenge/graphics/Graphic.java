package com.springer.challenge.graphics;

/**
 * abstract class that will be implemented by line, rectangle and etc.
 */
public abstract class Graphic {
    public void draw() throws GraphicsException {
        Canvas canvas = Canvas.get();
        if(null == canvas) {
            throw new GraphicsException("Canvas does notz exist. Use Canvas command to create a canvas.");
        }
        draw(canvas);
    }
    protected abstract void draw(Canvas canvas) throws GraphicsException;
}
