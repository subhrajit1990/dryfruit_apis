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
public class AddProductRequest {

	@ApiModelProperty(example = "Kaju", position = 1, required = true, value = "${ProductAdd.title.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("title")
	private String title;
	
	@ApiModelProperty(example = "12", position = 2, required = true, value = "${ProductAdd.image.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("image")
	private String image;
	

	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductAdd.category.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("category")
	private String category;
	
	
	@ApiModelProperty(example = "Nuts", position = 5, required = true, value = "${ProductAdd.productDescription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productDescription")
	private String productDescription;

	
	@ApiModelProperty(example = "12", position = 6, required = true, value = "${ProductAdd.inventory.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productInventory")
	private List<ProductInv> productInv;

	
	@ApiModelProperty(example = "PRD001", position = 7, required = true, value = "${ProductAdd.sku.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sku")
	private String sku;
	
	@ApiModelProperty(example = "10", position = 8, required = true, value = "${ProductAdd.categoryId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("categoryId")
	private int categoryId;
	
	@ApiModelProperty(example = "10", position = 9, required = true, value = "${ProductAdd.inventoryId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productImg1")
	private String productImg1;
		
	@ApiModelProperty(example = "10", position = 10, required = true, value = "${ProductAdd.discountId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("discountId")
	private int discountId;

	@ApiModelProperty(example = "Nuts", position = 11, required = true, value = "${ProductAdd.categoryDescription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("categoryDescription")
	private String categoryDescription;

	@ApiModelProperty(example = "Subhrajit", position = 12, required = true, value = "${ProductAdd.createdBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdBy")
	private String createdBy;

	@ApiModelProperty(example = "Subhrajit", position = 13, required = true, value = "${ProductAdd.modifiedBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("modifiedBy")
	private String modifiedBy;
	
	@ApiModelProperty(example = "Y", position = 14, required = true, value = "${ProductAdd.isActive.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("isActive")
	private String isActive;
	
	@ApiModelProperty(example = "10", position = 15, required = true, value = "${ProductAdd.productImg2.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productImg2")
	private String productImg2;

	@ApiModelProperty(example = "10", position = 16, required = true, value = "${ProductAdd.productImg3.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productImg3")
	private String productImg3;
	
	
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<ProductInv> getProductInv() {
		return productInv;
	}

	public void setProductInv(List<ProductInv> productInv) {
		this.productInv = productInv;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getProductImg1() {
		return productImg1;
	}

	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}

	public String getProductImg2() {
		return productImg2;
	}

	public void setProductImg2(String productImg2) {
		this.productImg2 = productImg2;
	}

	public String getProductImg3() {
		return productImg3;
	}

	public void setProductImg3(String productImg3) {
		this.productImg3 = productImg3;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	

}
