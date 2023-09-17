package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setAddress(user.getAddress());
        return response;
    }

    @Override
    public List<UserResponse> toDto(List<User> users) {
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : users) {
            userResponseList.add(toDto(user));
        }
        return userResponseList.stream().sorted(Comparator.comparing(UserResponse::getId)).collect(Collectors.toList());
    }
}
