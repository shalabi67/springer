package com.springer.challenge.graphics;

import com.springer.challenge.Logger;
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
    public static Canvas create(int width, int height)  {
        if(width <=0 || height<=0)
            throw new InvalidParameter("Invalid width and height parameters.");

        Canvas canvas = new Canvas();
        canvas.screen = new char[width][height];
        canvas.width = width;
        canvas.height = height;
        Canvas.canvas = canvas;

        Logger.LogInfo("Create Canvas Width:" + width + " Height:" + height);

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
        validateParameter(x, y);
        screen[x][y] = data;

    }

    public char getPixel(int x, int y) {
        validateParameter(x, y);
        return screen[x][y];
    }

    private void validateParameter(int x, int y) {
        if(x<0 || x>=width) {
            Logger.LogInfo("Invalid x parameter. " + x);
            throw new InvalidParameter("Invalid x parameter.");
        }
        if(y<0 || y>=height) {
            Logger.LogInfo("Invalid y parameter. " + y);
            throw new InvalidParameter("Invalid y parameter.");
        }
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
