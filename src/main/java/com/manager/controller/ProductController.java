package com.manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.manager.model.ContactMeRequestWrapper;
import com.manager.model.ContactMeResponse;
import com.manager.model.ContactMeResponseWrapper;
import com.manager.model.ProductRequestWrapper;
import com.manager.model.ProductResponseWrapper;
import com.manager.model.ResponseHeader;
import com.manager.service.MiscellaneousService;
import com.manager.service.ProductService;
import com.manager.utils.CommonUtils;

/**
 * @author subhrajit
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/product/api/")
@Api(tags = "Products", value = "/product/api/")
public class ProductController {

	private static final Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Contact me API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Contact me API is not reachable") })
	@ApiOperation(value = "All", notes = "All Products")
	@PostMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> fetchProducts(
			@RequestBody ProductRequestWrapper productRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the fetch products request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		productService.fetchAllProducts(productRequestWrapper.getProductRequest(),
				masterTxnRefNo, channel);
		

		logger.info("Finished the execution for the fetch products request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}

}