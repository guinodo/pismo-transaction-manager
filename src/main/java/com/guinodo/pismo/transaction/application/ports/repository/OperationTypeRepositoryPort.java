package com.guinodo.pismo.transaction.application.ports.repository;

import com.guinodo.pismo.transaction.application.domain.OperationType;

import java.util.Optional;

public interface OperationTypeRepositoryPort {
    Optional<OperationType> findById(Long id);
}
