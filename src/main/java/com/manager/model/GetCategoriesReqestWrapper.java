/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author subhrajit
 *
 */
public class GetCategoriesReqestWrapper {

	@JsonProperty("getCategoriesRequest")
	private GetCategoriesRequest getCategoriesRequest;

	public GetCategoriesRequest getGetCategoriesRequest() {
		return getCategoriesRequest;
	}

	public void setGetCategoriesRequest(GetCategoriesRequest getCategoriesRequest) {
		this.getCategoriesRequest = getCategoriesRequest;
	}

	
	
}
