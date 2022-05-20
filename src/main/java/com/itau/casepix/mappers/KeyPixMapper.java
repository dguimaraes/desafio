package com.itau.casepix.mappers;

import com.itau.casepix.dtos.request.FilterKeyPix;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.dtos.request.KeyPixPatchDto;
import com.itau.casepix.dtos.response.ResponseCreatedDto;
import com.itau.casepix.dtos.response.ResponseGetDto;
import com.itau.casepix.dtos.response.ResponseUpdatedDto;
import com.itau.casepix.dtos.service.KeyPixUpdateDto;
import com.itau.casepix.entities.KeyPix;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface KeyPixMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    KeyPix toEntity(final KeyPixPostDto keyPixPostDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    KeyPix toEntity(final FilterKeyPix filterKeyPix);

    KeyPixPostDto toPostDto(final KeyPix keyPix);

    ResponseCreatedDto toResponseCreatedDto(final KeyPix keyPix);

    ResponseUpdatedDto toResponseUpdatedDto(final KeyPix keyPix);

    ResponseGetDto toResponseGetDto(final KeyPix keyPix);

    KeyPixUpdateDto toEntityUpdate(final KeyPixPatchDto keyPixPatchDto);

}
