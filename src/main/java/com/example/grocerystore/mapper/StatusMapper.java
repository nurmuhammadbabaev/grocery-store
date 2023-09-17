package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.StatusResponse;
import com.example.grocerystore.entity.Status;

import java.util.List;

public interface StatusMapper {

    StatusResponse toDto(Status status);

    List<StatusResponse> toDto(List<Status> statuses);
}
