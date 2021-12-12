package com.guinodo.pismo.transaction.adapters.outbound.persistence.repository;

import com.guinodo.pismo.transaction.adapters.outbound.persistence.entity.AccountEntity;
import com.guinodo.pismo.transaction.adapters.outbound.persistence.exception.EntityNotFundException;
import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.ports.repository.AccountRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class AccountRepository implements AccountRepositoryPort {

    @Autowired
    ModelMapper modelMapper;

    private final JpaAccountRepository repository;

    public AccountRepository(JpaAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = repository.save( modelMapper.map(account, AccountEntity.class) );
        return modelMapper.map(accountEntity, Account.class);
    }

    @Override
    public Optional<Account> findById(Long id) {

       Optional<AccountEntity> accountEntity = repository.findById(id);
       if (accountEntity.isPresent()) {
           return Optional.of(modelMapper.map(accountEntity.get(), Account.class));
       }

        throw new EntityNotFundException(String.format("Entity not found with id: %s",id));
    }

}
