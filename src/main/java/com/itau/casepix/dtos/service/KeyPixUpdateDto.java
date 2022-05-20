package com.itau.casepix.dtos.service;

import java.time.LocalDateTime;

public class KeyPixUpdateDto {

    private String accountType;
    private String agencyNumber;
    private String accountNumber;
    private String clientName;
    private String clientLastName;

    public KeyPixUpdateDto(String accountType, String agencyNumber, String accountNumber, String clientName, String clientLastName) {
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

}
