package com.silver.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderLine {
    @Id
    private Long id;
    private Long productId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
