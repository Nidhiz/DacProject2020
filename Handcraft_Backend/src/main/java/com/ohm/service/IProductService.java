package com.ohm.service;

import java.util.List;
import java.util.Optional;

import com.ohm.pojos.Product;

public interface IProductService {
	List<Product> getAllProducts();

	Optional<Product> getProductDetails(Long productId);

	// add new product details
	Product addProductDetails(Product transientPOJO);

//update existing product details
	Product updateProductDetails(Long pId, Product detachedPOJO);

	String deleteProduct(Long pid);

	List<Product> getProductByState(String stateName);

	Product applyDiscount(Long productId, Product detachedPOJO, Long discountAmount);

	Long getProductsCount();

}
