package com.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriesResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("categoriesResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CategoriesResponse categoriesResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public CategoriesResponse getCategoriesResponse() {
		return categoriesResponse;
	}

	public void setCategoriesResponse(CategoriesResponse categoriesResponse) {
		this.categoriesResponse = categoriesResponse;
	}
	
}
