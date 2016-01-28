/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dealers.exception;

import org.hibernate.ObjectNotFoundException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * class of type ControllerAdvice to handle Global Exceptions across all
 * controllers
 *
 * @author Amira
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Logger to log all activities within this class
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Generic function for any exception - it returns ExceptionPage view with full
     * exception trace and exception message
     *
     * @param req Current HTTP request.
     * @param exception The exception thrown - always {@link SpringException}.
     * @return The model and view used by the DispatcherServlet to generate
     * output.
     * @throws Exception
     */
    @ExceptionHandler(SpringException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception)
            throws Exception {

        // Rethrow annotated exceptions or they will be processed here instead.
        if (AnnotationUtils.findAnnotation(exception.getClass(),
                ResponseStatus.class) != null) {
            throw exception;
        }
        logger.error(new Date() + " Request: " + req.getRequestURI() + " raised " + exception);

        ModelAndView mv = new ModelAndView("ExceptionPage");
        mv.addObject("message", exception.getMessage());
        mv.addObject("exception", exception);
        mv.addObject("url", req.getRequestURL());
        mv.addObject("timestamp", new Date().toString());
        mv.addObject("status", 500);
        return mv;
    }

    /**
     * Function to handle hibernate objects not found exception
     *
     * @param request Current HTTP request.
     * @param exception The exception thrown.
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Object Exists")
    @ExceptionHandler(ObjectNotFoundException.class)
    public void handleObjectNotFoundException(HttpServletRequest request, Exception exception) {
        logger.error(new Date() + " Object not found exception occured Occured:: URL= " + request.getRequestURL() + " Exception Message= " + exception.getMessage());
    }
}
