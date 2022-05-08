package com.manager.model;

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
	
	@ApiModelProperty(example = "12", position = 3, required = true, value = "${ProductDetails.price.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("price")
	private double price;
	
	
	@ApiModelProperty(example = "12", position = 4, required = true, value = "${ProductDetails.category.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("category")
	private String category;
	
	
	@ApiModelProperty(example = "Nuts", position = 5, required = true, value = "${ProductDetails.description.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("description")
	private String description;

	@ApiModelProperty(example = "10", position = 6, required = true, value = "${ProductDetails.quantity.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("quantity")
	private int quantity;

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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "ProductDetails [title=" + title + ", image=" + image + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", quantity=" + quantity + "]";
	}


}
