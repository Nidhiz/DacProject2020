package com.ohm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohm.custom_excs.ProductNotFoundException;
import com.ohm.pojos.Product;
import com.ohm.service.IProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
	// dependency
	@Autowired
	private IProductService service;

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping
	public ResponseEntity<?> listAllProducts() {
		System.out.println("in list all products");

		List<Product> products = service.getAllProducts();
		if (products.isEmpty())

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long productId) {
		System.out.println("in get prod details " + productId);
		// invoke service method
		Optional<Product> productDetails = service.getProductDetails(productId);
		//
		if (productDetails.isPresent())
			return new ResponseEntity<>(productDetails.get(), HttpStatus.OK);
		else
			throw new ProductNotFoundException("Product with entry " + productId + " Not Found");

	}

	// request handling method to create a new product : post
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product p) {
		System.out.println("in add product " + p);
		try {
			Product savedProduct = service.addProductDetails(p);
			return new ResponseEntity<>(savedProduct, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProductDetails(@PathVariable Long productId, @RequestBody Product p) {
		System.out.println("in update " + productId + " " + p);
		try {
			Product updatedDetails = service.updateProductDetails(productId, p);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long pid) {
		System.out.println("in del product " + pid);
		service.deleteProduct(pid);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
	@GetMapping("/state/{productState}")
	public ResponseEntity<?> getProductDetailsByState(@PathVariable String productState) {
		System.out.println("in get prod state" + productState);
		// invoke service method
		List<Product> productByState = service.getProductByState(productState);
		
		if (productByState.isEmpty())

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(productByState, HttpStatus.OK);
		

	}
	

}
