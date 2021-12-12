package com.guinodo.pismo.transaction.adapters.outbound.persistence.repository;

import com.guinodo.pismo.transaction.adapters.outbound.persistence.entity.TransactionEntity;
import com.guinodo.pismo.transaction.adapters.outbound.persistence.exception.EntityNotFundException;
import com.guinodo.pismo.transaction.application.domain.Transaction;
import com.guinodo.pismo.transaction.application.ports.repository.TransactionRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
@Slf4j
public class TransactionRepository implements TransactionRepositoryPort {

    @Autowired
    private ModelMapper modelMapper;

    private final JpaTransactionRepository repository;

    public TransactionRepository(JpaTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = repository.save(modelMapper.map(transaction, TransactionEntity.class));

        log.info("Transaction saved: { id: {} }", transactionEntity.getTransactionId());

        return modelMapper.map(transactionEntity, Transaction.class);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        Optional<TransactionEntity> transactionEntity = repository.findById(id);
        if (transactionEntity.isPresent()) {
            return Optional.of(modelMapper.map(transactionEntity.get(), Transaction.class));
        }

        log.error("Transaction not found with id: {}", id);
        throw new EntityNotFundException(String.format("Transaction not found with id: %s",id));
    }

}
