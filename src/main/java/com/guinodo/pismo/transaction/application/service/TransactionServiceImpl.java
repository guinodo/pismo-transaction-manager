package com.guinodo.pismo.transaction.application.service;

import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.domain.CreateTransactionDomain;
import com.guinodo.pismo.transaction.application.domain.OperationType;
import com.guinodo.pismo.transaction.application.domain.Transaction;
import com.guinodo.pismo.transaction.application.exception.BusinessException;
import com.guinodo.pismo.transaction.application.ports.repository.OperationTypeRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.repository.TransactionRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.service.TransactionServicePort;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class TransactionServiceImpl implements TransactionServicePort {

    private final TransactionRepositoryPort repository;
    private final OperationTypeRepositoryPort operationTypeRepository;

    public TransactionServiceImpl(TransactionRepositoryPort repository, OperationTypeRepositoryPort operationTypeRepository) {
        this.repository = repository;
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public Transaction create(CreateTransactionDomain domain) {
        OperationType operationType = operationTypeRepository.findById(domain.getOperationTypeId()).orElseThrow ( () -> {
            log.error("Operation is invalid: { operationTypeId: {} }", domain.getOperationTypeId());
            return new BusinessException(
                    String.format("Operation is invalid: { operationTypeId: %s}", domain.getOperationTypeId()));
        });

        return repository.save(domainToTransaction(domain));
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

    public Transaction domainToTransaction(CreateTransactionDomain domain) {
        Transaction transaction = new Transaction();
        Account account = new Account();
        account.setAccountId(domain.getAccountId());
        OperationType operationType = new OperationType();
        operationType.setOperationTypeId(domain.getOperationTypeId());

        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        transaction.setAmount(domain.getAmount());
        transaction.setEventDate(LocalDateTime.now());

        return transaction;
    }

}
