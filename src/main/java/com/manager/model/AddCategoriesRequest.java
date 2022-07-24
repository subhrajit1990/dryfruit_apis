/**
 * 
 */
package com.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * @author subhrajit
 *
 */
public class AddCategoriesRequest {

	@ApiModelProperty(example = "dry fruit", position = 1, required = true, value = "${ProductCategories.productType.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productType")
	private String productType;
	
	@ApiModelProperty(example = "This categories are for dry fruit", position = 2, required = true, value = "${ProductCategories.desription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("desription")
	private String desription;
	
	@ApiModelProperty(example = "Y", position = 3, required = true, value = "${ProductCategories.isActive.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("isActive")
	private String isActive;
	
	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductCategories.subCategories.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("subCategories")
	private List<SubCategories> subCategories;
	
	@ApiModelProperty(example = "Subhrajit", position = 5, required = true, value = "${ProductCategories.createdBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdBy")
	private String createdBy;

	@ApiModelProperty(example = "Subhrajit", position = 6, required = true, value = "${ProductCategories.modifiedBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("modifiedBy")
	private String modifiedBy;
	
	@ApiModelProperty(example = "dry fruit", position = 7, required = true, value = "${ProductCategories.pId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pId")
	private String pId;
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public List<SubCategories> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategories> subCategories) {
		this.subCategories = subCategories;
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
}
