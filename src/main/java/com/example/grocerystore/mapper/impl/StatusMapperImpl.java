package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.StatusResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Status;
import com.example.grocerystore.mapper.StatusMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusResponse toDto(Status status) {
        StatusResponse response = new StatusResponse();
        response.setId(status.getId());
        response.setName(status.getName());
        return response;
    }

    @Override
    public List<StatusResponse> toDto(List<Status> statuses) {
        List<StatusResponse> statusResponseList = new ArrayList<>();
        for (Status status : statuses) {
            statusResponseList.add(toDto(status));
        }
        return statusResponseList.stream().sorted(Comparator.comparing(StatusResponse::getId)).collect(Collectors.toList());
    }
}
