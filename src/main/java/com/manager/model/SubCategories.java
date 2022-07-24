package com.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class SubCategories {

	@ApiModelProperty(example = "kaju", position = 1, required = true, value = "${ProductSubCategories.productSubCategory.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productSubCategory")
	private String productSubCategory;
	
	@ApiModelProperty(example = "This sub categories are for kaju", position = 2, required = true, value = "${ProductSubCategories.desription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("desription")
	private String desription;
	
	
	@ApiModelProperty(example = "Y", position = 3, required = true, value = "${ProductSubCategories.isActive.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("isActive")
	private String isActive;
	

	@ApiModelProperty(example = "Subhrajit", position = 4, required = true, value = "${ProductSubCategories.createdBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdBy")
	private String createdBy;

	@ApiModelProperty(example = "Subhrajit", position = 5, required = true, value = "${ProductSubCategories.modifiedBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("modifiedBy")
	private String modifiedBy;


	public String getProductSubCategory() {
		return productSubCategory;
	}


	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}


	public String getDesription() {
		return desription;
	}


	public void setDesription(String desription) {
		this.desription = desription;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
