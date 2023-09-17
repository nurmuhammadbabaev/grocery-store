package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.OrderResponse;
import com.example.grocerystore.entity.Order;

import java.util.List;

public interface OrderMapper {

    OrderResponse toDto(Order order);

    List<OrderResponse> toDto(List<Order> orders);
}
