/**
 * 
 */
package com.manager.service;

import org.springframework.stereotype.Component;

import com.manager.model.ProductRequest;
import com.manager.model.ProductResponse;



/**
 * @author Troublem@ker
 */

@Component
public interface IProductService {
	
	public ProductResponse fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel);

}
