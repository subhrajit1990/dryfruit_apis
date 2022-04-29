/**
 * 
 */
package com.manager.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.domain.Product;
import com.manager.model.ProductDetails;
import com.manager.model.ProductRequest;
import com.manager.model.ProductResponse;
import com.manager.repo.ProductDetailsRepo;
import com.manager.utils.GenericException;
import com.manager.utils.NoRecordException;
import com.manager.utils.commonConstants;

/**
 * @author subhrajit
 *
 */
@Service
public class ProductService implements IProductService {

	private static final Logger logger = LogManager.getLogger(ProductService.class);

	@Autowired
	private ProductDetailsRepo productDetails;

	@Transactional
	public ProductResponse fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel) {
		
		/**
		 * Data manipulation is not required, only to fetch and store hence
		 * using Array List
		 **/
		ArrayList<Product> prodDtls = null;
		ProductResponse productResponse = new ProductResponse();

		try {
			prodDtls = (ArrayList<Product>) productDetails.findAll();
			logger.info("Products :: " + prodDtls);

			if (!prodDtls.isEmpty()) {
				List<ProductDetails> prdDtls = Collections.synchronizedList(new ArrayList<>());

				Iterator<Product> itr = prodDtls.iterator();
				while (itr.hasNext()) {
					ProductDetails gp = new ProductDetails();
					Product ct = itr.next();
					gp.setCategory(ct.getCategory().getName());
					gp.setDescription(ct.getDesc());
					gp.setImage(ct.getImageUrl());
					gp.setPrice(ct.getPrice());
					gp.setTitle(ct.getName());
					prdDtls.add(gp);

				}
				productResponse.setProductDetails(prdDtls);;
				
			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No Record Found");
			}

		} catch (Exception e) {
			logger.error("Error occurred during fetch products :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR, "Unable to process the request at this moment, please try after some time.");
			
		}
		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;
	}

	public ProductResponse fetchRecentProducts(ProductRequest productRequest, String masterTxnRefNo, String channel) {
		/**
		 * Data manipulation is not required, only to fetch and store hence
		 * using Array List
		 **/
		ArrayList<Product> prodDtls = null;
		ProductResponse productResponse = new ProductResponse();

		try {
			prodDtls = (ArrayList<Product>) productDetails.findTop3ByOrderByIdDesc();
			logger.info("Products :: " + prodDtls);

			if (!prodDtls.isEmpty()) {
				List<ProductDetails> prdDtls = Collections.synchronizedList(new ArrayList<>());

				Iterator<Product> itr = prodDtls.iterator();
				while (itr.hasNext()) {
					ProductDetails gp = new ProductDetails();
					Product ct = itr.next();
					gp.setCategory(ct.getCategory().getName());
					gp.setDescription(ct.getDesc());
					gp.setImage(ct.getImageUrl());
					gp.setPrice(ct.getPrice());
					gp.setTitle(ct.getName());
					prdDtls.add(gp);

				}
				productResponse.setProductDetails(prdDtls);;
				
			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No Record Found");
			}

		} catch (Exception e) {
			logger.error("Error occurred during fetch products :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR, "Unable to process the request at this moment, please try after some time.");
			
		}
		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;
	}
	
	@Transactional
	public ProductResponse fetchProduct(ProductRequest productRequest, String masterTxnRefNo, String channel) {
		
		/**
		 * Data manipulation is not required, only to fetch and store hence
		 * using Array List
		 **/
		ArrayList<Product> prodDtls = null;
		ProductResponse productResponse = new ProductResponse();

		try {
			prodDtls = (ArrayList<Product>) productDetails.findBySku(productRequest.getSku());
			logger.info("Products :: " + prodDtls);

			if (!prodDtls.isEmpty()) {
				List<ProductDetails> prdDtls = Collections.synchronizedList(new ArrayList<>());

				Iterator<Product> itr = prodDtls.iterator();
				while (itr.hasNext()) {
					ProductDetails gp = new ProductDetails();
					Product ct = itr.next();
					gp.setCategory(ct.getCategory().getName());
					gp.setDescription(ct.getDesc());
					gp.setImage(ct.getImageUrl());
					gp.setPrice(ct.getPrice());
					gp.setTitle(ct.getName());
					prdDtls.add(gp);

				}
				productResponse.setProductDetails(prdDtls);;
				
			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No Record Found");
			}

		} catch (Exception e) {
			logger.error("Error occurred during fetch products :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR, "Unable to process the request at this moment, please try after some time.");
			
		}
		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;
	}


}
