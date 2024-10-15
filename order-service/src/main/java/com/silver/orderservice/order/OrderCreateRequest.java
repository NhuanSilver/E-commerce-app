package com.silver.orderservice.order;

import com.silver.orderservice.Payment;
import com.silver.orderservice.orderline.OrderLineDto;

import java.math.BigDecimal;
import java.util.List;

public record OrderCreateRequest(String customerId,
                                 BigDecimal totalAmount,
                                 Payment paymentMethod,
                                 List<OrderLineDto> orderLineRequests
                                 ) {
}
