package com.silver.productservice.product.input;

import com.silver.productservice.product.variant.ProductVariantRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProductCreateRequest(String name,
                                   BigDecimal price,
                                   String description,
                                   List<UUID> imageIds,
                                   List<ProductVariantRequest> variants) {
}
