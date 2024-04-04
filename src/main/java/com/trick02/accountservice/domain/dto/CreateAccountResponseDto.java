package com.trick02.accountservice.domain.dto;

import lombok.*;

@Getter
public class CreateAccountResponseDto extends ResponseDto {
    private Long customerNumber;

    @Builder
    public CreateAccountResponseDto(int transactionStatusCode, String transactionStatusDescription, Long customerNumber) {
        super(transactionStatusCode, transactionStatusDescription);
        this.customerNumber = customerNumber;
    }
}
