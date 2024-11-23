package com.silver.productservice.config;

import com.silver.productservice.category.Category;
import com.silver.productservice.enums.Status;
import com.silver.productservice.product.Product;
import com.silver.productservice.product.ProductRepository;
import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ProductConfig {
    private final ProductRepository productRepository;
    private final ProductVariantRepository variantRepository;
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            List<Product> products = new ArrayList<>();

            // Create Product 11 with variants
            products.add(createProductWithVariants(
                    "Product 11", "SKU011", new BigDecimal("32.99"), "Description of product 11",
                    Status.OUT_OF_STOCK));

            // Create Product 12 with variants
            products.add(createProductWithVariants(
                    "Product 12", "SKU012", new BigDecimal("44.99"), "Description of product 12",
                    Status.IN_STOCK));

            // Create Product 13 with variants
            products.add(createProductWithVariants(
                    "Product 13", "SKU013", new BigDecimal("12.99"), "Description of product 13",
                    Status.OUT_OF_STOCK));

            // Create Product 14 with variants
            products.add(createProductWithVariants(
                    "Product 14", "SKU014", new BigDecimal("17.99"), "Description of product 14",
                    Status.IN_STOCK));

            // Create Product 15 with variants
            products.add(createProductWithVariants(
                    "Product 15", "SKU015", new BigDecimal("6.49"), "Description of product 15",
                    Status.OUT_OF_STOCK));

            // Create Product 16 with variants
            products.add(createProductWithVariants(
                    "Product 16", "SKU016", new BigDecimal("9.99"), "Description of product 16",
                    Status.IN_STOCK));

            // Create Product 17 with variants
            products.add(createProductWithVariants(
                    "Product 17", "SKU017", new BigDecimal("28.99"), "Description of product 17",
                    Status.OUT_OF_STOCK));

            // Create Product 18 with variants
            products.add(createProductWithVariants(
                    "Product 18", "SKU018", new BigDecimal("31.99"), "Description of product 18",
                    Status.IN_STOCK));

            // Create Product 19 with variants
            products.add(createProductWithVariants(
                    "Product 19", "SKU019", new BigDecimal("7.49"), "Description of product 19",
                    Status.OUT_OF_STOCK));

            // Create Product 20 with variants
            products.add(createProductWithVariants(
                    "Product 20", "SKU020", new BigDecimal("18.49"), "Description of product 20",
                    Status.IN_STOCK));

            // Save all products to the database
            productRepository.saveAll(products);
        };
    }

    // Helper method to create a product with 3 variants
    private Product createProductWithVariants(String name, String sku, BigDecimal price, String description,
                                              Status status) {

        // Creating the variants for the product
        ProductVariant variant1 = ProductVariant.builder()
                .size("Small")
                .color("Red")
                .quantity(5)
                .sku(sku + "-S")
                .build();

        ProductVariant variant2 = ProductVariant.builder()
                .size("Medium")
                .color("Blue")
                .quantity(4)
                .sku(sku + "-M")
                .build();
        ProductVariant variant3 = ProductVariant.builder()
                .size("Large")
                .color("Green")
                .quantity(3)
                .sku(sku + "-L")
                .build();

        // Create the product with the 3 variants
        List<ProductVariant> variants = Arrays.asList(variant1, variant2, variant3);
        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .variants(variants)
                .status(status)
                .build();
        variant1.setProduct(product);
        variant2.setProduct(product);
        variant3.setProduct(product);
        return product;
    }


}
