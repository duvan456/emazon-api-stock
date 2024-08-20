package com.api.stock.infrastructure.configuration;

import com.api.stock.domain.api.ICategoryServicePort;
import com.api.stock.domain.spi.ICategoryPersistencePort;
import com.api.stock.domain.usecase.CategoryUseCase;
import com.api.stock.infrastructure.out.jpa.apapter.CategoryJpaAdapter;
import com.api.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.api.stock.infrastructure.out.jpa.repository.ICategoryRepository;
/**
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.adapter.PhotoMongodbAdapter;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.mapper.PhotoEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository.IPhotoRepository;
 */
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}
