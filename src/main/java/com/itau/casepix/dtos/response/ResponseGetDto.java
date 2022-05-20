package com.itau.casepix.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.casepix.dtos.EnumKeyTypeDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseGetDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("tipo_chave")
    private EnumKeyTypeDto keyType;

    @JsonProperty("valor_chave")
    private String keyValue;

    @JsonProperty("tipo_conta")
    private String accountType;

    @JsonProperty("numero_agencia")
    private String agencyNumber;

    @JsonProperty("numero_conta")
    private String accountNumber;

    @JsonProperty("nome_correntista")
    private String clientName;

    @JsonProperty("sobre_nome_correntista")
    private String clientLastName;

    @JsonProperty("data_inclusao")
    private LocalDateTime createdDate;

    public ResponseGetDto(UUID id, EnumKeyTypeDto keyType, String keyValue, String accountType, String agencyNumber, String accountNumber, String clientName, String clientLastName, LocalDateTime updatedDate, LocalDateTime createdDate) {
        this.id = id;
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.createdDate = createdDate;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
