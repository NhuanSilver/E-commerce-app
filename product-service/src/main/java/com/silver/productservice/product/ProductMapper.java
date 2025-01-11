package com.silver.productservice.product;

import com.silver.productservice.image.ImageResponse;
import com.silver.productservice.product.output.ProductResponse;
import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                    .imageId(variant.getImage().getId())
                    .build()).toList();
        List<ImageResponse> imageResponses = product.getImages()
                .stream()
                .map(image ->
                        ImageResponse.builder()
                                .id(image.getId())
                                .imageLink(image.getImgLink())
                                .createdAt(image.getCreateAt())
                                .updatedAt(image.getUpdateAt())
                                .variantIds(
                                        variantResponses.stream()
                                                .filter(variant -> variant.imageId().equals(image.getId()))
                                                .map(ProductVariantResponse::id)
                                                .toList()
                                )
                                .build()
                )
                .toList();
        return ProductResponse
                .builder()
                .id(product.getId())
                .categoryId(1L)
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .variants(variantResponses)
                .images(imageResponses)
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

}
