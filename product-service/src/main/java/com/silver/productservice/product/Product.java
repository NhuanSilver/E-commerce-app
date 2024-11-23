package com.silver.productservice.product;

import com.silver.productservice.category.Category;
import com.silver.productservice.enums.Status;
import com.silver.productservice.product.variant.ProductVariant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductVariant> variants;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

}
