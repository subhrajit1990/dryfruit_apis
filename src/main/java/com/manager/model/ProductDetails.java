package com.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ProductDetails {

	@ApiModelProperty(example = "Kaju", position = 1, required = true, value = "${ProductDetails.title.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("title")
	private String title;

	@ApiModelProperty(example = "12", position = 2, required = true, value = "${ProductDetails.image.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("image")
	private String image;

	@ApiModelProperty(example = "12", position = 3, required = true, value = "${ProductDetails.image2.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("image2")
	private String image2;

	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductDetails.category.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("category")
	private String category;

	@ApiModelProperty(example = "Nuts", position = 5, required = true, value = "${ProductDetails.description.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("description")
	private String description;

	@ApiModelProperty(example = "12", position = 6, required = true, value = "${ProductDetails.inventory.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("productInventory")
	private List<ProductInv> productInv;

	@ApiModelProperty(example = "12", position = 7, required = true, value = "${ProductDetails.image3.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("image3")
	private String image3;
	
	
	@ApiModelProperty(example = "PRD001", position = 8, required = true, value = "${ProductDetails.sku.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sku")
	private String sku;
	

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

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public List<ProductInv> getProductInv() {
		return productInv;
	}

	public void setProductInv(List<ProductInv> productInv) {
		this.productInv = productInv;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	
	
}
