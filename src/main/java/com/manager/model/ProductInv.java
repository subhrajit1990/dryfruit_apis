package com.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ProductInv {

	@ApiModelProperty(example = "10", position = 1, required = true, value = "${ProductAdd.quantity.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("quantity")
	private int quantity;

	@ApiModelProperty(example = "10", position = 2, required = true, value = "${ProductAdd.variantName.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("variantName")
	private String variantName;

	@ApiModelProperty(example = "10", position = 3, required = true, value = "${ProductAdd.variantDesc.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("variantDesc")
	private String variantDesc;
	
	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductAdd.price.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("price")
	private double price;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public String getVariantDesc() {
		return variantDesc;
	}

	public void setVariantDesc(String variantDesc) {
		this.variantDesc = variantDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
