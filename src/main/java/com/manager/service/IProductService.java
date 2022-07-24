/**
 * 
 */
package com.manager.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.manager.model.AddCategoriesRequest;
import com.manager.model.AddProductRequest;
import com.manager.model.CategoriesResponse;
import com.manager.model.GetCategoriesRequest;
import com.manager.model.ProductRequest;
import com.manager.model.ProductResponse;
import com.manager.utils.CustomExceptionFromService;



/**
 * @author Troublem@ker
 */

@Component
public interface IProductService {
	
	public ProductResponse fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel);
	public ProductResponse fetchRecentProducts( String masterTxnRefNo, String channel);
	public ProductResponse fetchProductBySku(String productId, String masterTxnRefNo, String channel);
	public ProductResponse addProduct(@Valid AddProductRequest addProductRequest, String masterTxnRefNo,String channel);

	public void addCategories(AddCategoriesRequest addCategoriesRequest, String masterTxnRefNo, String channel); 
	public Optional<CategoriesResponse> fetchCategories(GetCategoriesRequest getCategoriesRequest, String masterTxnRefNo,
			String channel);
	public void updateCategories(AddCategoriesRequest addCategoriesRequest, String masterTxnRefNo, String channel) throws CustomExceptionFromService;
}
