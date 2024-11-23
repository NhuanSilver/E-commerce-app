package com.silver.cartservice.cart;

import com.silver.cartservice.cartitem.CartItem;
import com.silver.cartservice.product.ProductFeign;
import com.silver.cartservice.product.ProductPurchaseResponse;
import com.silver.cartservice.product.PurchaseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductFeign productFeign;

    public Cart getCartByCustomerId(String customerId) {
        return this.cartRepository.findByCustomerId(customerId).orElseThrow();
    }

    public Cart addToCart(List<AddToCartRequest> request) {
        List<ProductPurchaseResponse> productPurchaseResponses = productFeign.purchaseProducts(
                request.stream().map(addToCartRequest -> PurchaseProduct.builder()
                        .variantId(addToCartRequest.variantId())
                        .quantity(addToCartRequest.quantity())
                        .build()).toList()
        );
        String customerId = request.get(0).customerId();
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(Cart.builder()
                .customerId(customerId)
                .items(new ArrayList<>())
                .build()
        );
       for (ProductPurchaseResponse response : productPurchaseResponses) {
           if (response == null) throw new RuntimeException();


           if (cart.getItems().isEmpty()) {
               CartItem item = CartItem.builder()
                       .variantId(response.variantId())
                       .quantity(response.quantity())
                       .build();
               cart.getItems().add(item);
           } else {
               Optional<CartItem> itemOptional = cart.getItems()
                       .stream()
                       .filter(cartItem -> response.variantId().equals(cartItem.getVariantId()))
                       .findFirst();
               CartItem item = itemOptional.orElse(CartItem.builder().build());
               item.setQuantity(item.getQuantity() + response.quantity());
               item.setVariantId(response.variantId());
               if (itemOptional.isEmpty()) {
                   cart.getItems().add(item);
               }
           }
       }
        return cartRepository.save(cart);
    }

    public Cart increaseCartItem(String id, Long variantId,int quantity) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartItem item = cart
                .getItems()
                .stream()
                .filter(cartItem -> cartItem.getVariantId().equals(variantId))
                .findFirst()
                .orElseThrow();
        item.setQuantity(item.getQuantity() + quantity);
        return cartRepository.save(cart);
    }

    public Cart decreaseCartItem(String id, Long variantId, Integer quantity) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        CartItem item = cart
                .getItems()
                .stream()
                .filter(cartItem -> cartItem.getVariantId().equals(variantId))
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

    public void deleteCartItem(String id, Long variantId) {
        Cart cart = this.cartRepository.findById(id).orElseThrow();
        CartItem item = cart.getItems().stream()
                .filter(cartItem -> cartItem.getVariantId().equals(variantId))
                .findFirst().orElseThrow();
        cart.getItems().remove(item);
        cartRepository.save(cart);
    }
}
