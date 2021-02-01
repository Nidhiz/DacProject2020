package com.ohm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ohm.pojos.Product;

import java.util.*;

public interface IProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByProductId(Long pId);
	List<Product> findAllByProductState(String stateName);
	
	 /*@Query("SELECT p FROM Product p WHERE p.productState = ?1")
	Product findByProductState(String stateName);*/

	//Optional<Product> findByProductName(String pName);


}
