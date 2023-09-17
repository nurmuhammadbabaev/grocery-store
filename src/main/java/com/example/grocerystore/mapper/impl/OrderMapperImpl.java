package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.OrderResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toDto(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setDate(order.getDate());
        return response;
    }

    @Override
    public List<OrderResponse> toDto(List<Order> orders) {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order : orders) {
            orderResponseList.add(toDto(order));
        }
        return orderResponseList.stream().sorted(Comparator.comparing(OrderResponse::getId)).collect(Collectors.toList());
    }
}
