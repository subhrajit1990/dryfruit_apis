/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author subhrajit
 *
 */
public class ContactMeRequestWrapper {

	@JsonProperty("contactMeRequest")
	private ContactMeRequest contactMeRequest;

	public ContactMeRequest getContactMeRequest() {
		return contactMeRequest;
	}

	public void setContactMeRequest(ContactMeRequest contactMeRequest) {
		this.contactMeRequest = contactMeRequest;
	}
	

}
