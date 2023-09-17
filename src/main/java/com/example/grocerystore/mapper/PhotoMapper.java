package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.PhotoResponse;
import com.example.grocerystore.entity.Photo;

import java.util.List;

public interface PhotoMapper {
    PhotoResponse toDto(Photo photo);

    List<PhotoResponse> toDto(List<Photo> photos);
}
