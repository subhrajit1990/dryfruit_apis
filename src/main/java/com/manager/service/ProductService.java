/**
 * 
 */
package com.manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.domain.Product;
import com.manager.model.ProductRequest;
import com.manager.repo.ProductDetails;

/**
 * @author subhrajit
 *
 */
@Service
public class ProductService implements IProductService {

	private static final Logger logger = LogManager.getLogger(ProductService.class);

	@Autowired
	private ProductDetails productDetails;

	public void fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel) {
		Iterable<Product> prodDetails = productDetails.findAll();

		for (Product prd : prodDetails) {

			System.out.println("Final product data :: " + prd.getId());
			System.out.println("Final product data :: " + prd.getCategory().getDesc());
		}
	}

}
