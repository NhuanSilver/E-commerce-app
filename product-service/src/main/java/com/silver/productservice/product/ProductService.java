package com.silver.productservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> searchProduct(ProductSearch productSearch){
        List<Product> products = productRepository.findAll(ProductSpecification.filterByCriteria(productSearch));
        return products.stream().map(productMapper::toResponse).collect(Collectors.toList());
    }
}
