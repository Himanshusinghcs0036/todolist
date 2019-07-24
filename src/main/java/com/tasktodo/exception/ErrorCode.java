package com.tasktodo.exception;

public enum ErrorCode {

	INVALID_DESCRIPTION("400", "description can not be empty"), INVALID_ID("400", "ID can not be empty"),
	INVALID_ID_OR_DESCRIPTION("400", "ID or description can not be empty");

	private String code;

	private String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
