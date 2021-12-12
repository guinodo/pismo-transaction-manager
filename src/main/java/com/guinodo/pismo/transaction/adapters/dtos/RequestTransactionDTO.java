package com.guinodo.pismo.transaction.adapters.dtos;

import lombok.Data;

@Data
public class RequestTransactionDTO {

    private Long accountId;
    private Long operationTypeId;
    private Double amount;

}
