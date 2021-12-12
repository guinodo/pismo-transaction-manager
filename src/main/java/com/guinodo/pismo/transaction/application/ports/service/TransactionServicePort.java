package com.guinodo.pismo.transaction.application.ports.service;

import com.guinodo.pismo.transaction.application.domain.Transaction;

import java.util.Optional;

public interface TransactionServicePort {

    Transaction save(Transaction transaction);
    Optional<Transaction> findById(Long id);

}
