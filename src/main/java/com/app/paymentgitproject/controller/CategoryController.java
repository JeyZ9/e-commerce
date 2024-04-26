package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.config.ApiResponse;
import com.app.paymentgitproject.model.Category;
import com.app.paymentgitproject.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category){
        if(Objects.nonNull(categoryService.readCategory(category.getCategoryName()))){
            return new ResponseEntity<>(new ApiResponse(false, "category already exists!"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Long categoryId, @Valid @RequestBody Category category){

        if(Objects.nonNull(categoryService.readCategory(categoryId))){
            categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<>(new ApiResponse(true, "category successfully updated"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "category does not exist!"), HttpStatus.NOT_FOUND);
    }
}
