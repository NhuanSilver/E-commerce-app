package com.silver.productservice.product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(Product product) {
        return ProductResponse
                .builder()
                .categoryId(1L)
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .sku(product.getSku())
                .build();
    }

}
