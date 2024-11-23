package com.silver.notificationservice.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(Long variantId,
                                      Long categoryId,
                                      String name,
                                      String description,
                                      BigDecimal price,
                                      String color,
                                      String size,
                                      String sku,
                                      int quantity) {
}
