package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.model.Category;
import com.app.paymentgitproject.repository.CategoryRepository;
import com.app.paymentgitproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category readCategory(String categoryName){
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> readCategory(Long categoryId){
        return categoryRepository.findById(categoryId);
    }

    @Override
    public void updateCategory(Long categoryId, Category newCategory){
        Category category = categoryRepository.findById(categoryId).get();
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setImageUrl(newCategory.getImageUrl());
        categoryRepository.save(category);
    }
}
