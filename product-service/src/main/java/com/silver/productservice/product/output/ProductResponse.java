package com.silver.productservice.product.output;

import com.silver.productservice.image.ImageResponse;
import com.silver.productservice.product.variant.ProductVariantResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Builder
public record ProductResponse(
        Long id,
        Long categoryId,
        String name,
        String description,
        BigDecimal price,
        List<ProductVariantResponse> variants,
        List<ImageResponse> images,
        Timestamp createdAt,
        Timestamp updatedAt
) {
}
