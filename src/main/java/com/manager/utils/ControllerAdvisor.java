package com.manager.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manager.model.ContactMeResponseWrapper;
import com.manager.model.ResponseHeader;


/**
 * @author subhrajit
 *
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	ResponseHeader responseHeader= new ResponseHeader();
	
	@ExceptionHandler(ContactMeException.class)
	public ResponseEntity<ContactMeResponseWrapper> handleContactMeException(ContactMeException ex, WebRequest webReq) {
		logger.error("Run time exception happened for contact me module ");
		CommonUtils.generateHeaderForGenericError(responseHeader);
		ContactMeResponseWrapper contactMeResponseWrapper = new ContactMeResponseWrapper();
		contactMeResponseWrapper.setResponseHeader(responseHeader);
		return new ResponseEntity<>(contactMeResponseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
