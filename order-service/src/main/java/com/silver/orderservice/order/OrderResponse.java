package com.silver.orderservice.order;

import com.silver.orderservice.orderline.OrderLineDto;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderResponse(Long id,
                            String customerId,
                            Payment paymentMethod,
                            BigDecimal totalAmount,
                            List<OrderLineDto> lines
) {
}
