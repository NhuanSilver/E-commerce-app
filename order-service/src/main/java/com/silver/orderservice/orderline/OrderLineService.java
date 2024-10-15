package com.silver.orderservice.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;

    public List<OrderLine> saveAll(List<OrderLine> orderLines) {
        return  this.repository.saveAll(orderLines);
    }
}
