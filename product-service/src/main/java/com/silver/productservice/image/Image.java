package com.silver.productservice.image;

import com.silver.productservice.product.Product;
import com.silver.productservice.product.variant.ProductVariant;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    private UUID id;

    private String imgLink;

    @ManyToOne
    private Product product;

    @OneToMany(mappedBy = "image")
    private List<ProductVariant> variants;

    @CreationTimestamp
    private Timestamp createAt;

    @UpdateTimestamp
    private Timestamp updateAt;

}
