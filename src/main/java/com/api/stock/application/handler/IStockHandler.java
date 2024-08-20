package com.api.stock.application.handler;

import com.api.stock.application.dto.StockRequest;
import com.api.stock.application.dto.StockResponse;

import java.util.List;

public interface IStockHandler {

    void saveCategoryInStock(StockRequest stockRequest);
    List<StockResponse> getAllCategoryFromStock();
    StockResponse getCategoryByIdFromStock(Long categoryId);
    StockResponse getCategoryByNameFromStock(String categoryName);
    void updateCategoryInStock(StockRequest stockRequest);

    // no exponer los deletes
    // void deleteCategoryFromStock(Category category);

}
