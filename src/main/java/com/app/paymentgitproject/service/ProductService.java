package com.app.paymentgitproject.service;

import com.app.paymentgitproject.dto.ProductDTO;
import com.app.paymentgitproject.exceptions.ProductNotExistException;
import com.app.paymentgitproject.model.Category;
import com.app.paymentgitproject.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDTO productDTO, Category category);

    List<ProductDTO> listProducts();

    void updateProduct(Long productId, ProductDTO productDTO, Category category);

    Product getProductById(Long productId) throws ProductNotExistException;
}
