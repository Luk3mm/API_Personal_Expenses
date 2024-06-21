package com.personal.expenses.handler;

import com.personal.expenses.common.ConverterDate;
import com.personal.expenses.domain.exception.ResourceBadRequestException;
import com.personal.expenses.domain.exception.ResourceNotFoundException;
import com.personal.expenses.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){
        String hourDate = ConverterDate.converterDateForDateAndHour(new Date());
        ErrorResponse erro = new ErrorResponse(hourDate, HttpStatus.NOT_FOUND.value(), "Not Found", exception.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerResourceBadRequestException(ResourceBadRequestException exception){
        String hourDate = ConverterDate.converterDateForDateAndHour(new Date());
        ErrorResponse erro = new ErrorResponse(hourDate, HttpStatus.BAD_REQUEST.value(), "Bad Request", exception.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerRequestException(Exception exception){
        String hourDate = ConverterDate.converterDateForDateAndHour(new Date());
        ErrorResponse erro = new ErrorResponse(hourDate, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", exception.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
