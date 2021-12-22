package com.guinodo.pismo.transaction.application.domain.enums;

public enum OperationTypeEnum {
    COMPRA_A_VISTA(1L),
    SAQUE(2L),
    DEPOSITO(3L);

    private Long id;

    OperationTypeEnum(Long i) {
        this.id = id;
    }
}
