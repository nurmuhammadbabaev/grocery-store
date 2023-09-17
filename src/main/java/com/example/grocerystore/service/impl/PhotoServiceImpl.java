package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.PhotoResponse;
import com.example.grocerystore.entity.Photo;
import com.example.grocerystore.mapper.PhotoMapper;
import com.example.grocerystore.repository.PhotoRepository;
import com.example.grocerystore.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    @Override
    public PhotoResponse findById(Long id) {
        return photoMapper.toDto(photoRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PhotoResponse> findAll() {
        return photoMapper.toDto(photoRepository.findAll());
    }

    @Override
    public Photo create(String urlPhoto) {
        Photo photo = new Photo();
        return save(photo, urlPhoto);
    }

    private Photo save(Photo photo, String url) {
        File file = new File(url);
        photo.setPhotoName(file.getName());
        photo.setPath(url);
        photo.setSize(file.length());
        photo.setType("img/jpg");
        return photoRepository.save(photo);
    }
}
