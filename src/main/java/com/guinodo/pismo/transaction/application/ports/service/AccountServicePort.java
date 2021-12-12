package com.guinodo.pismo.transaction.application.ports.service;

import com.guinodo.pismo.transaction.application.domain.Account;

import java.util.Optional;

public interface AccountServicePort {

    Account save(Account account);
    Optional<Account> findById(Long id);
}
