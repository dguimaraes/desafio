package com.itau.casepix.mappers;

import com.itau.casepix.dtos.KeyPixPostDto;
import com.itau.casepix.entities.KeyPix;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface KeyPixMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    KeyPix toEntity(final KeyPixPostDto keyPixPostDto);

    KeyPixPostDto toPostDto(final KeyPix keyPix);
}
