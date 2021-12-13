package com.guinodo.pismo.transaction.adapters.inbound.controllers;

import com.guinodo.pismo.transaction.adapters.dtos.ErrorMessageDTO;
import com.guinodo.pismo.transaction.adapters.outbound.persistence.exception.EntityNotFundException;
import com.guinodo.pismo.transaction.application.exception.BusinessException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFundException.class)
    public ResponseEntity<ErrorMessageDTO> entityNotFundException(EntityNotFundException ex, WebRequest request) {
        ErrorMessageDTO message = new ErrorMessageDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessageDTO> businessException(BusinessException ex, WebRequest request) {
        ErrorMessageDTO message = new ErrorMessageDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<ErrorMessageDTO>(message, HttpStatus.BAD_REQUEST);
    }

}
