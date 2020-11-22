package com.shop.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.shop.model.database.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{

}
