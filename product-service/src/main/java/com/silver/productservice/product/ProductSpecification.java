package com.silver.productservice.product;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {
    public static Specification<Product> filterByCriteria(ProductSearch productSearch) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction(); // Bắt đầu với Predicate trống

            String name = productSearch.name();
            String sku = productSearch.sku();
            BigDecimal price = productSearch.price();
            Long categoryId = productSearch.categoryId();

            if (name != null && !name.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            if (sku != null && !sku.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("sku"), sku));
            }

            if (price != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("price"), price));
            }

            if (categoryId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("categoryId"), categoryId));
            }

            return predicate;
        };
    }
}
