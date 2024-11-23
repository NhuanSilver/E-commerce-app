package com.silver.orderservice.orderline;

import lombok.Builder;

@Builder
public record OrderLineDto(Long variantId, int quantity) {

}
