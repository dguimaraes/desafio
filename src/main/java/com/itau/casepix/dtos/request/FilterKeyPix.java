package com.itau.casepix.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.casepix.dtos.EnumKeyTypeDto;
import com.itau.casepix.entities.EnumKeyType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FilterKeyPix {

    @Schema(implementation = EnumKeyType.class)
    private EnumKeyTypeDto keyType;

    @Size(max = 4)
    @Pattern(regexp="^\\d+$", message="Agência precisa ser um número")
    private String agencyNumber;

    @Size(max = 8)
    @Pattern(regexp="^\\d+$", message="Número da conta precisa conter somente número")
    private String accountNumber;

    @Size(max = 30)
    private String clientName;

    public FilterKeyPix(EnumKeyTypeDto keyType, String agencyNumber, String accountNumber, String clientName) {
        this.keyType = keyType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
    }

    public void setKeyType(EnumKeyTypeDto keyType) {
        this.keyType = keyType;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public EnumKeyTypeDto getKeyType() {
        return keyType;
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
}
