package com.itau.casepix.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class KeyPixPatchDto {

    @NotBlank
    @Size(max = 10)
    @JsonProperty("tipo_conta")
    private String accountType;

    @NotNull
    @Size(max = 4)
    @Pattern(regexp="^\\d+$", message="Agência precisa ser um número")
    @JsonProperty("numero_agencia")
    private String agencyNumber;

    @NotNull
    @Size(max = 8)
    @Pattern(regexp="^\\d+$", message="Número da conta precisa conter somente número")
    @JsonProperty("numero_conta")
    private String accountNumber;

    @NotBlank
    @Size(max = 30)
    @JsonProperty("nome_correntista")
    private String clientName;

    @Size(max = 45)
    @JsonProperty("sobre_nome_correntista")
    private String clientLastName;

    public KeyPixPatchDto(String accountType, String agencyNumber, String accountNumber, String clientName, String clientLastName) {
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
