package com.silver.orderservice.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(Long id, String name, BigDecimal price, int quantity) {
}
