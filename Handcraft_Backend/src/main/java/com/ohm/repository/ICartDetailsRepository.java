package com.ohm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ohm.pojos.Cart;
import com.ohm.pojos.Product;

public interface ICartDetailsRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByCartId(Long cartId);

}
