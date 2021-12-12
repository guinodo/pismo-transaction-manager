package com.guinodo.pismo.transaction.application.ports.service;

import com.guinodo.pismo.transaction.application.domain.CreateTransactionDomain;
import com.guinodo.pismo.transaction.application.domain.Transaction;

import java.util.Optional;

public interface TransactionServicePort {

    Transaction create(CreateTransactionDomain createTransaction);
    Optional<Transaction> findById(Long id);

}
