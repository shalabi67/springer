package com.springer.challenge.graphics;

import com.springer.challenge.commands.InvalidParameter;

/**
 * canvas class manages functionality like putting and getting pixels. It also provides singleton functionality
 * for this object.
 */
public class Canvas {
    private static Canvas canvas = null;

    protected Canvas(){
    }

    /**
     * create a Canvas object and initialize the Canvas.canvas singleton object.
     * @param width width of the canvas, must be grater than zero
     * @param height height of the canvas, must be grater than zero
     * @return Canvas object and initialize canvas singleton.
     * @throws InvalidParameter in case of width or height less than 1.
     */
    public static Canvas create(int width, int height) throws InvalidParameter {
        if(width <=0 || height<0)
            throw new InvalidParameter("Invalid width and height parameters.");

        Canvas canvas = new Canvas();
        canvas.screen = new char[width][height];
        Canvas.canvas = canvas;

        return canvas;
    }

    /**
     * gets canvas singleton object.
     * @return canvas singleton object.
     */
    public static Canvas get() {
        return canvas;
    }

    public void putPixel(char data, int x, int y) {

    }
    public char getPixel(int x, int y) {
        return ' ';
    }


    private char [][] screen = null;
    private int width;
    private int height;
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }




}
