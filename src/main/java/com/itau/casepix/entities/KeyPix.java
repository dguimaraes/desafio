package com.itau.casepix.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class KeyPix extends BaseEntity{

    private EnumKeyType keyType;
    private String keyValue;
    private String accountType;
    private String agencyNumber;
    private String accountNumber;
    private String clientName;
    private String clientLastName;

    public KeyPix(final EnumKeyType keyType, final String keyValue, final String accountType, final String agencyNumber, final String accountNumber, final String clientName, final String clientLastName) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
    }

    public EnumKeyType getKeyType() {
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
