package com.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class SubCategoriesResponse {
	
	@ApiModelProperty(example = "Dry Fruit", position = 1, required = true, value = "${CategoriesResponse.productSubCategory.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productSubCategory")
	private String productSubCategory;

	@ApiModelProperty(example = "This category is for fruits", position = 2, required = true, value = "${CategoriesResponse.desc.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("desc")
	private String desc;

	@ApiModelProperty(example = "Y", position = 3, required = true, value = "${CategoriesResponse.isActive.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("isActive")
	private String isActive;

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
