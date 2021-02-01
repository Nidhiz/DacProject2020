package com.ohm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohm.custom_excs.ProductNotFoundException;
import com.ohm.pojos.Cart;
import com.ohm.pojos.Product;
import com.ohm.repository.ICartDetailsRepository;

@Service
@Transactional
public class CartServiceImpl implements ICartDetailsService {

	@Autowired
	ICartDetailsRepository cartRepo;

	@Override
	public Iterable<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> getDetailsByCartId(Long cartId) {
		// TODO Auto-generated method stub
		return cartRepo.findByCartId(cartId);
	}

	@Override
	public Cart addCartDetails(Cart transientPOJO) {
		transientPOJO.setTotalAmount(transientPOJO.getProduct().getPrice() * transientPOJO.getQuantity());
		return cartRepo.save(transientPOJO);
	}

	@Override
	public Cart updateQuantity( Cart c) {
		// check if product exist
		Optional<Cart> cartExists = cartRepo.findByCartId(c.getCartId());
		if (cartExists.isPresent()) {
			Cart cart = cartExists.get();
			
			cart.setQuantity(c.getQuantity());
			cart.setTotalAmount(c.getQuantity()*c.getProduct().getPrice());
			/*product.setProductName(p1.getProductName());
			product.setDescription(p1.getDescription());
			product.setPrice(p1.getPrice());
			product.setCategory(p1.getCategory());
			product.setImageUrl(p1.getImageUrl());
			product.setProductState(p1.getProductState());*/

			return cart;
		}

		throw new ProductNotFoundException("Invalid Product ID");
	}

	@Override
	public void removeCart(Long cid) {
		cartRepo.deleteById(cid);
		
	}

	@Override
	public void deleteAllCart() {
		cartRepo.deleteAll();

	}

	@Override
	public List<Cart> getAllCartItems() {
		return cartRepo.findAll();
	}

	@Override
	public Long getCartCount() {
		return cartRepo.count();
	}

}