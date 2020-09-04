package com.test.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.productservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> { 
	
}
