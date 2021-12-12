package com.guinodo.pismo.transaction.application.ports.repository;

import com.guinodo.pismo.transaction.application.domain.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    Account save(Account account);
    Optional<Account> findById(Long id);
}
