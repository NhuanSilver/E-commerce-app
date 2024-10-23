package com.silver.notificationservice.product;

import lombok.Builder;

@Builder
public record PurchaseProduct(Long productId, int quantity) {
}
