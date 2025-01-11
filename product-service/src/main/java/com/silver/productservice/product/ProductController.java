package com.silver.productservice.product;

import com.silver.productservice.product.input.ProductCreateRequest;
import com.silver.productservice.product.output.ProductPurchaseResponse;
import com.silver.productservice.product.output.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> searchProducts(ProductSearch productSearch) {
        return this.productService.searchProduct(productSearch);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }
    @PostMapping("/purchase")
    List<ProductPurchaseResponse> purchaseProducts(@RequestBody List<PurchaseProduct> request) {
        return productService.purchaseProducts(request);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }
}
