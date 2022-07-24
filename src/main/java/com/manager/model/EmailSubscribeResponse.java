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
public class EmailSubscribeResponse {

	
	@ApiModelProperty(example = "SUC", position = 1, required = true, value = "${EmailSubscribeResponse.subscribeStatus.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("subscribeStatus")
	private String subscribeStatus;

	public String getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(String subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

}
