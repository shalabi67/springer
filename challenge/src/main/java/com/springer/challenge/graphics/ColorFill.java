package com.springer.challenge.graphics;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class ColorFill extends Graphic {
    int x;
    int y;
    char color;
    public ColorFill(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    @Override
    protected void draw(Canvas canvas) throws GraphicsException {
        if(canvas == null) {
            throw new GraphicsException("Canvas not exist. use Canvas command to create canvas C width height");
        }
        fillColor(canvas);
    }

    Hashtable<Point, Boolean> hashTable = new Hashtable<Point, Boolean>();
    Queue<Point> queue = new LinkedList<Point>();
    private void fillColor(Canvas canvas) {
        Point point = new Point(x,y);
        queue.add(point);
        if(!hashTable.containsKey(point))
            hashTable.put(point, true);

        while(!queue.isEmpty()) {
            point = queue.remove();
            canvas.putPixel(color, point.getX(), point.getY());
            addPoints(point, canvas);
        }
    }
    private void addPoints(Point point, Canvas canvas) {
        int x = point.getX();
        int y = point.getY();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if(x-1>=0) {
            addPoint(canvas, x - 1, y);
        }
        if(x+1<width) {
            addPoint(canvas, x + 1, y);
        }
        if(y-1>=0) {
            addPoint(canvas, x, y - 1);
        }
        if(y+1<height) {
            addPoint(canvas, x, y + 1);
        }
    }

    private void addPoint(Canvas canvas, int x, int y) {
        if(Canvas.point != canvas.getPixel(x, y)) {
            Point point = new Point(x, y);
            if(!hashTable.containsKey(point)) {
                hashTable.put(point, true);
                queue.add(point);
            }
        }
    }
}
