package com.itau.casepix.dtos.response;

import com.itau.casepix.dtos.EnumKeyTypeDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseUpdatedDto {

    private UUID id;

    private EnumKeyTypeDto keyType;

    private String keyValue;

    private String accountType;

    private String agencyNumber;

    private String accountNumber;

    private String clientName;

    private String clientLastName;

    private LocalDateTime updatedDate;

    public ResponseUpdatedDto(UUID id, EnumKeyTypeDto keyType, String keyValue, String accountType, String agencyNumber, String accountNumber, String clientName, String clientLastName, LocalDateTime updatedDate) {
        this.id = id;
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.updatedDate = updatedDate;
    }

    public EnumKeyTypeDto getKeyType() {
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

    public UUID getId() {
        return id;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
}
