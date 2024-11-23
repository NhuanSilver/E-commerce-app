package com.silver.notificationservice.notification;

import com.silver.notificationservice.product.ProductPurchaseResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(Long id,
                                String customerName,
                                Payment paymentMethod,
                                BigDecimal totalAmount,
                                List<ProductPurchaseResponse> products) {
}
