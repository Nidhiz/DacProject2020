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

import com.ohm.pojos.Cart;
import com.ohm.pojos.Product;
import com.ohm.service.ICartDetailsService;
import com.ohm.service.IProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cart")
public class CartDetailsController {
	// dependency
	@Autowired
	private ICartDetailsService cartService;
	
	@Autowired
	private IProductService pService;

	public CartDetailsController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@GetMapping
	public ResponseEntity<?> listAllCartItems() {
		System.out.println("in list all Carts");

		List<Cart> cartItems = cartService.getAllCartItems();
		if (cartItems.isEmpty())

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(cartItems, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Cart items) {
		System.out.println("in add to cart " + items);
		try {
			Cart savedCart = cartService.addCartDetails(items);
						
			return new ResponseEntity<>(savedCart, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping()
	public ResponseEntity<?> updateQuantityDetails( @RequestBody Cart c) {
		//System.out.println("in update " + cartId + " " + c);
		try {
			Cart updatedCartDetails = cartService.updateQuantity(c);
			return new ResponseEntity<>(updatedCartDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<?> removeCartItem(@PathVariable Long cid) {
		System.out.println("in del Cart item " + cid);
		cartService.removeCart(cid);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	
	
	@DeleteMapping()
	public ResponseEntity<?> deleteAllCartItem() {
		System.out.println("in del ALL Cart item ");
		cartService.deleteAllCart();
		System.out.println("AllCart Item Deleted");
		return new ResponseEntity<>(HttpStatus.OK) ;

	}
	
	@GetMapping("/cartCount")
	public ResponseEntity<Long> getCartCount() {
		
		Long cCount = cartService.getCartCount();
		System.out.println("cart count :  "+cCount);
	
		// in case of non empty list : OK, send the count
		return new ResponseEntity<Long>(cCount, HttpStatus.OK);
	
	}
}

