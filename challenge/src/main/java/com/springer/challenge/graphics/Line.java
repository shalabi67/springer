package com.springer.challenge.graphics;

import com.springer.challenge.commands.InvalidParameter;

/**
 * Draw a line to the canvas.
 */
public class Line extends Graphic {
    int x1;
    int y1;
    int x2;
    int y2;
    public Line(int x1,int y1,int x2,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    @Override
    protected void draw(Canvas canvas) throws GraphicsException {
        if(isHorizontalLine())
            drawHorizontalLine();
        else if(isVerticalLine())
            drawVerticalLine();
        else
            throw new InvalidParameter("Line supports horizontal or vertical lines.");
    }

    private void drawHorizontalLine() {
        Canvas canvas = Canvas.get();
        for(int i=x1;i<=x2; i++)
            canvas.putPixel('x', i, y1);
    }
    private void drawVerticalLine() {
        Canvas canvas = Canvas.get();
        for(int i=y1;i<=y2; i++)
            canvas.putPixel('x', x1, i);
    }
    public boolean isHorizontalLine() {
        return (y1 == y2);
    }
    public boolean isVerticalLine() {
        return (x1 == x2);
    }

    //TODO: look like this is not needed.
    private void isValidLine() {
        if(y1 == y2 && x1 == x2)  //single point line
            return;
        if(isHorizontalLine() && !isVerticalLine())
            return;
        if(isVerticalLine() && !isHorizontalLine())
            return;
        throw new InvalidParameter("Line supports only vertical or horizontal lines");

    }
}
