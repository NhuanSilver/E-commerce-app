package com.silver.orderservice.order;

import com.silver.orderservice.kafka.OrderConfirmation;
import com.silver.orderservice.product.ProductFeign;
import com.silver.orderservice.product.ProductPurchaseResponse;
import com.silver.orderservice.kafka.OrderProducer;
import com.silver.orderservice.orderline.OrderLine;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProducer orderProducer;
    private final ProductFeign productFeign;

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return orderMapper.toDto(order);
    }

    @Transactional
    public OrderResponse createOrder(OrderCreateRequest request) {
        Order order = Order.builder()
                .customerId(request.customerId())
                .method(request.paymentMethod())
                .totalAmount(request.totalAmount())
                .build();
        List<ProductPurchaseResponse> purchaseProducts = productFeign.purchaseProducts(request.purchasedProducts());
        List<OrderLine> orderLines = purchaseProducts.stream().map(purchaseProduct ->  OrderLine.builder()
                                            .productId(purchaseProduct.id())
                                            .quantity(purchaseProduct.quantity())
                                            .build()).toList();
        order.setOrderLines(orderLines);
        OrderResponse  orderResponse= orderMapper.toDto(orderRepository.save(order));
        orderProducer.sendOrderConfirmation(OrderConfirmation.builder()
                        .customerId(request.customerId())
                        .products(purchaseProducts)
                        .paymentMethod(request.paymentMethod())
                        .totalAmount(request.totalAmount())
                        .build());
        return orderResponse;
    }
}
