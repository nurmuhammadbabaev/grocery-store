package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.OrderResponse;
import com.example.grocerystore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderResponse findById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> findAll() {
        return null;
    }
}
