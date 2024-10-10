package com.silver.cartservice;

public record AddToCartRequest(Long productId, int quantity, String customerId) {
}
