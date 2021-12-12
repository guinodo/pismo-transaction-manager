package com.guinodo.pismo.transaction.adapters.inbound.controllers;

import com.guinodo.pismo.transaction.adapters.dtos.RequestTransactionDTO;
import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.domain.CreateTransactionDomain;
import com.guinodo.pismo.transaction.application.ports.service.TransactionServicePort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Transactions")
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionServicePort transactionService;

    @ApiOperation(value="Create transaction")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody final RequestTransactionDTO requestTransaction) {
        CreateTransactionDomain createTransactionDomain = new CreateTransactionDomain();
        BeanUtils.copyProperties(requestTransaction, createTransactionDomain);
        return ResponseEntity.ok(transactionService.create(createTransactionDomain));
    }

}
