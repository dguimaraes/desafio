package com.itau.casepix.entities;

public class KeyPix extends BaseEntity{

    private String keyType;
    private String keyValue;
    private String accountType;
    private String agencyNumber;
    private String accountNumber;
    private String clientName;
    private String clientLastName;

    public KeyPix(final String keyType, final String keyValue, final String accountType, final String agencyNumber, final String accountNumber, final String clientName, final String clientLastName) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
    }

    public String getKeyType() {
        return keyType;
    }

    public String getKeyValue() {
        return keyValue;
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
