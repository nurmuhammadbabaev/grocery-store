package com.example.grocerystore.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
}
