package com.springer.challenge.graphics;

/**
 *
 */
public class GraphicsException extends Exception {
    public GraphicsException(String message, Throwable ex) {
        super(message, ex);
    }

    public GraphicsException(String message) {
        super(message);
    }
}
