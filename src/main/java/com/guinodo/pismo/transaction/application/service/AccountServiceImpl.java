package com.guinodo.pismo.transaction.application.service;

import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.domain.OperationType;
import com.guinodo.pismo.transaction.application.domain.enums.OperationTypeEnum;
import com.guinodo.pismo.transaction.application.exception.BusinessException;
import com.guinodo.pismo.transaction.application.ports.repository.AccountRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.service.AccountServicePort;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
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
    public Account updateTransaction(Long id, OperationType operationType, Double amount) {

        Account account = findById(id).orElseThrow( () -> {
            log.error("Account is invalid: { accountId: {} }", id);
            return new BusinessException(
                    String.format("Account is invalid: { accountId: %s}", id));
        });

        OperationTypeEnum operationTypeEnum = Enum.valueOf(OperationTypeEnum.class, operationType.getDescription());

        double accountAmount = account.getAmount();
        double accountCreditLimit = account.getCreditLimit();

        switch (operationTypeEnum) {
            case SAQUE:
            case COMPRA_A_VISTA:
                checkAccount(account, amount);
                account.setCreditLimit( accountCreditLimit - amount );
                account.setAmount(accountAmount - amount);
                break;

            case DEPOSITO:
                account.setCreditLimit( accountCreditLimit + amount );
                account.setAmount(accountAmount + amount);
                break;
        }

        return repository.save(account);
    }

    private void checkAccount(Account account, Double transactionAmount) {
        if(transactionAmount > account.getCreditLimit()){
            throw new BusinessException("Limit exceeded");
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id);
    }

}
