package com.manager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.Product;

/**
 * @author Troublem@ker
 */

@Repository
public interface ProductDetails extends CrudRepository<Product,Long> {

	


}
 
