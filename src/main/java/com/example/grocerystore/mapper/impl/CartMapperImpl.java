package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.CartResponse;
import com.example.grocerystore.entity.Cart;
import com.example.grocerystore.mapper.CartMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartResponse toDto(Cart cart) {
        CartResponse response = new CartResponse();
        response.setId(cart.getId());
        return response;
    }

    @Override
    public List<CartResponse> toDto(List<Cart> carts) {
        List<CartResponse> cartResponseList = new ArrayList<>();
        for (Cart cart : carts) {
            cartResponseList.add(toDto(cart));
        }
        return cartResponseList.stream().sorted(Comparator.comparing(CartResponse::getId)).collect(Collectors.toList());
    }
}
