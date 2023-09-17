package com.example.grocerystore.service;

import com.example.grocerystore.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse findById(Long id);

    List<OrderResponse> findAll();
}
