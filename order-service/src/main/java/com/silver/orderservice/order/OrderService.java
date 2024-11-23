package com.silver.orderservice.order;

import com.silver.orderservice.kafka.OrderConfirmation;
import com.silver.orderservice.keycloak.KeyCloakFeign;
import com.silver.orderservice.keycloak.User;
import com.silver.orderservice.product.ProductFeign;
import com.silver.orderservice.product.ProductPurchaseResponse;
import com.silver.orderservice.kafka.OrderProducer;
import com.silver.orderservice.orderline.OrderLine;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProducer orderProducer;
    private final ProductFeign productFeign;
    private final KeyCloakFeign keyCloakFeign;

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return orderMapper.toDto(order);
    }

    @Transactional
    public OrderResponse createOrder(OrderCreateRequest request, String bearerToken) {
        User user = keyCloakFeign.getUserInfo(bearerToken);

        Order order = Order.builder()
                .customerId(user.sub())
                .method(request.paymentMethod())
                .totalAmount(request.totalAmount())
                .build();

        List<ProductPurchaseResponse> purchaseProducts = productFeign.purchaseProducts(request.purchasedProducts());
        List<OrderLine> orderLines = purchaseProducts.stream().map(purchaseProduct ->  OrderLine.builder()
                                            .variantId(purchaseProduct.variantId())
                                            .quantity(purchaseProduct.quantity())
                                            .build()).toList();
        order.setOrderLines(orderLines);
        OrderResponse  orderResponse= orderMapper.toDto(orderRepository.save(order));

        orderProducer.sendOrderConfirmation(OrderConfirmation.builder()
                        .customerName(user.given_name() + " " + user.family_name())
                        .products(purchaseProducts)
                        .paymentMethod(request.paymentMethod())
                        .totalAmount(request.totalAmount())
                        .build());

        return orderResponse;
    }
}
