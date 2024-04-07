package com.prashant.cartservice.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prashant.cartservice.dtos.FakeStoreCartDto;
import com.prashant.cartservice.exceptions.CartNotFoundException;
import com.prashant.cartservice.models.Cart;
@Service
public class FakeStoreCartService implements CartService{
    private RestTemplate restTemplate = new RestTemplate();
    public List<Cart> getAllCarts() {
        FakeStoreCartDto[] cartDtos = restTemplate.getForObject("https://fakestoreapi.com/carts", FakeStoreCartDto[].class);

        Cart[] carts = new Cart[cartDtos.length];
        for (int i = 0; i < cartDtos.length; i++) {
            carts[i] = new Cart();
            carts[i].setId(cartDtos[i].getId());
            carts[i].setUserId(cartDtos[i].getUserId());
            carts[i].setDate(cartDtos[i].getDate());
            carts[i].setProducts(cartDtos[i].getProducts());

        }
        return Arrays.asList(carts);
    }
    public Cart getCartById(Long id) {
        FakeStoreCartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
        if(cartDto == null){{
            throw new CartNotFoundException(id,"No carts found");
        }}
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        cart.setDate(cartDto.getDate());
        cart.setProducts(cartDto.getProducts());
        return cart;
    }
}
