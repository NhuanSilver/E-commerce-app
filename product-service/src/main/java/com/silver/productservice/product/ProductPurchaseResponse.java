package com.silver.productservice.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductPurchaseResponse(Long id, String name, BigDecimal price, int quantity) {
}
