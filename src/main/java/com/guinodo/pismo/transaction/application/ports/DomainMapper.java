package com.guinodo.pismo.transaction.application.ports;

import java.io.Serializable;

public interface DomainMapper<R extends Serializable, E extends Serializable> {
    default E mapToDomain(final R domain) {
        throw new UnsupportedOperationException();
    }

    default R mapToRest(final E rest) {
        throw new UnsupportedOperationException();
    }
}
