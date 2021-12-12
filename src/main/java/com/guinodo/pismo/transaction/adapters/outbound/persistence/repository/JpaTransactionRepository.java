package com.guinodo.pismo.transaction.adapters.outbound.persistence.repository;

import com.guinodo.pismo.transaction.adapters.outbound.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, Long> { }
