package com.silver.orderservice.orderline;

import lombok.Builder;

@Builder
public record OrderLineDto(Long productId, int quantity) {

}
