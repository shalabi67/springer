package com.springer.challenge.graphics;

/**
 * Draw rectangle to canvas
 */
public class Rectangle extends Graphic {
    public Rectangle(int x1,int y1,int x2,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    @Override
    protected void draw(Canvas canvas) throws GraphicsException {
        fixPoints();
        drawRectangle();
    }

    //make first point on the lower left corner
    private void fixPoints() {
        //(0,0) is lower left corner
        if(x2<x1 && y2<y1) {  //first point on upper right corner
            swapX();
            swapY();
        } else if(x2<x1 && y1<y2) {  //first point on lower right corner
            swapX();
        } else if(x1<x2 && y2<y1) { //first point on upper left corner
            swapY();
        }
    }
    private void swapX() {
        int temp = x1;
        x1 = x2;
        x2 = temp;
    }
    private void swapY() {
        int temp = y1;
        y1 = y2;
        y2 = temp;
    }

    private void drawRectangle() {
        //to draw a rectangle this method will use four lines.
        //the draw can be more efficient if we used symmetry where a point can be drwan as 4 points.
        Line line = new Line(x1, y1, x2, y1);
        line.draw();

        line = new Line(x1, y1 + 1, x1, y2 - 1);
        line.draw();

        line = new Line(x1, y2, x2, y2);
        line.draw();

        line = new Line(x2, y1 + 1, x2, y2 - 1);
        line.draw();
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
