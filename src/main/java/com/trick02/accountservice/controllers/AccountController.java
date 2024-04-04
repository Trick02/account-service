package com.trick02.accountservice.controllers;

import com.trick02.accountservice.domain.Account;
import com.trick02.accountservice.domain.dto.*;
import com.trick02.accountservice.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody CreateAccountRequestDto dto) {
        if(StringUtils.isEmpty(dto.getCustomerEmail())){
            return new ResponseEntity<>(new ResponseDto(HttpStatus.BAD_REQUEST.value(), "Email is required field"),
                    HttpStatus.BAD_REQUEST);
        }
        Account account = accountService.getAccountByEmail(dto.getCustomerEmail().toString()).orElse(null);
        if (Objects.nonNull(account)) {
            return new ResponseEntity<>(new ResponseDto(HttpStatus.BAD_REQUEST.value(), "Invalid email"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(CreateAccountResponseDto.builder()
                .customerNumber(accountService.createAccount(dto).getId())
                .transactionStatusCode(HttpStatus.CREATED.value())
                .transactionStatusDescription("Customer account created")
                .build(),
                HttpStatus.CREATED);

    }

    @GetMapping(value = "/{customerNumber}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAccount(@PathVariable("customerNumber") Long customerNumber) {
        Account account = accountService.getAccount(customerNumber).orElse(null);
        if (Objects.isNull(account)) {
            return new ResponseEntity<>(new ResponseDto(HttpStatus.NOT_FOUND.value(), "Customer not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(GetAccountResponseDto.builder()
                .transactionStatusCode(HttpStatus.FOUND.value())
                .transactionStatusDescription("Customer Account found")
                .customerNumber(account.getId().toString())
                .customerName(account.getCustomerName())
                .customerMobile(account.getCustomerMobile())
                .customerEmail(account.getCustomerEmail())
                .address1(account.getAddress1())
                .address2(account.getAddress2())
                .savings(account.getSavings().stream().map(GetSavingsDto::new).collect(Collectors.toList()))
                .build(),
                HttpStatus.FOUND);

    }
}
