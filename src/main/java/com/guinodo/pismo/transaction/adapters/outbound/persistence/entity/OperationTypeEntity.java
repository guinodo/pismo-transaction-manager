package com.guinodo.pismo.transaction.adapters.outbound.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OPERATIONS_TYPE")
public class OperationTypeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "OPERATION_TYPE_ID")
    private Long operationTypeId;

    @Column(name = "DESCRIPTION")
    private String description;

}
