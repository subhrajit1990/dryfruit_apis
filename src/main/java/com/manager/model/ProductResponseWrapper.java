/**
 * 
 */
package com.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author subhrajit
 *
 */
public class ProductResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

}
