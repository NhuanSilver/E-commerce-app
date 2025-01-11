package com.silver.productservice.product.output;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductPurchaseResponse( Long variantId,
                                       Long categoryId,
                                       String name,
                                       String description,
                                       BigDecimal price,
                                       String color,
                                       String size,
                                       String sku,
                                       int quantity) {
}
