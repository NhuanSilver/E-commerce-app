package com.silver.cartservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CartItem {
    @Id
    private String id;
    private int quantity;
    private Long productId;
}
