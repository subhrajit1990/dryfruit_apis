package com.manager.utils;

public class CustomExceptionFromService extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public CustomExceptionFromService(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
