package com.api.stock.infrastructure.exceptionhandler;

import com.api.stock.infrastructure.exception.CategoryNameAlreadyExistsException;
import com.api.stock.infrastructure.exception.NoDataFoundException;
import com.api.stock.infrastructure.exception.CategoryIdAlreadyExistsException;
import com.api.stock.infrastructure.exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryIdAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryIdAlreadyExistsException(
            CategoryIdAlreadyExistsException categoryIdAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ID_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(CategoryNameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameAlreadyExistsException(
            CategoryNameAlreadyExistsException categoryNameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NAME_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NOT_FOUND.getMessage()));
    }

}
