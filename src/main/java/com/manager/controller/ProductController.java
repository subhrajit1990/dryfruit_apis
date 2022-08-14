package com.manager.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.manager.model.AddCategoriesRequestWrapper;
import com.manager.model.AddProductRequestWrapper;
import com.manager.model.CategoriesResponse;
import com.manager.model.CategoriesResponseWrapper;
import com.manager.model.GetCategoriesReqestWrapper;
import com.manager.model.ProductRequestWrapper;
import com.manager.model.ProductResponse;
import com.manager.model.ProductResponseWrapper;
import com.manager.model.ResponseHeader;
import com.manager.service.ProductService;
import com.manager.utils.CommonUtils;
import com.manager.utils.CustomExceptionFromService;
import com.manager.utils.GenericException;
import com.manager.utils.NoRecordException;
import com.manager.utils.commonConstants;

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
	@ApiResponses({ @ApiResponse(code = 200, message = "All Product API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "All Products API is not reachable") })
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
		ProductResponse productResponse = new ProductResponse();
		try {
		productResponse = productService.fetchAllProducts(productRequestWrapper.getProductRequest(),
				masterTxnRefNo, channel);
		CommonUtils.generateHeaderForSuccess(responseHeader);
		} catch(Exception e) {
			logger.error("Error occurred during fetch products in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR, "Unable to process the request at this moment, please try after some time.");
		}
		
		productResponseWrapper.setResponseHeader(responseHeader);
		productResponseWrapper.setProductReponse(productResponse);
		logger.info("Finished the execution for the fetch products request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}
	
	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Recent Product API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Recent Products API is not reachable") })
	@ApiOperation(value = "Recent Products", notes = "Recent Products")
	@GetMapping(value = "/recentProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> recentProducts(@RequestHeader("masterTxnRefNo") String masterTxnRefNo,
			@RequestHeader("channel") String channel) {
		logger.info(
				"Started the execution for the fetch recent products request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		ProductResponse productResponse = new ProductResponse();
		try {
			productResponse = productService.fetchRecentProducts(masterTxnRefNo, channel);
			CommonUtils.generateHeaderForSuccess(responseHeader);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred during fetch recent products in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");
		}

		productResponseWrapper.setResponseHeader(responseHeader);
		productResponseWrapper.setProductReponse(productResponse);
		logger.info("Finished the execution for the fetch recent products request with masterTxnRefNo :: "
				+ masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}

	
	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Product API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "View Product API is not reachable") })
	@ApiOperation(value = "View Products", notes = "View Product")
	@GetMapping(value = "/viewProduct/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> product(
			@PathVariable String productId,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the fetch product request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		ProductResponse productResponse = new ProductResponse();
		try {
		productResponse = productService.fetchProductBySku(productId,
				masterTxnRefNo, channel);
		CommonUtils.generateHeaderForSuccess(responseHeader);
		productResponseWrapper.setProductReponse(productResponse);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred during fetch product in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR, "Unable to process the request at this moment, please try after some time.");
		}
		
		productResponseWrapper.setResponseHeader(responseHeader);
		
		logger.info("Finished the execution for the fetch product request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}

	
	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Product API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Contact me API is not reachable") })
	@ApiOperation(value = "Add Products", notes = "Add Product")
	@PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> addProduct(
			@RequestBody @Valid AddProductRequestWrapper addProductRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the add request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		ProductResponse productResponse = new ProductResponse();
		try {
			productResponse = productService.addProduct(addProductRequestWrapper.getAddProductRequest(), masterTxnRefNo,
					channel);
			CommonUtils.generateHeaderForSuccess(responseHeader);
			productResponseWrapper.setProductReponse(productResponse);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred during add product in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");
		}

		productResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the add product request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}
	/* Products -- Ends */

	/* categories -- Starts */

	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Add Categories API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Add Categories for Product API is not reachable") })
	@ApiOperation(value = "Add Categories", notes = "Add Categories for Product")
	@PostMapping(value = "/addCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> addCategories(
			@RequestBody @Valid AddCategoriesRequestWrapper addCategoriesRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the add categories request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		try {
			productService.addCategories(addCategoriesRequestWrapper.getAddCategoriesRequest(), masterTxnRefNo,
					channel);
			CommonUtils.generateHeaderForSuccess(responseHeader);
		} catch (Exception e) {
			logger.error("Error occurred during add categories in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");
		}

		productResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the add categories request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}

	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Get Categories API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "View Categories API is not reachable") })
	@ApiOperation(value = "View Categories", notes = "View Categories")
	@PostMapping(value = "/viewCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriesResponseWrapper> product(
			@RequestBody @Valid GetCategoriesReqestWrapper getCategoriesReqestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the get categories request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		CategoriesResponseWrapper categoriesResponseWrapper = new CategoriesResponseWrapper();

		try {
			Optional<CategoriesResponse> cateResponse = productService
					.fetchCategories(getCategoriesReqestWrapper.getGetCategoriesRequest(), masterTxnRefNo, channel);
			if (cateResponse.isPresent()) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
				categoriesResponseWrapper.setCategoriesResponse(cateResponse.get());
			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No record found");
			}
		} catch (Exception e) {
			logger.error("Error occurred during get categories in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");
		}

		categoriesResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the get categories request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(categoriesResponseWrapper, httpStatus);

	}

	@PreAuthorize("hasRole('USER')")
	@ApiResponses({ @ApiResponse(code = 200, message = "Add Categories API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Update Categories for Product API is not reachable") })
	@ApiOperation(value = "Update Categories", notes = "Update Categories for Product")
	@PatchMapping(value = "/updateCategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponseWrapper> updateCategories(
			@RequestBody @Valid AddCategoriesRequestWrapper updateCategoriesRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the update categories request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ProductResponseWrapper productResponseWrapper = new ProductResponseWrapper();
		try {
			productService.updateCategories(updateCategoriesRequestWrapper.getAddCategoriesRequest(), masterTxnRefNo,
					channel);
			CommonUtils.generateHeaderForSuccess(responseHeader);
		} catch (CustomExceptionFromService e) {
			throw new NoRecordException(commonConstants.NORECORD, "No record found");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred during update categories in rest layer :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");
		}

		productResponseWrapper.setResponseHeader(responseHeader);

		logger.info(
				"Finished the execution for the update categories request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(productResponseWrapper, httpStatus);

	}

	/* categories -- Ends */

}
