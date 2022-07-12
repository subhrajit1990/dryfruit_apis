/**
 * 
 */
package com.manager.service;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.manager.model.AddProductRequest;
import com.manager.model.ProductRequest;
import com.manager.model.ProductResponse;



/**
 * @author Troublem@ker
 */

@Component
public interface IProductService {
	
	public ProductResponse fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel);
	public ProductResponse fetchRecentProducts(ProductRequest productRequest, String masterTxnRefNo, String channel);
	public ProductResponse fetchProduct(String productId, String masterTxnRefNo, String channel);
	public ProductResponse addProduct(@Valid AddProductRequest addProductRequest, String masterTxnRefNo,String channel);

}
