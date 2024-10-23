package com.silver.orderservice.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductFeign {
    @PostMapping("/api/v1/products/purchase")
    List<ProductPurchaseResponse> purchaseProducts(@RequestBody List<PurchaseProduct> request);
}
