package com.sapo.edu.demo.exception;

public class InvalidFieldException extends Exception{

    private String message;

    public InvalidFieldException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
