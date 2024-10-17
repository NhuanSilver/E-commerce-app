package com.silver.cartservice.cart;

import com.silver.cartservice.cartitem.CartItem;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    private String id;

    @Indexed(unique = true)
    private String customerId;
    private List<CartItem> items = new ArrayList<>();

}
