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
public class ProductRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("name")
	@ApiModelProperty(example = "DRY001", position = 1, required = true, value = "${ProductRequest.sku.value}")
	private String sku;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	

}
