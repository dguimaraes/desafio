package com.itau.casepix.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itau.casepix.dtos.EnumKeyTypeDto;
import com.itau.casepix.entities.EnumKeyType;
import com.itau.casepix.validations.annotations.KeyPix;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@KeyPix(message = "Chave pix inválida")
public class KeyPixPostDto {


    @JsonProperty("tipo_chave")
    @Schema(implementation = EnumKeyType.class)
    private EnumKeyTypeDto keyType;

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

    public KeyPixPostDto(final EnumKeyTypeDto keyType, final String keyValue, final String accountType, final String agencyNumber, final String accountNumber, final String clientName, final String clientLastName) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountType = accountType;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
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

}
