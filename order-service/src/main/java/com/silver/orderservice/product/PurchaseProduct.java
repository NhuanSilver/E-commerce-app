package com.silver.orderservice.product;

import lombok.Builder;

@Builder
public record PurchaseProduct(Long variantId, int quantity) {
}
