package com.silver.productservice.product.variant;

import lombok.Builder;

@Builder
public record ProductVariantResponse(Long id, String size, String color, String sku, int quantity) {
}
