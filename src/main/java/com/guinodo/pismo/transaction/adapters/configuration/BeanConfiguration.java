package com.guinodo.pismo.transaction.adapters.configuration;

import com.guinodo.pismo.transaction.Application;
import com.guinodo.pismo.transaction.application.ports.repository.AccountRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.repository.OperationTypeRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.repository.TransactionRepositoryPort;
import com.guinodo.pismo.transaction.application.ports.service.AccountServicePort;
import com.guinodo.pismo.transaction.application.ports.service.TransactionServicePort;
import com.guinodo.pismo.transaction.application.service.AccountServiceImpl;
import com.guinodo.pismo.transaction.application.service.TransactionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    TransactionServicePort transactionServicePort(
            TransactionRepositoryPort repository,
            OperationTypeRepositoryPort operationTypeRepository,
            AccountServicePort accountServicePort
    ) {
        return new TransactionServiceImpl(repository, accountServicePort, operationTypeRepository);
    }

    @Bean
    AccountServicePort accountServicePort(AccountRepositoryPort repository) {
        return new AccountServiceImpl(repository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
