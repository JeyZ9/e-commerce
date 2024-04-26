package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.dto.ProductDTO;
import com.app.paymentgitproject.exceptions.ProductNotExistException;
import com.app.paymentgitproject.model.Category;
import com.app.paymentgitproject.model.Product;
import com.app.paymentgitproject.repository.ProductRepository;
import com.app.paymentgitproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductDTO productDTO, Category category) {
        Product product = getProductFromDTO(productDTO, category);
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> listProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product product : products){
            productDTOS.add(new ProductDTO(product));
        }
        return productDTOS;
    }

    @Override
    public void updateProduct(Long productId, ProductDTO productDTO, Category category) {
        Product product = getProductFromDTO(productDTO, category);

        product.setId(productId);

        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotExistException{
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(!optionalProduct.isPresent()){
            throw new ProductNotExistException("Product id is invalid " + productId);
        }

        return optionalProduct.get();
    }

    public static Product getProductFromDTO(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        return product;
    }
}
