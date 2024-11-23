package com.silver.cartservice.product;

import lombok.Builder;

@Builder
public record PurchaseProduct(Long variantId, int quantity) {
}
