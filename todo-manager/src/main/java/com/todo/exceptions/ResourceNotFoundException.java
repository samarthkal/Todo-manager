package com.todo.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException  extends  RuntimeException{

    private String message1;
    private HttpStatus status;

    public ResourceNotFoundException(String message, String message1, HttpStatus status) {
        super(message);
        this.message1 = message1;
        this.status = status;
    }

    public ResourceNotFoundException(String s, HttpStatus notFound) {
    }

    public String getMessage() {
        return message1;
    }

    public void setMessage(String message) {
        this.message1 = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


}
