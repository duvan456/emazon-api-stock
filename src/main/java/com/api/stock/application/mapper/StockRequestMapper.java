package com.api.stock.application.mapper;

import com.api.stock.application.dto.StockRequest;
import com.api.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface StockRequestMapper {
    Category toCategory(StockRequest stockRequest);
}
