package com.example.grocerystore.service;

import com.example.grocerystore.dto.UserRequest;
import com.example.grocerystore.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse create(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);

}
