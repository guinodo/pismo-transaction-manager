package com.guinodo.pismo.transaction.adapters.outbound.persistence.exception;

public class EntityNotFundException extends RuntimeException {
    public EntityNotFundException(final String details) {
        super(details);
    }
}
