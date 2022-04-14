/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * @author subhrajit
 *
 */
public class ContactMeResponse {

	
	@ApiModelProperty(example = "SUC", position = 1, required = true, value = "${ContactMeRequest.groupStatus.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("contactMeStatus")
	private String contactMeStatus;

	public String getContactMeStatus() {
		return contactMeStatus;
	}

	public void setContactMeStatus(String contactMeStatus) {
		this.contactMeStatus = contactMeStatus;
	}
	
	
	

}
