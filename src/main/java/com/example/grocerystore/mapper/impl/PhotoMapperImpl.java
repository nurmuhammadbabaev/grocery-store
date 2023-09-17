package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.PhotoResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Photo;
import com.example.grocerystore.mapper.PhotoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public PhotoResponse toDto(Photo photo) {
        PhotoResponse response = new PhotoResponse();
        response.setId(photo.getId());
        response.setPhotoName(photo.getPhotoName());
        response.setType(photo.getType());
        response.setSize(photo.getSize());
        response.setPath(photo.getPath());
        return response;
    }

    @Override
    public List<PhotoResponse> toDto(List<Photo> photos) {
        List<PhotoResponse> photoResponseList = new ArrayList<>();
        for (Photo photo : photos) {
            photoResponseList.add(toDto(photo));
        }
        return photoResponseList.stream().sorted(Comparator.comparing(PhotoResponse::getId)).collect(Collectors.toList());
    }
}
