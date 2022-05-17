package com.itau.casepix.controllers;

import com.itau.casepix.dtos.KeyPixPostDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.services.KeyPixService;
import com.itau.casepix.services.impl.KeyPixServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class KeyPixController {

    private KeyPixService keyPixService;

    public KeyPixController(final KeyPixService keyPixService) {
        this.keyPixService = keyPixService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody KeyPixPostDto requestBody) throws DuplicateKeyPixException {
        return ResponseEntity.ok().body(keyPixService.create(requestBody));
    }
}
