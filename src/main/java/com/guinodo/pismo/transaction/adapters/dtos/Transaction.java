package com.guinodo.pismo.transaction.adapters.dtos;

import lombok.Data;

@Data
public class Transaction {

    private Long id;
    private Long operationTypeId;
    private double amount;

}
