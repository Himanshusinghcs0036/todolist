package com.tasktodo.exception;

public class InvalidDataException extends TaskToDoException{

	public InvalidDataException(ErrorCode code) {
		super(code);
	}
}
