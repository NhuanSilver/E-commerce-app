package com.silver.productservice.product.variant;

import com.silver.productservice.image.Image;
import com.silver.productservice.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "variant_seq", sequenceName = "variant_id_seq", allocationSize = 1)
    private Long id;
    private String size;
    private String color;
    private int quantity;
    private String sku;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Image image;
}
