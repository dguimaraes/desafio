package com.itau.casepix.mappers;

import com.itau.casepix.dtos.KeyPixPostDto;
import com.itau.casepix.entities.KeyPix;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-16T22:49:41-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class KeyPixMapperImpl implements KeyPixMapper {

    @Override
    public KeyPix toEntity(KeyPixPostDto keyPixPostDto) {
        if ( keyPixPostDto == null ) {
            return null;
        }

        String keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;

        keyType = keyPixPostDto.getKeyType();
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
    public KeyPixPostDto toPostDto(KeyPix keyPix) {
        if ( keyPix == null ) {
            return null;
        }

        String keyType = null;
        String keyValue = null;
        String accountType = null;
        String agencyNumber = null;
        String accountNumber = null;
        String clientName = null;
        String clientLastName = null;

        keyType = keyPix.getKeyType();
        keyValue = keyPix.getKeyValue();
        accountType = keyPix.getAccountType();
        agencyNumber = keyPix.getAgencyNumber();
        accountNumber = keyPix.getAccountNumber();
        clientName = keyPix.getClientName();
        clientLastName = keyPix.getClientLastName();

        KeyPixPostDto keyPixPostDto = new KeyPixPostDto( keyType, keyValue, accountType, agencyNumber, accountNumber, clientName, clientLastName );

        return keyPixPostDto;
    }
}
