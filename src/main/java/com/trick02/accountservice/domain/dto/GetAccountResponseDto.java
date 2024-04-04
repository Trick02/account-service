package com.trick02.accountservice.domain.dto;

import lombok.*;

import java.util.List;

@Getter
public class GetAccountResponseDto extends ResponseDto {

    private String customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<GetSavingsDto> savings;

    @Builder
    public GetAccountResponseDto(int transactionStatusCode,
                                 String transactionStatusDescription,
                                 String customerNumber,
                                 String customerName,
                                 String customerMobile,
                                 String customerEmail,
                                 String address1,
                                 String address2,
                                 List<GetSavingsDto> savings) {
        super(transactionStatusCode, transactionStatusDescription);
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.savings = savings;
    }
}
