package com.silver.productservice.product;

import lombok.Builder;

@Builder
public record PurchaseProduct(Long productId, int quantity) {
}
