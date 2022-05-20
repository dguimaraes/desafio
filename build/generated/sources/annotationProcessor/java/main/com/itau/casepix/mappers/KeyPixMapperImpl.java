package com.itau.casepix.mappers;

import com.itau.casepix.dtos.EnumKeyTypeDto;
import com.itau.casepix.dtos.request.FilterKeyPix;
import com.itau.casepix.dtos.request.KeyPixPatchDto;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.dtos.response.ResponseCreatedDto;
import com.itau.casepix.dtos.response.ResponseGetDto;
import com.itau.casepix.dtos.response.ResponseUpdatedDto;
import com.itau.casepix.dtos.service.KeyPixUpdateDto;
import com.itau.casepix.entities.EnumKeyType;
import com.itau.casepix.entities.KeyPix;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T00:11:29-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class KeyPixMapperImpl implements KeyPixMapper {

    @Override
    public KeyPix toEntity(KeyPixPostDto keyPixPostDto) {
        if ( keyPixPostDto == null ) {
            return null;
        }

        EnumKeyType keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;

        keyType = enumKeyTypeDtoToEnumKeyType( keyPixPostDto.getKeyType() );
        keyValue = keyPixPostDto.getKeyValue();
        accountType = keyPixPostDto.getAccountType();
        agencyNumber = keyPixPostDto.getAgencyNumber();
        accountNumber = keyPixPostDto.getAccountNumber();
        clientName = keyPixPostDto.getClientName();
        clientLastName = keyPixPostDto.getClientLastName();

        KeyPix keyPix = new KeyPix( keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName );

        return keyPix;
    }

    @Override
    public KeyPix toEntity(FilterKeyPix filterKeyPix) {
        if ( filterKeyPix == null ) {
            return null;
        }

        EnumKeyType keyType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;

        keyType = enumKeyTypeDtoToEnumKeyType( filterKeyPix.getKeyType() );
        agencyNumber = filterKeyPix.getAgencyNumber();
        accountNumber = filterKeyPix.getAccountNumber();
        clientName = filterKeyPix.getClientName();

        String keyValue = null;
        String accountType = null;
        String clientLastName = null;

        KeyPix keyPix = new KeyPix( keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName );

        return keyPix;
    }

    @Override
    public KeyPixPostDto toPostDto(KeyPix keyPix) {
        if ( keyPix == null ) {
            return null;
        }

        EnumKeyTypeDto keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;

        keyType = enumKeyTypeToEnumKeyTypeDto( keyPix.getKeyType() );
        keyValue = keyPix.getKeyValue();
        accountType = keyPix.getAccountType();
        agencyNumber = keyPix.getAgencyNumber();
        accountNumber = keyPix.getAccountNumber();
        clientName = keyPix.getClientName();
        clientLastName = keyPix.getClientLastName();

        KeyPixPostDto keyPixPostDto = new KeyPixPostDto( keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName );

        return keyPixPostDto;
    }

    @Override
    public ResponseCreatedDto toResponseCreatedDto(KeyPix keyPix) {
        if ( keyPix == null ) {
            return null;
        }

        UUID id = null;

        id = keyPix.getId();

        ResponseCreatedDto responseCreatedDto = new ResponseCreatedDto( id );

        return responseCreatedDto;
    }

    @Override
    public ResponseUpdatedDto toResponseUpdatedDto(KeyPix keyPix) {
        if ( keyPix == null ) {
            return null;
        }

        UUID id = null;
        EnumKeyTypeDto keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;
        LocalDateTime updatedDate = null;

        id = keyPix.getId();
        keyType = enumKeyTypeToEnumKeyTypeDto( keyPix.getKeyType() );
        keyValue = keyPix.getKeyValue();
        accountType = keyPix.getAccountType();
        agencyNumber = keyPix.getAgencyNumber();
        accountNumber = keyPix.getAccountNumber();
        clientName = keyPix.getClientName();
        clientLastName = keyPix.getClientLastName();
        updatedDate = keyPix.getUpdatedDate();

        ResponseUpdatedDto responseUpdatedDto = new ResponseUpdatedDto( id, keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName, updatedDate );

        return responseUpdatedDto;
    }

    @Override
    public ResponseGetDto toResponseGetDto(KeyPix keyPix) {
        if ( keyPix == null ) {
            return null;
        }

        UUID id = null;
        EnumKeyTypeDto keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;
        LocalDateTime updatedDate = null;
        LocalDateTime createdDate = null;

        id = keyPix.getId();
        keyType = enumKeyTypeToEnumKeyTypeDto( keyPix.getKeyType() );
        keyValue = keyPix.getKeyValue();
        accountType = keyPix.getAccountType();
        agencyNumber = keyPix.getAgencyNumber();
        accountNumber = keyPix.getAccountNumber();
        clientName = keyPix.getClientName();
        clientLastName = keyPix.getClientLastName();
        updatedDate = keyPix.getUpdatedDate();
        createdDate = keyPix.getCreatedDate();

        ResponseGetDto responseGetDto = new ResponseGetDto( id, keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName, updatedDate, createdDate );

        return responseGetDto;
    }

    @Override
    public KeyPixUpdateDto toEntityUpdate(KeyPixPatchDto keyPixPatchDto) {
        if ( keyPixPatchDto == null ) {
            return null;
        }

        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;

        accountType = keyPixPatchDto.getAccountType();
        agencyNumber = keyPixPatchDto.getAgencyNumber();
        accountNumber = keyPixPatchDto.getAccountNumber();
        clientName = keyPixPatchDto.getClientName();
        clientLastName = keyPixPatchDto.getClientLastName();

        KeyPixUpdateDto keyPixUpdateDto = new KeyPixUpdateDto( accountType, agencyNumber, accountNumber, clientName, clientLastName );

        return keyPixUpdateDto;
    }

    protected EnumKeyType enumKeyTypeDtoToEnumKeyType(EnumKeyTypeDto enumKeyTypeDto) {
        if ( enumKeyTypeDto == null ) {
            return null;
        }

        EnumKeyType enumKeyType;

        switch ( enumKeyTypeDto ) {
            case CPF: enumKeyType = EnumKeyType.CPF;
            break;
            case CNPJ: enumKeyType = EnumKeyType.CNPJ;
            break;
            case EMAIL: enumKeyType = EnumKeyType.EMAIL;
            break;
            case CELULAR: enumKeyType = EnumKeyType.CELULAR;
            break;
            case ALEATORIO: enumKeyType = EnumKeyType.ALEATORIO;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + enumKeyTypeDto );
        }

        return enumKeyType;
    }

    protected EnumKeyTypeDto enumKeyTypeToEnumKeyTypeDto(EnumKeyType enumKeyType) {
        if ( enumKeyType == null ) {
            return null;
        }

        EnumKeyTypeDto enumKeyTypeDto;

        switch ( enumKeyType ) {
            case CPF: enumKeyTypeDto = EnumKeyTypeDto.CPF;
            break;
            case CNPJ: enumKeyTypeDto = EnumKeyTypeDto.CNPJ;
            break;
            case EMAIL: enumKeyTypeDto = EnumKeyTypeDto.EMAIL;
            break;
            case CELULAR: enumKeyTypeDto = EnumKeyTypeDto.CELULAR;
            break;
            case ALEATORIO: enumKeyTypeDto = EnumKeyTypeDto.ALEATORIO;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + enumKeyType );
        }

        return enumKeyTypeDto;
    }
}
