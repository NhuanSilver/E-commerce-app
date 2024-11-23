package com.silver.productservice.config;

import com.silver.productservice.enums.Status;
import com.silver.productservice.product.Product;
import com.silver.productservice.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            List<Product> products = new ArrayList<>();

            products.add(Product.builder()
                    .name("Product 11")
                    .sku("SKU011")
                    .price(new BigDecimal("32.99"))
                    .description("Description of product 11")
                    .status(Status.OUT_OF_STOCK)
                    .quantity(0) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 12")
                    .sku("SKU012")
                    .price(new BigDecimal("44.99"))
                    .description("Description of product 12")
                    .status(Status.IN_STOCK)
                    .quantity(60) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 13")
                    .sku("SKU013")
                    .price(new BigDecimal("12.99"))
                    .description("Description of product 13")
                    .status(Status.OUT_OF_STOCK)
                    .quantity(0) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 14")
                    .sku("SKU014")
                    .price(new BigDecimal("17.99"))
                    .description("Description of product 14")
                    .status(Status.IN_STOCK)
                    .quantity(45) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 15")
                    .sku("SKU015")
                    .price(new BigDecimal("6.49"))
                    .description("Description of product 15")
                    .status(Status.OUT_OF_STOCK)
                    .quantity(0) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 16")
                    .sku("SKU016")
                    .price(new BigDecimal("9.99"))
                    .description("Description of product 16")
                    .status(Status.IN_STOCK)
                    .quantity(110) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 17")
                    .sku("SKU017")
                    .price(new BigDecimal("28.99"))
                    .description("Description of product 17")
                    .status(Status.OUT_OF_STOCK)
                    .quantity(0) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 18")
                    .sku("SKU018")
                    .price(new BigDecimal("31.99"))
                    .description("Description of product 18")
                    .status(Status.IN_STOCK)
                    .quantity(25) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 19")
                    .sku("SKU019")
                    .price(new BigDecimal("7.49"))
                    .description("Description of product 19")
                    .status(Status.OUT_OF_STOCK)
                    .quantity(0) // Số lượng
                    .build());

            products.add(Product.builder()
                    .name("Product 20")
                    .sku("SKU020")
                    .price(new BigDecimal("18.49"))
                    .description("Description of product 20")
                    .status(Status.IN_STOCK)
                    .quantity(70) // Số lượng
                    .build());


            productRepository.saveAll(products);
        };
    }

}
