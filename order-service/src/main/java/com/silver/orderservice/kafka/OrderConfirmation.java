package com.silver.orderservice.kafka;

import com.silver.orderservice.order.Payment;
import com.silver.orderservice.product.ProductPurchaseResponse;
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
