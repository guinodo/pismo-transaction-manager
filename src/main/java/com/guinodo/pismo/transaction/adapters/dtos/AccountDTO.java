package com.guinodo.pismo.transaction.adapters.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountDTO {

    private Long id;

    @NotBlank
    private String documentNumber;

}
