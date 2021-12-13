package com.guinodo.pismo.transaction.application.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(final String details) {
        super(details);
    }
}
