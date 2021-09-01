package com.mohsinkd786.services;

import com.mohsinkd786.data.entities.Product;
import com.mohsinkd786.data.repos.ProductRepository;
import com.mohsinkd786.dtos.ProductDto;
import static com.mohsinkd786.utils.ProductMapperUtil.toDto;
import static com.mohsinkd786.utils.ProductMapperUtil.toEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductDto> findProducts(){
        Spliterator<Product> productSpliterator = productRepository.findAll().spliterator();

        List<ProductDto> products =  StreamSupport
                .stream(productSpliterator,false)
                .map(product -> toDto(product))
                .collect(Collectors.toList());

        return products;
    }

    public ProductDto createProduct(ProductDto productDto){
        Product product = toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        ProductDto savedDto = toDto(savedProduct);
        return savedDto;
    }

    public ProductDto findById(String productId){
        Product product = productRepository.findByProductId(productId);
        ProductDto productDto = toDto(product);
        return productDto;
    }

    public ProductDto modifyProduct(ProductDto productDto){
        return null;
    }

    public Boolean deleteById(String productId){
        Product product = productRepository.findByProductId(productId);
        productRepository.delete(product);
        return true;
    }
}
