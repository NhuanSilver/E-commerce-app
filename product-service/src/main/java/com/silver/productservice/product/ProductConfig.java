package com.silver.productservice.product;

import com.silver.productservice.enums.Status;
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
                    .name("Product 1")
                    .sku("SKU001")
                    .price(new BigDecimal("10.99"))
                    .description("Description of product 1")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 2")
                    .sku("SKU002")
                    .price(new BigDecimal("15.49"))
                    .description("Description of product 2")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 3")
                    .sku("SKU003")
                    .price(new BigDecimal("25.99"))
                    .description("Description of product 3")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 4")
                    .sku("SKU004")
                    .price(new BigDecimal("8.99"))
                    .description("Description of product 4")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 5")
                    .sku("SKU005")
                    .price(new BigDecimal("19.99"))
                    .description("Description of product 5")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 6")
                    .sku("SKU006")
                    .price(new BigDecimal("11.59"))
                    .description("Description of product 6")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 7")
                    .sku("SKU007")
                    .price(new BigDecimal("14.99"))
                    .description("Description of product 7")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 8")
                    .sku("SKU008")
                    .price(new BigDecimal("22.49"))
                    .description("Description of product 8")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 9")
                    .sku("SKU009")
                    .price(new BigDecimal("5.99"))
                    .description("Description of product 9")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 10")
                    .sku("SKU010")
                    .price(new BigDecimal("16.49"))
                    .description("Description of product 10")
                    .status(Status.IN_STOCK)
                    .build());

            // Tiếp tục thêm các sản phẩm khác
            products.add(Product.builder()
                    .name("Product 11")
                    .sku("SKU011")
                    .price(new BigDecimal("32.99"))
                    .description("Description of product 11")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 12")
                    .sku("SKU012")
                    .price(new BigDecimal("44.99"))
                    .description("Description of product 12")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 13")
                    .sku("SKU013")
                    .price(new BigDecimal("12.99"))
                    .description("Description of product 13")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 14")
                    .sku("SKU014")
                    .price(new BigDecimal("17.99"))
                    .description("Description of product 14")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 15")
                    .sku("SKU015")
                    .price(new BigDecimal("6.49"))
                    .description("Description of product 15")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 16")
                    .sku("SKU016")
                    .price(new BigDecimal("9.99"))
                    .description("Description of product 16")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 17")
                    .sku("SKU017")
                    .price(new BigDecimal("28.99"))
                    .description("Description of product 17")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 18")
                    .sku("SKU018")
                    .price(new BigDecimal("31.99"))
                    .description("Description of product 18")
                    .status(Status.IN_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 19")
                    .sku("SKU019")
                    .price(new BigDecimal("7.49"))
                    .description("Description of product 19")
                    .status(Status.OUT_OF_STOCK)
                    .build());

            products.add(Product.builder()
                    .name("Product 20")
                    .sku("SKU020")
                    .price(new BigDecimal("18.49"))
                    .description("Description of product 20")
                    .status(Status.IN_STOCK)
                    .build());

            productRepository.saveAll(products);
        };
    }

}
