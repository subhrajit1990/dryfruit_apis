package com.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ProductResponse {
	
	@ApiModelProperty(example = "12", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productDetails")
	private List<ProductDetails> productDetails;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "ProductResponse [productDetails=" + productDetails + "]";
	}
	
	

}
