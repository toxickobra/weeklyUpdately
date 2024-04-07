package com.prashant.cartservice.services;

import java.util.List;

import com.prashant.cartservice.models.Cart;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(Long id);
}
