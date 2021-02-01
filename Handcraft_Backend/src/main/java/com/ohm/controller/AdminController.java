package com.ohm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohm.pojos.Product;
import com.ohm.pojos.ROLENAME;
import com.ohm.pojos.User;
import com.ohm.service.IProductService;
import com.ohm.service.IUserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService uservice;
	
	@Autowired
	private IProductService pservice;
	
	@GetMapping("/role/{role}")
	public ResponseEntity<?> getUserByRole(@PathVariable ROLENAME role) {
		System.out.println("in get user By Role" + role);
		// invoke service method
		List<User> userByRole = uservice.getUserByRole(role);
		
		if (userByRole.isEmpty())

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(userByRole, HttpStatus.OK);
		
	}
	
	@PutMapping("/{productId}/{discountPercent}")
	public ResponseEntity<?> updateProductByDiscount(@PathVariable Long productId, @PathVariable Long discountPercent, @RequestBody Product p) {
		System.out.println("in update " + productId + " " + p);
		try {
			Product updatedDetails = pservice.applyDiscount(productId, p, discountPercent);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} 
		
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{sid}")
	public ResponseEntity<?> deleteSupplier(@PathVariable Long sid) {
		System.out.println("in del product " + sid);
		uservice.deleteSupplier(sid);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
	@GetMapping("/productCount")
	public ResponseEntity<Long> getProductsCount() {
		
		Long pCount = pservice.getProductsCount();
		System.out.println("product count :  "+pCount);
		
		if (pCount==0)

			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the count
		return new ResponseEntity<Long>(pCount, HttpStatus.OK);
	
	}
	
	
	@GetMapping("/roleCount/{role}")
	public ResponseEntity<Long> getSupplierUserCount(@PathVariable ROLENAME role) {
		
		Long uCount = uservice.countUserbyRole(role);
		System.out.println("user count :  "+uCount);
		
		if (uCount==0)

			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the count
		return new ResponseEntity<Long>(uCount, HttpStatus.OK);
	
	}
	
	
}
