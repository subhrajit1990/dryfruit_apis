package com.manager.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	private Long id;
//	@EmbeddedId
//	private ProductsId productsId;

	@Column(name = "prod_id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId;

	@Id
	@Column(name = "sku", updatable = false)
	private String sku;

	@Column(name = "product_name")
	private String name;

	@Column(name = "description")
	private String desc;


	@Column(name = "discount_id")
	private int discountId;

	@UpdateTimestamp
	@Column(name = "modified_dt")
	private Timestamp modifiedDt;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "isActive")
	private String isActive;
 
	@OneToOne(mappedBy = "product",fetch = FetchType.LAZY,
			 cascade = CascadeType.ALL)
	private ProductImage productImage;

	@OneToMany(mappedBy = "products",fetch = FetchType.LAZY,
			 cascade = CascadeType.ALL)
	private Set<ProductInventory> inventory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getDiscountId() {
		return discountId;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public Timestamp getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Timestamp modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}

	public Set<ProductInventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<ProductInventory> inventory) {
		this.inventory = inventory;
	}

}
