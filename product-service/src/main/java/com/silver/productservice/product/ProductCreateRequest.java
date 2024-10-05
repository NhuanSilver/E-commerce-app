package com.silver.productservice.product;

import java.math.BigDecimal;

public record ProductCreateRequest(String name, BigDecimal price, String description, String sku) {
}
