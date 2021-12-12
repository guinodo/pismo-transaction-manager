package com.guinodo.pismo.transaction.application.service;

import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.ports.repository.AccountRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.service.AccountServicePort;

import java.util.Optional;

public class AccountServiceImpl implements AccountServicePort {

    private final AccountRepositoryPort repository;

    public AccountServiceImpl(AccountRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id);
    }

}
