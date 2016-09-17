package com.springer.challenge.commands;

import com.springer.challenge.Logger;
import com.springer.challenge.graphics.Canvas;
import com.springer.challenge.graphics.GraphicsException;
import com.springer.challenge.graphics.Point;

import java.util.List;

/**
 * This class is used to get parameter integer value and validate it.
 */
//this class is a refactor action of Line validation, aso it can be used in Rectangle.
public class Parameter {

    public Parameter(List<String> parameters) {
        Canvas canvas = Canvas.get();
        if(canvas == null) {
            throw new GraphicsException("Canvas not exist. use Canvas command to create canvas C width height");
        }

        this.parameters = parameters;
        width = canvas.getWidth() - 1;
        height = canvas.getHeight() - 1;
    }

    public Point getPoint(int pointNumber) {
        int startIndex = (pointNumber -1)* 2 + 1;
        int y = getValidInteger(startIndex + 1, height, "y" + pointNumber);
        int x = getValidInteger(startIndex, width, "x" + pointNumber);
        return new Point(x, y);
    }
    private int getValidInteger(int parameterIndex, int maxValue, String paramName) {
        int parameter;
        try {
            parameter = Integer.parseInt(parameters.get(parameterIndex));
            validateParameter(parameter, maxValue);
            return parameter;
        }catch(NumberFormatException e) {
            String message = paramName + " should be an integer number.";
            Logger.LogException(message);
            throw new InvalidParameterException(message);
        }
    }


    private void validateParameter(int parameter, int maxValue) {
        if(parameter<0 || parameter>maxValue){
            Logger.LogError("Parameter out of range. " + parameter);
            throw new InvalidParameterException("Parameter out of range. " + parameter);
        }
    }


    int width;
    int height;
    List<String> parameters;
}
