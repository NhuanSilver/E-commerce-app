package com.silver.orderservice.order;

import com.silver.orderservice.orderline.OrderLine;
import com.silver.orderservice.orderline.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return orderMapper.toDto(order);
    }

    public OrderResponse createOrder(OrderCreateRequest request) {
        Order order = Order.builder()
                .customerId(request.customerId())
                .method(request.paymentMethod())
                .totalAmount(request.totalAmount())
                .build();
        List<OrderLine> orderLines = request.orderLineRequests()
                                        .stream()
                                        .map(lineRequest -> OrderLine.builder()
                                                .order(order)
                                                .productId(lineRequest.productId())
                                                .quantity(lineRequest.quantity())
                                                .build()).toList();
        order.setOrderLines(orderLines);
        return orderMapper.toDto(orderRepository.save(order));
    }
}
