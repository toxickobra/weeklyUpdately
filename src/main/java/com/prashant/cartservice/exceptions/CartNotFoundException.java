package com.prashant.cartservice.exceptions;

public class CartNotFoundException extends RuntimeException {
    private Long id;

    public CartNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
