package com.silver.productservice.product;

import com.silver.productservice.product.variant.ProductVariantRequest;

import java.math.BigDecimal;
import java.util.List;

public record ProductCreateRequest(String name, BigDecimal price, String description, List<ProductVariantRequest> variantRequests) {
}
