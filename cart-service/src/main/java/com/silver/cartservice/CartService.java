package com.silver.cartservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart getCartByCustomerId(String customerId) {
        return this.cartRepository.findByCustomerId(customerId).orElseThrow();
    }

    public Cart addToCart(AddToCartRequest addToCartRequest) {
        String customerId = addToCartRequest.customerId();
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(Cart.builder()
                        .customerId(customerId)
                        .items(new ArrayList<>())
                        .build()
        );
        if (cart.getItems().isEmpty()) {
            CartItem item = CartItem.builder()
                    .productId(addToCartRequest.productId())
                    .quantity(addToCartRequest.quantity())
                    .build();
            cart.getItems().add(item);
        } else {
            Optional<CartItem> itemOptional = cart.getItems()
                    .stream()
                    .filter(cartItem -> addToCartRequest.productId().equals(cartItem.getProductId()))
                    .findFirst();
            CartItem item = itemOptional.orElse(CartItem.builder().build());
            item.setQuantity(item.getQuantity() + addToCartRequest.quantity());
            item.setProductId(addToCartRequest.productId());
            if (itemOptional.isEmpty()) {
                cart.getItems().add(item);
            }
        }
        return cartRepository.save(cart);
    }

    public Cart increaseCartItem(String id, Long productId,int quantity) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartItem item = cart
                .getItems()
                .stream()
                .filter(cartItem -> cartItem.getProductId().equals(productId))
                .findFirst()
                .orElseThrow();
        item.setQuantity(item.getQuantity() + quantity);
        return cartRepository.save(cart);
    }

    public Cart decreaseCartItem(String id, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartItem item = cart
                .getItems()
                .stream()
                .filter(cartItem -> cartItem.getProductId().equals(productId))
                .findFirst()
                .orElseThrow();
        if (item.getQuantity() - quantity <= 0) throw new RuntimeException();

        item.setQuantity(item.getQuantity() - quantity);
        return cartRepository.save(cart);
    }

    public void deleteCart(String id) {
        if(!this.cartRepository.existsById(id)) throw new RuntimeException();
        this.cartRepository.deleteById(id);
    }

    public void deleteCartItem(String id, Long productId) {
        Cart cart = this.cartRepository.findById(id).orElseThrow();
        CartItem item = cart.getItems().stream()
                .filter(cartItem -> cartItem.getProductId().equals(productId))
                .findFirst().orElseThrow();
        cart.getItems().remove(item);
        cartRepository.save(cart);
    }
}
