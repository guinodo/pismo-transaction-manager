package com.guinodo.pismo.transaction.application.domain.enums;

public enum OperationTypeEnum {
    COMPRA_A_VISTA(1L),
    COMPRA_PARCELADA(2L),
    SAQUE(3L),
    PAGAMENTO(3L);

    private Long id;

    OperationTypeEnum(Long i) {
        this.id = id;
    }
}
