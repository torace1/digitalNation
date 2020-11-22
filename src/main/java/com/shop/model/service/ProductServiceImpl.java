package com.shop.model.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.database.Product;
import com.shop.model.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired ProductRepository productRepo;

	@Override
	public Iterable<Product> getAllProducts() {
		 return productRepo.findAll();
	}
	
	
	public Optional<Product> getProduct( int id) {
			return productRepo.findById(id);
	}
	
}
