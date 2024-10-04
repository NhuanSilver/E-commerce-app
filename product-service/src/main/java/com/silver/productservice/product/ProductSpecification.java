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
            String size = productSearch.size();
            BigDecimal price = productSearch.price();
            Long categoryId = productSearch.categoryId();

            if (name != null && !name.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            if (sku != null && !sku.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("sku"), sku));
            }

            if (size != null && !size.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("size"), size));
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
