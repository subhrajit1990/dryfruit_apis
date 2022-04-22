package com.manager.utils;

/**
 * @author Troublem@ker
 */
public class ContactMeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public ContactMeException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
