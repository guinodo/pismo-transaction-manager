package com.guinodo.pismo.transaction.adapters.inbound.controllers;

import com.guinodo.pismo.transaction.adapters.dtos.RequestAccountDTO;
import com.guinodo.pismo.transaction.adapters.dtos.ResposeAccountDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Accounts")
@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @ApiOperation(value="Create account")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody final RequestAccountDTO account) {
        return ResponseEntity.ok(account);
    }

    @ApiOperation(value="Get account")
    @GetMapping("/{accountId}")
    public ResponseEntity<?> findById(@PathVariable(value="accountId") Long accountId) {

        ResposeAccountDTO accountDTO = new ResposeAccountDTO();
        accountDTO.setAccountId(1L);
        accountDTO.setDocumentNumber("12345678900");

        return ResponseEntity.status(HttpStatus.OK).body(accountDTO);
    }

}
