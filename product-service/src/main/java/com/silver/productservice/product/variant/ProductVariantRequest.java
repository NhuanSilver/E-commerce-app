package com.silver.productservice.product.variant;

import java.util.UUID;

public record ProductVariantRequest(String color,
                                    String size,
                                    int quantity,
                                    UUID imgId) {
}
