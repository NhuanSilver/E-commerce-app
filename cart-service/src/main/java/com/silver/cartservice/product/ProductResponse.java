package com.silver.cartservice.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        Long id,
        Long categoryId,
        String name,
        String sku,
        String description,
        BigDecimal price
) {
}
