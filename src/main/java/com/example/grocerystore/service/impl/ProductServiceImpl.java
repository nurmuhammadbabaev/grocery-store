package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.ProductRequest;
import com.example.grocerystore.dto.ProductResponse;
import com.example.grocerystore.entity.Photo;
import com.example.grocerystore.entity.Product;
import com.example.grocerystore.mapper.ProductMapper;
import com.example.grocerystore.repository.ProductRepository;
import com.example.grocerystore.service.PhotoService;
import com.example.grocerystore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final PhotoService photoService;

    @Override
    public List<ProductResponse> searchProducts(String search) {
        if (search == null) {
            return productMapper.toDto(productRepository.findAll());
        }
        return productMapper.toDto(productRepository.search(search));
    }

    @Override
    @Transactional
    public ProductResponse create(ProductRequest productRequest) throws FileNotFoundException {
        Product product = new Product();
        Photo photo = photoService.create(productRequest.getPath());
        product.setPhoto(photo);
        return productMapper.toDto(save(product, productRequest));
    }

    @Override
    public ProductResponse findById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow());
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) throws FileNotFoundException {
        Product product = productRepository.findById(id).orElseThrow();
        if (product.getPhoto() != null){
            Photo photo = photoService.update(product.getPhoto(), productRequest.getPath());
            product.setPhoto(photo);
            return productMapper.toDto(save(product, productRequest));
        }
        return productMapper.toDto(save(product, productRequest));
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    private Product save(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }
}
