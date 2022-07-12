/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author subhrajit
 *
 */
public class AddProductRequestWrapper {

	@JsonProperty("addProductRequest")
	private AddProductRequest addProductRequest;

	public AddProductRequest getAddProductRequest() {
		return addProductRequest;
	}

	public void setAddProductRequest(AddProductRequest addProductRequest) {
		this.addProductRequest = addProductRequest;
	}


}
