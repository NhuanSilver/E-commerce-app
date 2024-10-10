package com.silver.cartservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable String customerId) {
        return this.cartService.getCartByCustomerId(customerId);
    }

    @PostMapping
    public Cart createCart(@RequestBody AddToCartRequest addToCartRequest) {
        return this.cartService.addToCart(addToCartRequest);
    }

    @PostMapping("/{id}/increase/{productId}/{quantity}")
    public Cart increaseCartItem(@PathVariable String id, @PathVariable Long productId, @PathVariable Integer quantity) {
        return this.cartService.increaseCartItem(id, productId, quantity);
    }

    @PostMapping("/{id}/decrease/{productId}/{quantity}")
    public Cart decreaseCartItem(@PathVariable String id, @PathVariable Long productId, @PathVariable Integer quantity) {
        return this.cartService.decreaseCartItem(id, productId, quantity);
    }
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id) {
        this.cartService.deleteCart(id);
    }
    @DeleteMapping("/{id}/product/{productId}")
    public void deleteCartItem(@PathVariable String id, @PathVariable Long productId) {
        this.cartService.deleteCartItem(id, productId);
    }
}
