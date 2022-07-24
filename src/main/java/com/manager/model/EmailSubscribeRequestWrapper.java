/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author subhrajit
 *
 */
public class EmailSubscribeRequestWrapper {

	@JsonProperty("emailSubscribeRequest")
	private EmailSubscribeRequest emailSubscribe;

	public EmailSubscribeRequest getEmailSubscribe() {
		return emailSubscribe;
	}

	public void setEmailSubscribe(EmailSubscribeRequest emailSubscribe) {
		this.emailSubscribe = emailSubscribe;
	}

}
