package com.ohm.service;



import java.util.List;
import java.util.Optional;

import com.ohm.pojos.Cart;
import com.ohm.pojos.Product;

public interface ICartDetailsService {            
    public Iterable<Cart> findAll();
	
	Cart addCartDetails(Cart transientPOJO);

	Cart updateQuantity( Cart c);

	Optional<Cart> getDetailsByCartId(Long cartId);

	public void removeCart(Long cid);

	public void deleteAllCart();

	public List<Cart> getAllCartItems();

	public Long getCartCount();

    
}
