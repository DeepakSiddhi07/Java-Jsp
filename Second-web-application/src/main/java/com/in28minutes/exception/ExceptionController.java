package com.in28minutes.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    private  Log logger =  LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request,Exception ex){
        logger.error("Request"+request.getRequestURL()+"Throw an exception",ex);
        return "error";
    }
}
