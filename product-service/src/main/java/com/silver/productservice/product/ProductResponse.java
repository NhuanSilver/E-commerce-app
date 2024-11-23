package com.silver.productservice.product;

import com.silver.productservice.product.variant.ProductVariantResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProductResponse(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        List<ProductVariantResponse> variants
) {
}
