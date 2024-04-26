package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.config.ApiResponse;
import com.app.paymentgitproject.dto.ProductDTO;
import com.app.paymentgitproject.model.Category;
import com.app.paymentgitproject.service.CategoryService;
import com.app.paymentgitproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDTO productDTO){
        Optional<Category> optionalCategory = categoryService.readCategory(productDTO.getCategoryId());
        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "Invalid category"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDTO, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product added successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> productDTOS = productService.listProducts();
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Long productId, @Valid @RequestBody ProductDTO productDTO){
        Optional<Category> optionalCategory = categoryService.readCategory(productDTO.getCategoryId());

        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "Invalid category!"),HttpStatus.CONFLICT);
        }

        Category category = optionalCategory.get();
        productService.updateProduct(productId, productDTO, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product update successfully!"), HttpStatus.OK);
    }
}
