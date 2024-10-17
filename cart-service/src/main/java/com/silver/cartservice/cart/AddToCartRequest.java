package com.silver.cartservice.cart;

public record AddToCartRequest(Long productId, int quantity, String customerId) {
}
