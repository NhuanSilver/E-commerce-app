package com.silver.orderservice.orderline;

import com.silver.orderservice.order.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq", allocationSize = 1)
    private Long id;
    private Long variantId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
