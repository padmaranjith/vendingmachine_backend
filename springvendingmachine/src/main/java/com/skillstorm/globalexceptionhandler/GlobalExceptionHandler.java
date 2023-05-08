package com.skillstorm.globalexceptionhandler;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Padma Ranjith
 * Handles the exception and send custom designed error message to user
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MyErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
	    MyErrorResponse errorResponse = new MyErrorResponse();
	    errorResponse.setTimestamp(LocalDateTime.now());
	    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setMessage(ex.getMessage());
	    return errorResponse;
	}
}
