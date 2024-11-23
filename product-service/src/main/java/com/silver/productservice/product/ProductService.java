package com.silver.productservice.product;

import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantRepository;
import com.silver.productservice.product.variant.ProductVariantRequest;
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
    private final ProductVariantRepository variantRepository;
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
                .build();
        List<ProductVariant> variants = request.variantRequests().stream().map(variantRequest ->
                ProductVariant.builder()
                        .sku(variantRequest.sku())
                        .color(variantRequest.color())
                        .quantity(variantRequest.quantity())
                        .product(product)
                        .build())
                .toList();
        product.setVariants(variants);
        return this.productMapper.toResponse(this.productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        log.info("Product id to be deleted is {}", id);
        if (!this.productRepository.existsById(id)) throw new RuntimeException();
        this.productRepository.deleteById(id);
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<PurchaseProduct> request) {

        return request.stream().map(purchaseProduct -> {
                ProductVariant variant = variantRepository.findById(purchaseProduct.variantId()).orElseThrow();
                Product product = variant.getProduct();

                return ProductPurchaseResponse.builder().name(product.getName())
                        .variantId(variant.getId())
                        .price(product.getPrice())
                        .size(variant.getSize())
                        .color(variant.getColor())
                        .sku(variant.getSku())
                        .quantity(variant.getQuantity())
                        .description(product.getDescription())
                        .build();
                }).toList();
    }
}
