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
	
	
	@ApiModelProperty(example = "0", position = 2, required = true, value = "${ProductRequest.pageNo.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pageNo")
	private Integer pageNo;
	
	@ApiModelProperty(example = "10", position = 3, required = true, value = "${ProductRequest.pageSize.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pageSize")
	private Integer pageSize;
	
	@ApiModelProperty(example = "name", position = 4, required = true, value = "${ProductRequest.sortBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sortBy")
	private String sortBy;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	
	

}
