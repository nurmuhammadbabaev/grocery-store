package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.User;

import java.util.List;

public interface UserMapper {

    UserResponse toDto(User user);

    List<UserResponse> toDto(List<User> users);
}
