package com.silver.cartservice.cartitem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private int quantity;
    private Long variantId;
}
