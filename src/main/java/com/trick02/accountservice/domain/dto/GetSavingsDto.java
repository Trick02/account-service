package com.trick02.accountservice.domain.dto;

import com.trick02.accountservice.domain.Savings;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetSavingsDto {
    private String accountNumber;
    private String accountType;
    private BigDecimal availableBalance;

    public GetSavingsDto(Savings savings) {
        this.accountNumber = savings.getAccountNumber();
        this.accountType = savings.getAccount().getAccountType().getType();
        this.availableBalance = savings.getAvailableBalance();
    }
}
