package com.silver.productservice.product;

import com.silver.productservice.product.input.ProductCreateRequest;
import com.silver.productservice.product.output.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/v1/products")
@RequiredArgsConstructor
public class ProductAdminController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse create(@RequestBody ProductCreateRequest request) {
        return this.productService.createProduct(request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }
}
