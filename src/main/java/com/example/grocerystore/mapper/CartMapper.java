package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.CartResponse;
import com.example.grocerystore.entity.Cart;

import java.util.List;

public interface CartMapper {

    CartResponse toDto(Cart cart);

    List<CartResponse> toDto(List<Cart> carts);

}
