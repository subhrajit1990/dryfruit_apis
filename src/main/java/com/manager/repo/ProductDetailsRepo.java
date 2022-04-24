package com.manager.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.Product;

/**
 * @author Troublem@ker
 */

@Repository
public interface ProductDetailsRepo extends CrudRepository<Product,Long> {

	ArrayList<Product> findTop3ByOrderByIdDesc();

	


}
 
