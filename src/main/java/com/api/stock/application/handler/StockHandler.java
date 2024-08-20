package com.api.stock.application.handler;

import com.api.stock.application.dto.StockRequest;
import com.api.stock.application.dto.StockResponse;
import com.api.stock.application.mapper.StockRequestMapper;
import com.api.stock.application.mapper.StockResponseMapper;
import com.api.stock.domain.api.ICategoryServicePort;
import com.api.stock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StockHandler implements IStockHandler{

    private final ICategoryServicePort categoryServicePort;
    private final StockRequestMapper stockRequestMapper;
    private final StockResponseMapper stockResponseMapper;

    @Override
    public void saveCategoryInStock(StockRequest stockRequest) {

        Category category = stockRequestMapper.toCategory(stockRequest);
        categoryServicePort.saveCategory(category);

    }

    @Override
    public List<StockResponse> getAllCategoryFromStock() {
        return stockResponseMapper.toResponseList(categoryServicePort.getAllCategory());
    }

    @Override
    public StockResponse getCategoryByIdFromStock(Long categoryId) {
        Category category = categoryServicePort.getCategoryById(categoryId);
        return stockResponseMapper.toResponse(category);
    }

    @Override
    public StockResponse getCategoryByNameFromStock(String categoryName) {
        Category category = categoryServicePort.getCategoryByName(categoryName);
        return stockResponseMapper.toResponse(category);
    }

    @Override
    public void updateCategoryInStock(StockRequest stockRequest) {
        Category oldCategory = categoryServicePort.getCategoryById(stockRequest.getId());
        Category newCategory = stockRequestMapper.toCategory(stockRequest);
        newCategory.setId(oldCategory.getId());
        categoryServicePort.updateCategory(newCategory);

    }
}
