package com.trick02.accountservice.domain.dto;

import com.trick02.accountservice.domain.Account;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateAccountRequestDto {
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private Account.AccountType accountType;
}
