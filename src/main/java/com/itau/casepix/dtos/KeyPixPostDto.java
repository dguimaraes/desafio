package com.itau.casepix.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KeyPixPostDto {

    @NotBlank
    @Size(max = 9)
    @JsonProperty("tipo_chave")
    private String keyType;

    @NotBlank
    @Size(max = 77)
    @JsonProperty("valor_chave")
    private String keyValue;

    @NotBlank
    @Size(max = 10)
    @JsonProperty("tipo_conta")
    private String accountType;

    @NotNull
    @Size(max = 4)
    @JsonProperty("numero_agencia")
    private String agencyNumber;

    @NotNull
    @Size(max = 8)
    @JsonProperty("numero_conta")
    private String accountNumber;

    @NotBlank
    @Size(max = 30)
    @JsonProperty("nome_correntista")
    private String clientName;

    @Size(max = 45)
    @JsonProperty("sobre_nome_correntista")
    private String clientLastName;

    public KeyPixPostDto(final String keyType, final String keyValue, final String accountType, final String agencyNumber, final String accountNumber, final String clientName, final String clientLastName) {
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
