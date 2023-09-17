package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.StatusResponse;
import com.example.grocerystore.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    @Override
    public StatusResponse findById(Long id) {
        return null;
    }

    @Override
    public List<StatusResponse> findAll() {
        return null;
    }
}
