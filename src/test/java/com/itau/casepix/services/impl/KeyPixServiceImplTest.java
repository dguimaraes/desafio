package com.itau.casepix.services.impl;

import com.itau.casepix.dtos.EnumKeyTypeDto;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.entities.EnumKeyType;
import com.itau.casepix.entities.KeyPix;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.mappers.KeyPixMapper;
import com.itau.casepix.repositories.KeyPixRepository;
import com.itau.casepix.services.KeyPixService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;

@ExtendWith(MockitoExtension.class)
class KeyPixServiceImplTest {

    @Mock
    private KeyPixRepository keyPixRepository;
    @Mock
    private KeyPixMapper keyPixMapper;

    private KeyPixService keyPixService;

    @BeforeEach
    void setup() {
        keyPixService = new KeyPixServiceImpl(keyPixRepository, keyPixMapper);
    }

    @Test
    void create() throws DuplicateKeyPixException {
        var keyPixPostDto = new KeyPixPostDto(EnumKeyTypeDto.CELULAR, "+557198899888", "corrente", "1234", "123444", "Danilo", null);
        var keyPix = new KeyPix(EnumKeyType.CELULAR, "+557198899888", "corrente", "1234", "123444", "Danilo", null);
        Mockito.when(keyPixMapper.toEntity(keyPixPostDto)).thenReturn(keyPix);
        Mockito.when(keyPixRepository.save(keyPix)).thenReturn(keyPix);

        keyPixService.create(keyPixPostDto);

        Mockito.verify(keyPixMapper).toEntity(keyPixPostDto);
        Mockito.verify(keyPixRepository).save(keyPix);
        Mockito.verify(keyPixMapper).toResponseCreatedDto(keyPix);
    }

    @Test
    void create_duplicate_key_pix() throws DuplicateKeyPixException {
        var keyPixPostDto = new KeyPixPostDto(EnumKeyTypeDto.CELULAR, "+557198899888", "corrente", "1234", "123444", "Danilo", null);
        var keyPix = new KeyPix(EnumKeyType.CELULAR, "+557198899888", "corrente", "1234", "123444", "Danilo", null);
        Mockito.when(keyPixMapper.toEntity(keyPixPostDto)).thenReturn(keyPix);
        Mockito.when(keyPixRepository.save(keyPix)).thenThrow(new DuplicateKeyException(""));

        DuplicateKeyPixException thrown = Assertions.assertThrows(
                DuplicateKeyPixException.class,
                () -> keyPixService.create(keyPixPostDto)
        );

        Assertions.assertTrue(thrown.getMessage().contains("Duplicate KeyPix value"));

        Mockito.verify(keyPixMapper).toEntity(keyPixPostDto);
        Mockito.verify(keyPixRepository).save(keyPix);
        Mockito.verify(keyPixMapper, Mockito.times(0)).toResponseCreatedDto(keyPix);
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByFilter() {
    }
}