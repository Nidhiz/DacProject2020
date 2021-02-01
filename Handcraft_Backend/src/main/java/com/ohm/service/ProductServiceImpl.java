package com.ohm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohm.pojos.Product;
import com.ohm.repository.IProductRepository;
import com.ohm.custom_excs.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository repo;

	@Override

	public List<Product> getAllProducts() {
		System.out.println("dao impl class" + repo.getClass().getName());
		return repo.findAll();
	}

	@Override
	public Optional<Product> getProductDetails(Long pId) {
		return repo.findByProductId(pId);
	}

	@Override
	public Product addProductDetails(Product transientPOJO) {
		return repo.save(transientPOJO);
	}

	@Override
	public Product updateProductDetails(Long pId, Product p1) {
		// check if product exist
		Optional<Product> p = repo.findByProductId(pId);
		if (p.isPresent()) {
			Product product = p.get();
			product.setProductName(p1.getProductName());
			product.setDescription(p1.getDescription());
			product.setPrice(p1.getPrice());
			product.setCategory(p1.getCategory());
			product.setImageUrl(p1.getImageUrl());
			product.setProductState(p1.getProductState());

			return product;
		}

		throw new ProductNotFoundException("Invalid Product ID");
	}

	@Override
	public String deleteProduct(Long productId) {
		repo.deleteById(productId);
		return "Product with ID=" + productId + " deleted...";
	}

	@Override
	public List<Product> getProductByState(String stateName) {
		List<Product> p = repo.findAllByProductState(stateName);
		return p;
	}

	@Override
	public Product applyDiscount(Long productId, Product p1, Long discountPercent) {
		// check if product exist
		Optional<Product> p = repo.findByProductId(productId);
		if (p.isPresent()) {
			Product product = p.get();
			product.setProductName(p1.getProductName());
			product.setDescription(p1.getDescription());

			/* discounted_price = original_price - (original_price * discount / 100) */
			Double discountCalculate = (p1.getPrice() * discountPercent / 100);
			Double discountedPrice = p1.getPrice() - discountCalculate;

			product.setPrice(discountedPrice);
			
			System.out.println("Discount Calculate "+discountCalculate+ "Discount Price " +discountedPrice);
			product.setCategory(p1.getCategory());
			product.setImageUrl(p1.getImageUrl());
			product.setProductState(p1.getProductState());

			return product;
		}

		throw new ProductNotFoundException("Invalid Product ID");
	}

	
	public Long getProductsCount() {
		System.out.println("Count product class" + repo.getClass().getName());
		return repo.count();
	}

}