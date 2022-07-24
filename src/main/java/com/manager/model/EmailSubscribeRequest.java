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
public class EmailSubscribeRequest {

	

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("email")
	@ApiModelProperty(example = "Subhrajit@gmail.com", position = 1, required = true, value = "${SplitBillRequest.email.value}")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
