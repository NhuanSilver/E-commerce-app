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

            products.add(new Product(null, "Product 1", "SKU001", new BigDecimal("10.99"), 100, "Description of product 1", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 2", "SKU002", new BigDecimal("15.49"), 50, "Description of product 2", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 3", "SKU003", new BigDecimal("25.99"), 75, "Description of product 3", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 4", "SKU004", new BigDecimal("8.99"), 10, "Description of product 4", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 5", "SKU005", new BigDecimal("19.99"), 120, "Description of product 5", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 6", "SKU006", new BigDecimal("11.59"), 0, "Description of product 6", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 7", "SKU007", new BigDecimal("14.99"), 60, "Description of product 7", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 8", "SKU008", new BigDecimal("22.49"), 30, "Description of product 8", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 9", "SKU009", new BigDecimal("5.99"), 90, "Description of product 9", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 10", "SKU010", new BigDecimal("16.49"), 20, "Description of product 10", Status.IN_STOCK, null, null));

            products.add(new Product(null, "Product 11", "SKU011", new BigDecimal("32.99"), 70, "Description of product 11", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 12", "SKU012", new BigDecimal("44.99"), 85, "Description of product 12", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 13", "SKU013", new BigDecimal("12.99"), 95, "Description of product 13", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 14", "SKU014", new BigDecimal("17.99"), 40, "Description of product 14", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 15", "SKU015", new BigDecimal("6.49"), 0, "Description of product 15", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 16", "SKU016", new BigDecimal("9.99"), 60, "Description of product 16", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 17", "SKU017", new BigDecimal("28.99"), 0, "Description of product 17", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 18", "SKU018", new BigDecimal("31.99"), 25, "Description of product 18", Status.IN_STOCK, null, null));
            products.add(new Product(null, "Product 19", "SKU019", new BigDecimal("7.49"), 90, "Description of product 19", Status.OUT_OF_STOCK, null, null));
            products.add(new Product(null, "Product 20", "SKU020", new BigDecimal("18.49"), 110, "Description of product 20", Status.IN_STOCK, null, null));

            // Lưu danh sách sản phẩm vào cơ sở dữ liệu
            productRepository.saveAll(products);
        };
    }
}
