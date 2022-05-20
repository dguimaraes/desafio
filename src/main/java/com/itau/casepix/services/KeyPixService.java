package com.itau.casepix.services;

import com.itau.casepix.dtos.request.FilterKeyPix;
import com.itau.casepix.dtos.request.KeyPixPatchDto;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.dtos.response.ResponseCreatedDto;
import com.itau.casepix.dtos.response.ResponseGetDto;
import com.itau.casepix.dtos.response.ResponseUpdatedDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface KeyPixService {
    ResponseCreatedDto create(final KeyPixPostDto keyPixPostDto) throws DuplicateKeyPixException;

    ResponseUpdatedDto update(final UUID id, final KeyPixPatchDto keyPixPatchDto);

    ResponseGetDto findById(UUID id) throws NotFoundException;

    List<ResponseGetDto> findByFilter(FilterKeyPix filterKeyPix) throws NotFoundException;
}
