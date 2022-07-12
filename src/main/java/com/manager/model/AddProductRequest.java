/**
 * 
 */
package com.manager.model;

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
	
	@ApiModelProperty(example = "12", position = 3, required = true, value = "${ProductAdd.price.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("price")
	private double price;
	
	
	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductAdd.category.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("category")
	private String category;
	
	
	@ApiModelProperty(example = "Nuts", position = 5, required = true, value = "${ProductAdd.productDescription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productDescription")
	private String productDescription;

	@ApiModelProperty(example = "10", position = 6, required = true, value = "${ProductDetails.quantity.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("quantity")
	private int quantity;
	
	@ApiModelProperty(example = "PRD001", position = 7, required = true, value = "${ProductAdd.sku.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sku")
	private String sku;
	
	@ApiModelProperty(example = "10", position = 8, required = true, value = "${ProductDetails.categoryId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("categoryId")
	private int categoryId;
	
	@ApiModelProperty(example = "10", position = 9, required = true, value = "${ProductDetails.inventoryId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("inventoryId")
	private int inventoryId;
	
	
	@ApiModelProperty(example = "10", position = 10, required = true, value = "${ProductDetails.discountId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("discountId")
	private int discountId;

	@ApiModelProperty(example = "Nuts", position = 11, required = true, value = "${ProductAdd.categoryDescription.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("categoryDescription")
	private String categoryDescription;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
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
