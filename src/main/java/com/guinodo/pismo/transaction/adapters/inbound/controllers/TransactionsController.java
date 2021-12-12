package com.guinodo.pismo.transaction.adapters.inbound.controllers;

import com.guinodo.pismo.transaction.adapters.dtos.TransactionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Transactions")
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @ApiOperation(value="Create transaction")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody final TransactionDTO transaction) {
        return ResponseEntity.ok(transaction);
    }

}
