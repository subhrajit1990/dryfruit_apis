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
	
	@JsonProperty("ProductResponse")
	private ProductResponse productReponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public ProductResponse getProductReponse() {
		return productReponse;
	}

	public void setProductReponse(ProductResponse productReponse) {
		this.productReponse = productReponse;
	}
	
	

}
