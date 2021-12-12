package com.guinodo.pismo.transaction.adapters.outbound.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "OPERATION_TYPE_ID")
    private OperationTypeEntity operationType;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "EVENT_DATE")
    private LocalDateTime eventDate;

}
