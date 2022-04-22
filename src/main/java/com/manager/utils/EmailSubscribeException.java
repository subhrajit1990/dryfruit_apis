package com.manager.utils;

/**
 * @author Troublem@ker
 */
public class EmailSubscribeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public EmailSubscribeException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
