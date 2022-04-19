/**
 * 
 */
package com.manager.service;

import org.springframework.stereotype.Component;

import com.manager.model.ProductRequest;



/**
 * @author Troublem@ker
 */

@Component
public interface IProductService {
	
	public void fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel);

}
