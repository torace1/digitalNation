package com.shop.model.service;

import java.util.Optional;

import com.shop.model.database.Product;

public interface ProductService {

	public Iterable<Product> getAllProducts();
	
	public Optional<Product> getProduct( int id);
	
}
