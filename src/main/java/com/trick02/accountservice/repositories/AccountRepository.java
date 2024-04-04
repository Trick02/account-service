package com.trick02.accountservice.repositories;

import com.trick02.accountservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerEmail(String email);
}
