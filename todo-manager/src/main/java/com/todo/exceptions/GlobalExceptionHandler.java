package com.todo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

// we are creating exception handler methods for specific exception

    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<String>nullPointerException(NullPointerException exception){

        logger.error("NullPointerException Handler from GlobalExceptionHandler  {}",exception.getMessage());
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    //handling custom Exception Handler or Resource Not found Exception

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        logger.error("ERROR {}",ex.getMessage());

        ExceptionResponse response=new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setSuccess(false);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);


    }
    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String>noSuchExceptionHandler(NoSuchElementException ex){

        logger.info("No SuchElementException {}",ex.getMessage());

        return  new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
