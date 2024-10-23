package com.silver.orderservice.order;

import com.silver.orderservice.product.PurchaseProduct;

import java.math.BigDecimal;
import java.util.List;

public record OrderCreateRequest(String customerId,
                                 BigDecimal totalAmount,
                                 Payment paymentMethod,
                                 List<PurchaseProduct> purchasedProducts
                                 ) {
}
