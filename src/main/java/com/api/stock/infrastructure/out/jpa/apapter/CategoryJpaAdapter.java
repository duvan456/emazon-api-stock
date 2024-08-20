package com.api.stock.infrastructure.out.jpa.apapter;

import com.api.stock.domain.model.Category;
import com.api.stock.domain.spi.ICategoryPersistencePort;
import com.api.stock.infrastructure.exception.CategoryNameAlreadyExistsException;
import com.api.stock.infrastructure.exception.NoDataFoundException;
import com.api.stock.infrastructure.exception.CategoryIdAlreadyExistsException;
import com.api.stock.infrastructure.exception.CategoryNotFoundException;
import com.api.stock.infrastructure.out.jpa.entity.CategoryEntity;
import com.api.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.api.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.findById(category.getId()).isPresent()) {
            throw new CategoryIdAlreadyExistsException();
        } else if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryNameAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryEntityMapper.toCategory(categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryEntityMapper.toCategory(categoryRepository.findByName(categoryName)
                .orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }
}
