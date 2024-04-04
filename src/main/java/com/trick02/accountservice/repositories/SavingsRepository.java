package com.trick02.accountservice.repositories;

import com.trick02.accountservice.domain.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
