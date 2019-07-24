package com.tasktodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorResponseTO> handleInvalidDataException(InvalidDataException e) {
		ErrorResponseTO responseTO = new ErrorResponseTO(HttpStatus.BAD_REQUEST, e.getMessage());
		return ResponseEntity.status(responseTO.getHttpStatus()).body(responseTO);
	}
}
