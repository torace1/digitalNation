package com.shop.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.model.database.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	//List<Product> findByName(String name); 
	@Query(value="select * from PRODUCT p where p.DENUMIRE_PRODUS like %:keyword%",nativeQuery = true)
	List<Product> findByKeyword(@Param("keyword") String keyword);
}
