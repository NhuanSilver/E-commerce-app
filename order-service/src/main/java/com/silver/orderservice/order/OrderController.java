package com.silver.orderservice.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderCreateRequest request, @RequestHeader("Authorization") String bearerToken) {
        return orderService.createOrder(request, bearerToken);
    }
}
