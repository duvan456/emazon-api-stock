package com.api.stock.infrastructure.exceptionhandler;

public enum ExceptionResponse {

    CATEGORY_NOT_FOUND("No Category was found with that name"),
    CATEGORY_ID_ALREADY_EXISTS("There is already a category with that id"),
    CATEGORY_NAME_ALREADY_EXISTS("here is already a category with that name"),
    NO_DATA_FOUND("No data found for the requested petition");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
