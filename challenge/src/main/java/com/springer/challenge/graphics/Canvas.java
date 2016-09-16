package com.springer.challenge.graphics;

import com.springer.challenge.Logger;
import com.springer.challenge.commands.InvalidParameterException;

/**
 * canvas class manages functionality like putting and getting pixels. It also provides singleton functionality
 * for this object.
 * Canvas starts from (0,0).
 */
public class Canvas {
    private static Canvas canvas = null;
    public static char point = 'x';

    protected Canvas(){
    }

    /**
     * create a Canvas object and initialize the Canvas.canvas singleton object.
     * @param width width of the canvas, must be grater than zero
     * @param height height of the canvas, must be grater than zero
     * @return Canvas object and initialize canvas singleton.
     * @throws InvalidParameterException in case of width or height less than 1.
     */
    public static Canvas create(int width, int height)  {
        Canvas canvas = new Canvas();
        create(canvas, width, height);

        return canvas;
    }

    //this will help us in testing by providing mock canvas.
    public static Canvas create(Canvas canvas, int width, int height)  {
        if(width <=0 || height<=0)
            throw new InvalidParameterException("Invalid width and height parameters.");

        canvas.screen = new char[width][height];
        canvas.width = width;
        canvas.height = height;
        Canvas.canvas = canvas;

        for(int y=0;y<height;y++)
            for (int x = 0; x < width; x++)
                canvas.putPixel(' ',x,y);

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

    /**
     * print canvas to console
     */
    public void print() {
        int sides = 2;
        System.out.println();
        for(int i=0;i<width + 2;i++)
            System.out.print("-");
        System.out.println();

        for(int y=0;y<height;y++) {
            System.out.print("|");

            for (int x = 0; x < width; x++)
                System.out.print(getPixel(x,y));

            System.out.println("|");
        }

        for(int i=0;i<width + 2;i++)
            System.out.print("-");
        System.out.println();
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
            throw new InvalidParameterException("Invalid x parameter.");
        }
        if(y<0 || y>=height) {
            Logger.LogInfo("Invalid y parameter. " + y);
            throw new InvalidParameterException("Invalid y parameter.");
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
