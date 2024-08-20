package com.api.stock.domain.usecase;

import com.api.stock.domain.api.ICategoryServicePort;
import com.api.stock.domain.model.Category;
import com.api.stock.domain.spi.ICategoryPersistencePort;

import java.util.List;
public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryPersistencePort.getAllCategory();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryPersistencePort.getCategoryById(categoryId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryPersistencePort.getCategoryByName(categoryName);
    }

    @Override
    public void updateCategory(Category category) {
        categoryPersistencePort.updateCategory(category);
    }
}
