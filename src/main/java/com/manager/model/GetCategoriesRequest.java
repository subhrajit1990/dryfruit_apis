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
public class GetCategoriesRequest {

	@ApiModelProperty(example = "0", position = 1, required = true, value = "${ProductCategories.pageNo.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pageNo")
	private Integer pageNo;

	@ApiModelProperty(example = "10", position = 2, required = true, value = "${ProductCategories.pageSize.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("pageSize")
	private Integer pageSize;

	@ApiModelProperty(example = "name", position = 3, required = true, value = "${ProductCategories.sortBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("sortBy")
	private String sortBy;

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
