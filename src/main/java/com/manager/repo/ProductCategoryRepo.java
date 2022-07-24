package com.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.ProductCategoryDomain;

/**
 * @author Troublem@ker
 */

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategoryDomain,Long> {

}
 
