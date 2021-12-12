package com.guinodo.pismo.transaction.application.service;

import com.guinodo.pismo.transaction.application.domain.CreateTransactionDomain;
import com.guinodo.pismo.transaction.application.domain.Transaction;
import com.guinodo.pismo.transaction.application.ports.repository.TransactionRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.service.TransactionServicePort;

import java.util.Optional;

public class TransactionServiceImpl implements TransactionServicePort {

    private final TransactionRepositoryPort repository;

    public TransactionServiceImpl(TransactionRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Transaction create(CreateTransactionDomain domain) {
//      TODO implment
        return null;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

}
