package com.trick02.accountservice.services;

import com.trick02.accountservice.domain.Account;
import com.trick02.accountservice.domain.dto.CreateAccountRequestDto;
import com.trick02.accountservice.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(CreateAccountRequestDto dto) {
        Account account = Account.builder()
                .customerName(dto.getCustomerName())
                .customerMobile(dto.getCustomerMobile())
                .customerEmail(dto.getCustomerEmail().toLowerCase())
                .address1(dto.getAddress1())
                .address2(dto.getAddress2())
                .accountType(dto.getAccountType())
                .build();
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByCustomerEmail(email);
    }
}
