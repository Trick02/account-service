package com.trick02.accountservice.domain.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private int transactionStatusCode;
    private String transactionStatusDescription;
}
