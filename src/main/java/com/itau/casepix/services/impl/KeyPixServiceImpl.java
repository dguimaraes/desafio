package com.itau.casepix.services.impl;

import com.itau.casepix.dtos.KeyPixPostDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.mappers.KeyPixMapper;
import com.itau.casepix.repositories.KeyPixRepository;
import com.itau.casepix.services.KeyPixService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class KeyPixServiceImpl implements KeyPixService {

    private final KeyPixRepository keyPixRepository;
    private final KeyPixMapper keyPixMapper;

    public KeyPixServiceImpl(final KeyPixRepository keyPixRepository, final KeyPixMapper keyPixMapper) {
        this.keyPixRepository = keyPixRepository;
        this.keyPixMapper = keyPixMapper;
    }

    public Object create(final KeyPixPostDto keyPixPostDto) throws DuplicateKeyPixException {
        try {
            return keyPixRepository.save(keyPixMapper.toEntity(keyPixPostDto)).getId();
        } catch (DuplicateKeyException dex) {
            throw new DuplicateKeyPixException("Duplicate KeyPix value");
        }
    }
}
