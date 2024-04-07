package com.prashant.cartservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.cartservice.models.Cart;
import com.prashant.cartservice.services.CartService;



@RestController
public class CartController {
    private CartService cartService;

    CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

}
