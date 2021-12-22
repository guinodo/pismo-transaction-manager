package com.guinodo.pismo.transaction.application.ports.service;

import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.domain.OperationType;

import java.util.Optional;

public interface AccountServicePort {

    Account save(Account account);

    Account updateTransaction(Long id, OperationType operationType, Double amount);

    Optional<Account> findById(Long id);
}
