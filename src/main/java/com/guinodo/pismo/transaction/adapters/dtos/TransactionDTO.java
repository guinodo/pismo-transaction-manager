package com.guinodo.pismo.transaction.adapters.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long id;
    private double amount;
    private LocalDateTime eventDate;

}
