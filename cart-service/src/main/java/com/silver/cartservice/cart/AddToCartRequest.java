package com.silver.cartservice.cart;

public record AddToCartRequest(Long variantId, int quantity, String customerId) {
}
