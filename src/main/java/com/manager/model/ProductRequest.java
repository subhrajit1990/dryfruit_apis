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
public class ProductRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("name")
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.name.value}")
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("email")
	@ApiModelProperty(example = "Subhrajit@gmail.com", position = 2, required = true, value = "${SplitBillRequest.email.value}")
	private String email;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("phoneNumber")
	@ApiModelProperty(example = "012345678", position = 3, required = true, value = "${SplitBillRequest.phoneNumber.value}")
	private String phoneNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("message")
	@ApiModelProperty(example = "Hellow", position = 4, required = true, value = "${SplitBillRequest.message.value}")
	private String message;
	
	
	@JsonProperty("subject")
	@ApiModelProperty(example = "Queries", position = 5, required = true, value = "${SplitBillRequest.subject.value}")
	private String subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	

}
