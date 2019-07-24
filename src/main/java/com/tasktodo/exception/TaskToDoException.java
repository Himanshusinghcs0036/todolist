package com.tasktodo.exception;

public abstract class TaskToDoException extends RuntimeException {

    private final ErrorCode errorCode;
    
    TaskToDoException(ErrorCode code) {
    	super(code.getMessage());
    	this.errorCode = code;
    }

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
