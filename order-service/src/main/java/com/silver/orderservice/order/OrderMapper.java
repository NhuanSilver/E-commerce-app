package com.silver.orderservice.order;

import com.silver.orderservice.orderline.OrderLineDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponse toDto(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .paymentMethod(order.getMethod())
                .totalAmount(order.getTotalAmount())
                .lines(order.getOrderLines().stream().map(orderLine -> OrderLineDto.builder()
                                .productId(orderLine.getProductId())
                                .quantity(orderLine.getQuantity()).build()).toList())
                .build();
    }
}
