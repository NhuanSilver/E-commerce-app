package com.silver.productservice.product;

import com.silver.productservice.image.Image;
import com.silver.productservice.image.ImageRepository;
import com.silver.productservice.product.input.ProductCreateRequest;
import com.silver.productservice.product.output.ProductPurchaseResponse;
import com.silver.productservice.product.output.ProductResponse;
import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantRepository;
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
    private final ImageRepository imageRepository;

    public List<ProductResponse> searchProduct(ProductSearch productSearch) {
        List<Product> products = productRepository.findAll(ProductSpecification.filterByCriteria(productSearch));
        return products.stream().map(productMapper::toResponse).collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        return this.productMapper.toResponse(this.productRepository.findById(id).orElseThrow());
    }

    public ProductResponse createProduct(ProductCreateRequest request) {

        Product product = Product.builder().name(request.name())
                .price(request.price())
                .description(request.description())
                .build();

        List<Image> images = request.imageIds()
                .stream()
                .map(imgId -> imageRepository.findById(imgId).orElseThrow()).toList();

        List<ProductVariant> variants = request.variants()
                .stream()
                .map(variantRequest -> ProductVariant.builder()
                        .sku("just for test")
                        .size(variantRequest.size())
                        .color(variantRequest.color())
                        .quantity(variantRequest.quantity())
                        .product(product)
                        .image(images.stream()
                                .filter(image -> image.getId().equals(variantRequest.imgId()))
                                .findFirst().orElseThrow())
                        .build())
                .toList();
        product.setImages(images);
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

            return ProductPurchaseResponse.builder()
                    .name(product.getName())
                    .variantId(variant.getId())
                    .price(product.getPrice())
                    .size(variant.getSize())
                    .color(variant.getColor())
                    .sku(variant.getSku())
                    .quantity(variant.getQuantity()).description(product.getDescription())
                    .build();
        }).toList();
    }
}
