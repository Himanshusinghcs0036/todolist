package com.tasktodo.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponseTO {
	
	private HttpStatus httpStatus;
	
	private String message;

	public ErrorResponseTO(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
}
