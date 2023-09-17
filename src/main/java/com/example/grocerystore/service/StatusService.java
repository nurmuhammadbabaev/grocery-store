package com.example.grocerystore.service;

import com.example.grocerystore.dto.StatusResponse;

import java.util.List;

public interface StatusService {

    StatusResponse findById(Long id);

    List<StatusResponse> findAll();

}
