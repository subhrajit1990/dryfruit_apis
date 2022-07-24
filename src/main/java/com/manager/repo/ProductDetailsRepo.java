package com.manager.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.Product;

/**
 * @author Troublem@ker
 */

@Repository
public interface ProductDetailsRepo extends JpaRepository<Product, Long> {
	Optional<Product> findBySku(String productId);

	List<Product> findTop6By(Sort descending);

}
