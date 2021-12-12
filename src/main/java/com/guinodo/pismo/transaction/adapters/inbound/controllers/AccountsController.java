package com.guinodo.pismo.transaction.adapters.inbound.controllers;

import com.guinodo.pismo.transaction.adapters.dtos.RequestAccountDTO;
import com.guinodo.pismo.transaction.application.domain.Account;
import com.guinodo.pismo.transaction.application.ports.service.AccountServicePort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Accounts")
@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {

    @Autowired
    private AccountServicePort accountService;

    @ApiOperation(value="Create account")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody final RequestAccountDTO requestAccount) {
        log.info("Request create Account: { documentNumber: {} }", requestAccount.getDocumentNumber());
        Account account = new Account();
        BeanUtils.copyProperties(requestAccount, account);
        return ResponseEntity.ok(accountService.save(account));
    }

    @ApiOperation(value="Get account")
    @GetMapping("/{accountId}")
    public ResponseEntity<?> findById(@PathVariable(value="accountId") Long accountId) {
        log.info("Request find Account: { accountId: {} }", accountId);
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findById(accountId));
    }

}
