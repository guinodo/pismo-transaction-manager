package com.guinodo.pismo.transaction.application.ports.repository;

import com.guinodo.pismo.transaction.application.domain.Transaction;

import java.util.Optional;

public interface TransactionRepositoryPort {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);
}
