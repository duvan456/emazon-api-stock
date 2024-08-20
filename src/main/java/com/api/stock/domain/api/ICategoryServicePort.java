package com.api.stock.domain.api;

import com.api.stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(Long categoryId);
    Category getCategoryByName(String categoryName);
    void updateCategory(Category category);

    // no exponer el delete
    // void deleteCategory(Category category);

}
