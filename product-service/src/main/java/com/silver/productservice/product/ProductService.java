package com.silver.productservice.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> searchProduct(ProductSearch productSearch){
        List<Product> products = productRepository.findAll(ProductSpecification.filterByCriteria(productSearch));
        return products.stream().map(productMapper::toResponse).collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        return this.productMapper.toResponse(this.productRepository.findById(id).orElseThrow());
    }

    public ProductResponse createProduct(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .price(request.price())
                .description(request.description())
                .sku(request.sku())
                .build();
        log.info(product.getDescription());
        return this.productMapper.toResponse(this.productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        log.info("Product id to be deleted is {}", id);
        if (!this.productRepository.existsById(id)) throw new RuntimeException();
        this.productRepository.deleteById(id);
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<PurchaseProduct> request) {
        return request.stream().map(purchaseProduct -> {
                Product product = productRepository.findById(purchaseProduct.productId()).orElseThrow();
//                if (purchaseProduct.quantity() > product.getQuantity()) throw new RuntimeException("Hết rồi bạn ơi");
                return ProductPurchaseResponse.builder().name(product.getName())
                        .id(product.getId())
                        .price(product.getPrice())
                        .quantity(purchaseProduct.quantity())
                        .build();
                }).toList();
    }
}
