package com.valtek.backend_database.persistence.validate;

public class BusinessException extends Exception {

    private final String code;
    private final String message;

    public BusinessException() {
        this.code = "";
        this.message = "";
    }

    public BusinessException(String code) {
        this.code = code;
        this.message = "";
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getExceptionCode() {
        return code;
    }

    public String getExceptionMessage() {
        return code + ", " + message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}