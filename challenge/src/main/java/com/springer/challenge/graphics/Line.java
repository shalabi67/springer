package com.springer.challenge.graphics;

/**
 * Draw a line to the canvas.
 */
public class Line extends Graphic {

    public Line(int x1,int y1,int x2,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    @Override
    protected void draw(Canvas canvas) {
        if(canvas == null) {
            throw new GraphicsException("Canvas not exist. use Canvas command to create canvas C width height");
        }
        if(isHorizontalLine())
            drawHorizontalLine();
        else if(isVerticalLine())
            drawVerticalLine();
        else
            throw new GraphicsException("Line supports horizontal or vertical lines.");
    }

    private void drawHorizontalLine() {
        Canvas canvas = Canvas.get();
        int start = x1, end = x2;
        if(x2<x1) {
            start = x2;
            end = x1;
        }
        for(int i=start;i<=end; i++)
            canvas.putPixel(Canvas.point, i, y1);
    }
    private void drawVerticalLine() {
        Canvas canvas = Canvas.get();
        int start = y1, end = y2;
        if(y2<y1) {
            start = y2;
            end = y1;
        }
        for(int i=start;i<=end; i++)
            canvas.putPixel(Canvas.point, x1, i);
    }
    public boolean isHorizontalLine() {
        return (y1 == y2);
    }
    public boolean isVerticalLine() {
        return (x1 == x2);
    }


    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
