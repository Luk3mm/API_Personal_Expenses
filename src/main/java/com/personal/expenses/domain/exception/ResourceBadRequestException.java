package com.personal.expenses.domain.exception;

public class ResourceBadRequestException extends RuntimeException{
    public ResourceBadRequestException(String message){
        super(message);
    }
}
