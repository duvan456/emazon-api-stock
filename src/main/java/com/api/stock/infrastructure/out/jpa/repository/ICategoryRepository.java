package com.api.stock.infrastructure.out.jpa.repository;

import com.api.stock.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {


    Optional<CategoryEntity> findById(Long categoryId);
    Optional<CategoryEntity> findByName(String categoryName);

}
