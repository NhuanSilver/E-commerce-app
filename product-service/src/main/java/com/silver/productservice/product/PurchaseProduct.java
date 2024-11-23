package com.silver.productservice.product;

import lombok.Builder;

@Builder
public record PurchaseProduct(Long variantId, int quantity) {
}
