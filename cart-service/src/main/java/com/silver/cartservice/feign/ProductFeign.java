package com.silver.cartservice.feign;

import com.silver.cartservice.product.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCT-SERVICE")
public interface ProductFeign {
    @GetMapping("/api/v1/products/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}
