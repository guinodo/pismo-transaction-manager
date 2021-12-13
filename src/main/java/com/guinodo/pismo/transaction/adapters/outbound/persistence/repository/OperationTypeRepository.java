package com.guinodo.pismo.transaction.adapters.outbound.persistence.repository;

import com.guinodo.pismo.transaction.adapters.outbound.persistence.entity.OperationTypeEntity;
import com.guinodo.pismo.transaction.adapters.outbound.persistence.exception.EntityNotFundException;
import com.guinodo.pismo.transaction.application.domain.OperationType;
import com.guinodo.pismo.transaction.application.ports.repository.OperationTypeRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@Primary
@Slf4j
public class OperationTypeRepository implements OperationTypeRepositoryPort {

    @Autowired
    private ModelMapper modelMapper;

    private final JpaOperationTypeRepository repository;

    public OperationTypeRepository(JpaOperationTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<OperationType> findById(Long id) {
        Optional<OperationTypeEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return Optional.of(modelMapper.map(entity.get(), OperationType.class));
        }

        log.error("OperationType not found with id: {}", id);
        return Optional.empty();
    }
}
