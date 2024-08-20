package com.api.stock.infrastructure.input.rest;

import com.api.stock.application.dto.StockRequest;
import com.api.stock.application.dto.StockResponse;
import com.api.stock.application.handler.IStockHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class StockRestController {

    private final IStockHandler stockHandler;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveCategoryInStock(@RequestBody StockRequest stockRequest) {
        stockHandler.saveCategoryInStock(stockRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the categories or by id or by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StockResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<?> getCategoryFromStock(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name) {
        if (id != null) {
            return ResponseEntity.ok(stockHandler.getCategoryByIdFromStock(id));
        } else if (name != null) {
            return ResponseEntity.ok(stockHandler.getCategoryByNameFromStock(name));
        } else {
            List<StockResponse> categories = stockHandler.getAllCategoryFromStock();
            return ResponseEntity.ok(categories);
        }

    }

    @Operation(summary = "Update an existing category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<Void> updateCategoryInStock(@RequestBody StockRequest stockRequest) {
        stockHandler.updateCategoryInStock(stockRequest);
        return ResponseEntity.noContent().build();
    }

}
