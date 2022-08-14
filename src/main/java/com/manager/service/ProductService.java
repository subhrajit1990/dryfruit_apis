/**
 * 
 */
package com.manager.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manager.domain.Product;
import com.manager.domain.ProductCategoryDomain;
import com.manager.domain.ProductImage;
import com.manager.domain.ProductInventory;
import com.manager.domain.SubCategoriesDomain;
import com.manager.model.AddCategoriesRequest;
import com.manager.model.AddProductRequest;
import com.manager.model.GetCategoriesRequest;
import com.manager.model.ProductDetails;
import com.manager.model.ProductInv;
import com.manager.model.ProductRequest;
import com.manager.model.ProductResponse;
import com.manager.model.SubCategoriesResponse;
import com.manager.repo.ProductCategoryRepo;
import com.manager.repo.ProductDetailsRepo;
import com.manager.utils.GenericException;
import com.manager.utils.NoRecordException;
import com.manager.utils.commonConstants;
import com.manager.utils.CustomExceptionFromService;
import com.manager.model.CategoriesResponse;

/**
 * @author subhrajit
 *
 */
@Service
public class ProductService implements IProductService {

	private static final Logger logger = LogManager.getLogger(ProductService.class);

	@Autowired
	private ProductDetailsRepo productDetails;

	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	@Transactional
	public ProductResponse fetchAllProducts(ProductRequest productRequest, String masterTxnRefNo, String channel) {

		/**
		 * Data manipulation is not required, only to fetch and store hence using Array
		 * List
		 **/
		ProductResponse productResponse = new ProductResponse();

		try {
			Pageable paging = PageRequest.of(productRequest.getPageNo(), productRequest.getPageSize());

			Page<Product> prodDetails = productDetails.findAll(paging);
			logger.info("All Products :: " + prodDetails);

			if (prodDetails.hasContent()) {
				List<ProductDetails> prdDtls = Collections.synchronizedList(new ArrayList<>());

				prodDetails.stream().forEach(prds -> {
					ProductDetails gp = new ProductDetails();
					gp.setDescription(prds.getDesc());
					gp.setTitle(prds.getName());
					gp.setImage(prds.getProductImage().getProductImg1());
					gp.setImage2(prds.getProductImage().getProductImg2());
					gp.setImage3(prds.getProductImage().getProductImg3());
					gp.setSku(prds.getSku());

					if (prds.getInventory().size() > 0) {
						List<ProductInv> prdInvDtls = Collections.synchronizedList(new ArrayList<>());

						(prds.getInventory()).stream().forEach(prdInvs -> {
							ProductInv productInv = new ProductInv();
							productInv.setPrice(prdInvs.getPrice());
							productInv.setQuantity(prdInvs.getQuantity());
							productInv.setVariantDesc(prdInvs.getVariantDesc());
							productInv.setVariantName(prdInvs.getVariantName());
							prdInvDtls.add(productInv);
						});
						gp.setProductInv(prdInvDtls);

					}

					prdDtls.add(gp);

				});

				productResponse.setProductDetails(prdDtls);

			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No Record Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred during fetch products :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");

		}
		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;

	}

	@Transactional
	public ProductResponse fetchRecentProducts(String masterTxnRefNo, String channel) {
		/**
		 * Data manipulation is not required, only to fetch and store hence using Array
		 * List
		 **/
		ProductResponse productResponse = new ProductResponse();

		List<Product> tempProduct = productDetails.findTop6By(Sort.by("modifiedDt").descending());
		ArrayList<Product> prodDtls = new ArrayList<>();
		logger.info("Recent Products :: " + prodDtls);
		List<ProductDetails> prdDtls = Collections.synchronizedList(new ArrayList<>());
		if (!tempProduct.isEmpty()) {
			tempProduct.stream().forEach(recentprds -> {

				ProductDetails gp = new ProductDetails();
				gp.setDescription(recentprds.getDesc());
				gp.setTitle(recentprds.getName());
				gp.setImage(recentprds.getProductImage().getProductImg1());
				gp.setImage2(recentprds.getProductImage().getProductImg2());
				gp.setImage3(recentprds.getProductImage().getProductImg3());
				gp.setSku(recentprds.getSku());

				if (recentprds.getInventory().size() > 0) {
					List<ProductInv> prdinvs = Collections.synchronizedList(new ArrayList<>());

					recentprds.getInventory().stream().forEach(invs -> {
						ProductInv productInv = new ProductInv();
						productInv.setPrice(invs.getPrice());
						productInv.setQuantity(invs.getQuantity());
						productInv.setVariantDesc(invs.getVariantDesc());
						productInv.setVariantName(invs.getVariantName());
						prdinvs.add(productInv);
					});

					gp.setProductInv(prdinvs);

				}
				prdDtls.add(gp);
			});
			productResponse.setProductDetails(prdDtls);

		} else {
			throw new NoRecordException(commonConstants.NORECORD, "No Record Found");

		}

		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;
	}

	@Transactional
	public ProductResponse fetchProductBySku(String productId, String masterTxnRefNo, String channel) {

		/**
		 * Data manipulation is not required, only to fetch and store hence using Array
		 * List
		 **/
		Optional<Product> prodDtls = null;
		ProductResponse productResponse = new ProductResponse();

		try {
			prodDtls = productDetails.findBySku(productId);
			logger.info("Products :: " + prodDtls);
			ArrayList<ProductDetails> tempProduct = new ArrayList<>();
			if (prodDtls.isPresent()) {

				ProductDetails productDetails = new ProductDetails();
				productDetails.setDescription(prodDtls.get().getDesc());
				productDetails.setImage(prodDtls.get().getProductImage().getProductImg1());
				productDetails.setImage2(prodDtls.get().getProductImage().getProductImg2());
				productDetails.setImage3(prodDtls.get().getProductImage().getProductImg3());
				productDetails.setTitle(prodDtls.get().getName());
				productDetails.setSku(prodDtls.get().getSku());

				if (prodDtls.get().getInventory().size() > 0) {
					List<ProductInv> prdinvs = Collections.synchronizedList(new ArrayList<>());
					(prodDtls.get().getInventory()).stream().forEach(prdInvs -> {
						ProductInv productInv = new ProductInv();
						productInv.setPrice(prdInvs.getPrice());
						productInv.setQuantity(prdInvs.getQuantity());
						productInv.setVariantDesc(prdInvs.getVariantDesc());
						productInv.setVariantName(prdInvs.getVariantName());
						prdinvs.add(productInv);
					});
					productDetails.setProductInv(prdinvs);
				}

				tempProduct.add(productDetails);
				productResponse.setProductDetails(tempProduct);

			} else {
				throw new NoRecordException(commonConstants.NORECORD, "No Record Found");
			}

		} catch (Exception e) {
			logger.error("Error occurred during fetch products :: " + e.getStackTrace());
			throw new GenericException(commonConstants.PROCESSINGREQUESTERROR,
					"Unable to process the request at this moment, please try after some time.");

		}
		logger.info("Exiting the fetch products  :: " + productResponse.toString());
		return productResponse;
	}

	public ProductResponse addProduct(@Valid AddProductRequest addProductRequest, String masterTxnRefNo,
			String channel) {
		Product product = new Product();
		//ProductCategoryDomain productCategory = new ProductCategoryDomain();
		ProductImage productImage = new ProductImage();
		product.setCreatedBy(addProductRequest.getCreatedBy());
		product.setIsActive(addProductRequest.getIsActive());
		product.setName(addProductRequest.getTitle());
		product.setSku(addProductRequest.getSku());
		product.setDesc(addProductRequest.getProductDescription());
		product.setDiscountId(addProductRequest.getDiscountId());
		productImage.setCreatedBy(addProductRequest.getCreatedBy());
		productImage.setIsActive(addProductRequest.getIsActive());
		productImage.setProductImg1(addProductRequest.getProductImg1());
		productImage.setProductImg2(addProductRequest.getProductImg2());
		productImage.setProductImg3(addProductRequest.getProductImg3());
		productImage.setProduct(product);

		if (addProductRequest.getProductInv().size() > 0) {

			Set<ProductInventory> prdInventories = new HashSet<>();
			addProductRequest.getProductInv().stream().forEach(inventories -> {
				ProductInventory productInventory = new ProductInventory();
				productInventory.setPrice(inventories.getPrice());
				productInventory.setQuantity(inventories.getQuantity());
				productInventory.setVariantDesc(inventories.getVariantDesc());
				productInventory.setVariantName(inventories.getVariantName());
				productInventory.setProducts(product);
				prdInventories.add(productInventory);
			});

			product.setInventory(prdInventories);

		}
		product.setProductImage(productImage);
		productDetails.save(product);
		return null;
	}

	@Transactional
	public void addCategories(AddCategoriesRequest addCategoriesRequest, String masterTxnRefNo, String channel) {

		ProductCategoryDomain productCategory = new ProductCategoryDomain();

		productCategory.setCreatedBy(addCategoriesRequest.getCreatedBy());
		productCategory.setDesc(addCategoriesRequest.getDesription());
		productCategory.setIsActive(addCategoriesRequest.getIsActive());
		productCategory.setProductType(addCategoriesRequest.getProductType());

		Set<SubCategoriesDomain> listSubCategories = new HashSet<>();
		addCategoriesRequest.getSubCategories().stream().forEach(categories -> {
			SubCategoriesDomain subCategoriesDomain = new SubCategoriesDomain();
			subCategoriesDomain.setCreatedBy(categories.getCreatedBy());
			subCategoriesDomain.setDesc(categories.getDesription());
			subCategoriesDomain.setIsActive(categories.getIsActive());
			subCategoriesDomain.setProductSubCategory(categories.getProductSubCategory());
			subCategoriesDomain.setCategory(productCategory);
			listSubCategories.add(subCategoriesDomain);
		});
		productCategory.setSubCategories(listSubCategories);
		productCategoryRepo.save(productCategory);
	}

	@Transactional
	public Optional<CategoriesResponse> fetchCategories(GetCategoriesRequest getCategoriesRequest,
			String masterTxnRefNo, String channel) {
		Pageable paging = PageRequest.of(getCategoriesRequest.getPageNo(), getCategoriesRequest.getPageSize());
		Page<ProductCategoryDomain> tempGetCategories = productCategoryRepo.findAll(paging);
		CategoriesResponse categoriesResponse = new CategoriesResponse();
		if (tempGetCategories.hasContent()) {
			List<SubCategoriesResponse> subCategoriesResponse = new ArrayList<>();
			tempGetCategories.getContent().stream().forEach(cate -> {
				categoriesResponse.setDesc(cate.getDesc());
				categoriesResponse.setIsActive(cate.getIsActive());
				categoriesResponse.setProductType(cate.getProductType());
				categoriesResponse.setpId(String.valueOf(cate.getId()));

				cate.getSubCategories().stream().forEach(subCate -> {
					SubCategoriesResponse subCategoriesRes = new SubCategoriesResponse();
					subCategoriesRes.setDesc(subCate.getDesc());
					subCategoriesRes.setIsActive(subCate.getIsActive());
					subCategoriesRes.setProductSubCategory(subCate.getProductSubCategory());
					subCategoriesResponse.add(subCategoriesRes);
				});

				categoriesResponse.setSubCategoriesResponse(subCategoriesResponse);

			});
		}

		Optional<CategoriesResponse> optionalRes = Optional.of(categoriesResponse);

		return optionalRes;
	}

	public void updateCategories(AddCategoriesRequest addCategoriesRequest, String masterTxnRefNo, String channel)
			throws CustomExceptionFromService {
		Optional<ProductCategoryDomain> tmpGetCategories = productCategoryRepo
				.findById(Long.parseLong(addCategoriesRequest.getpId()));
		if (tmpGetCategories.isPresent()) {
			tmpGetCategories.get().setModifiedBy(addCategoriesRequest.getModifiedBy());
			if (!addCategoriesRequest.getProductType().isEmpty()) {
				tmpGetCategories.get().setProductType(addCategoriesRequest.getProductType());
			} else if (!addCategoriesRequest.getIsActive().isEmpty()) {
				tmpGetCategories.get().setIsActive(addCategoriesRequest.getIsActive());
			} else if (!addCategoriesRequest.getDesription().isEmpty()) {
				tmpGetCategories.get().setDesc(addCategoriesRequest.getDesription());
			}

			if (addCategoriesRequest.getSubCategories().size() > 0) {
				Set<SubCategoriesDomain> listSubCategories = new HashSet<>();
				addCategoriesRequest.getSubCategories().stream().forEach(categories -> {
					SubCategoriesDomain subCategoriesDomain = new SubCategoriesDomain();
					if (!categories.getDesription().isEmpty()) {
						subCategoriesDomain.setDesc(categories.getDesription());

					} else if (!categories.getIsActive().isEmpty()) {
						subCategoriesDomain.setIsActive(categories.getIsActive());

					} else if (!categories.getProductSubCategory().isEmpty()) {
						subCategoriesDomain.setProductSubCategory(categories.getProductSubCategory());

					}

					subCategoriesDomain.setModifiedBy(categories.getModifiedBy());
					listSubCategories.add(subCategoriesDomain);
				});
				tmpGetCategories.get().setSubCategories(listSubCategories);

			}

			productCategoryRepo.save(tmpGetCategories.get());
		} else {
			throw new CustomExceptionFromService(commonConstants.NORECORD, "No record found");
		}

	}

}
