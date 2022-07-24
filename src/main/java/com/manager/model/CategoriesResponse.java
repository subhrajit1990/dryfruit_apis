package com.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CategoriesResponse {
	
	@ApiModelProperty(example = "Dry Fruit", position = 1, required = true, value = "${CategoriesResponse.productType.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productType")
	private String productType;

	@ApiModelProperty(example = "This category is for fruits", position = 2, required = true, value = "${CategoriesResponse.desc.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("desc")
	private String desc;

	@ApiModelProperty(example = "Y", position = 3, required = true, value = "${CategoriesResponse.isActive.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("isActive")
	private String isActive;
	
	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductCategories.subCategories.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("subCategories")
	private List<SubCategoriesResponse> subCategoriesResponse; 
	
	@ApiModelProperty(example = "1", position = 4, required = true, value = "${CategoriesResponse.pId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pId")
	private String pId;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public List<SubCategoriesResponse> getSubCategoriesResponse() {
		return subCategoriesResponse;
	}

	public void setSubCategoriesResponse(List<SubCategoriesResponse> subCategoriesResponse) {
		this.subCategoriesResponse = subCategoriesResponse;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
	

}
