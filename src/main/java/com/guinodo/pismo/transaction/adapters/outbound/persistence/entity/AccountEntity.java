package com.guinodo.pismo.transaction.adapters.outbound.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ACCOUNTS")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

}
