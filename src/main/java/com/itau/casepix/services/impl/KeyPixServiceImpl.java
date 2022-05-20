package com.itau.casepix.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.itau.casepix.dtos.request.FilterKeyPix;
import com.itau.casepix.dtos.request.KeyPixPatchDto;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.dtos.response.ResponseCreatedDto;
import com.itau.casepix.dtos.response.ResponseGetDto;
import com.itau.casepix.dtos.response.ResponseUpdatedDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.exceptions.NotFoundException;
import com.itau.casepix.mappers.KeyPixMapper;
import com.itau.casepix.repositories.KeyPixRepository;
import com.itau.casepix.services.KeyPixService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KeyPixServiceImpl implements KeyPixService {

    private final KeyPixRepository keyPixRepository;
    private final KeyPixMapper keyPixMapper;

    private final ObjectMapper objectMapper;

    public KeyPixServiceImpl(final KeyPixRepository keyPixRepository, final KeyPixMapper keyPixMapper) {
        this.keyPixRepository = keyPixRepository;
        this.keyPixMapper = keyPixMapper;
        this.objectMapper = JsonMapper.builder().findAndAddModules().build();;
    }

    public ResponseCreatedDto create(final @Valid KeyPixPostDto keyPixPostDto) throws DuplicateKeyPixException {
        try {
            return keyPixMapper.toResponseCreatedDto(keyPixRepository.save(keyPixMapper.toEntity(keyPixPostDto)));
        } catch (DuplicateKeyException dex) {
            throw new DuplicateKeyPixException("Duplicate KeyPix value");
        }
    }

    @Override
    public ResponseUpdatedDto update(UUID id, KeyPixPatchDto keyPixPatchDto) {
        var updateDto = keyPixMapper.toEntityUpdate(keyPixPatchDto);
        HashMap<? extends Object, ? extends Object> mapUpdate = objectMapper.convertValue(updateDto, HashMap.class);

        return keyPixMapper.toResponseUpdatedDto(keyPixRepository.upsert(id, mapUpdate));
    }

    @Override
    public ResponseGetDto findById(UUID id) throws NotFoundException {
        return keyPixMapper.toResponseGetDto(keyPixRepository.findById(id).orElseThrow(() -> new NotFoundException("Chave não encontrada")));
    }

    @Override
    public List<ResponseGetDto> findByFilter(FilterKeyPix filterKeyPix) throws NotFoundException {
        HashMap<String, Object> mapFilter = objectMapper.convertValue(filterKeyPix, HashMap.class);
        var listKeyPix = keyPixRepository.filterBy(mapFilter);
        if (listKeyPix.isEmpty()) throw new NotFoundException("Chave não encontrada");
        return listKeyPix.stream().map(keyPixMapper::toResponseGetDto).collect(Collectors.toList());
    }

}
