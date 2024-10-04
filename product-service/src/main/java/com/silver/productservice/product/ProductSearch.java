package com.silver.productservice.product;

import java.math.BigDecimal;

public record ProductSearch(
        String name,
        String sku,
        String size,
        BigDecimal price,
        Long categoryId
) {
}
