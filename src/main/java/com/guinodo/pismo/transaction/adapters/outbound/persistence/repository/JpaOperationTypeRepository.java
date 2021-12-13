package com.guinodo.pismo.transaction.adapters.outbound.persistence.repository;

import com.guinodo.pismo.transaction.adapters.outbound.persistence.entity.OperationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOperationTypeRepository extends JpaRepository<OperationTypeEntity, Long> { }
