package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.UserRequest;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.mapper.UserMapper;
import com.example.grocerystore.repository.UserRepository;
import com.example.grocerystore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        return userMapper.toDto(save(user, userRequest));
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        return userMapper.toDto(save(userRepository.findById(id).orElseThrow(), userRequest));
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }


    private User save(User user, UserRequest userRequest) {
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAddress(userRequest.getAddress());
        return userRepository.save(user);
    }
}
