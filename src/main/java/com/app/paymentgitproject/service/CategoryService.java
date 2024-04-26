package com.app.paymentgitproject.service;

import com.app.paymentgitproject.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category readCategory(String categoryName);

    void createCategory (Category category);

    List<Category> listCategories();

    Optional<Category> readCategory(Long categoryId);

    void updateCategory(Long categoryId, Category category);
}
