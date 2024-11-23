package com.silver.productservice.product;

import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductMapper {
    public ProductResponse toResponse(Product product) {
        List<ProductVariantResponse> variantResponses = product.getVariants().stream().map(variant ->
            ProductVariantResponse.builder()
                    .id(variant.getId())
                    .color(variant.getColor())
                    .size(variant.getSize())
                    .quantity(variant.getQuantity())
                    .sku(variant.getSku())
                    .build()).toList();

        return ProductResponse
                .builder()
                .id(product.getId())
                .categoryId(1L)
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .variants(variantResponses)
                .build();
    }

}
