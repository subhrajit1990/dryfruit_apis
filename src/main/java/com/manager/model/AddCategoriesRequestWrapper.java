/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author subhrajit
 *
 */
public class AddCategoriesRequestWrapper {

	@JsonProperty("addCategoriesRequest")
	private AddCategoriesRequest addCategoriesRequest;

	public AddCategoriesRequest getAddCategoriesRequest() {
		return addCategoriesRequest;
	}

	public void setAddCategoriesRequest(AddCategoriesRequest addCategoriesRequest) {
		this.addCategoriesRequest = addCategoriesRequest;
	}
	
	
}
