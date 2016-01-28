/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.exception;

/**
 * Custom class that extends Runtime Exceptions handled by
 * GlobalExceptionHandler (Controller Advice)
 *
 * @author Amira
 */
public class SpringException extends RuntimeException {

    // Unique ID for Serialized object 
    // if not provided will be created dynamically
    // private static final long serialVersionUID = 46546544L;
    /**
     * Constructor to initialize exception message
     *
     * @param msg
     */
    public SpringException(String msg) {
        super(msg);
    }

    /**
     * Constructor to initialize exception message and Throwable
     *
     * @param msg
     * @param t
     */
    public SpringException(String msg, Throwable t) {
        super(msg, t);
    }
}
