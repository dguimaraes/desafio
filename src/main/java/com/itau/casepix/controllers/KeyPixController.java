package com.itau.casepix.controllers;

import com.itau.casepix.dtos.request.FilterKeyPix;
import com.itau.casepix.dtos.request.KeyPixPatchDto;
import com.itau.casepix.dtos.request.KeyPixPostDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;
import com.itau.casepix.exceptions.NotFoundException;
import com.itau.casepix.services.KeyPixService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class KeyPixController {

    private static final String APPLICATION_JSON_VALUE = "application/json";
    private final KeyPixService keyPixService;

    public KeyPixController(final KeyPixService keyPixService) {
        this.keyPixService = keyPixService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody final KeyPixPostDto requestBody) throws DuplicateKeyPixException {
        return ResponseEntity.ok().body(keyPixService.create(requestBody));
    }

    @PatchMapping
    public ResponseEntity update(@RequestParam final UUID id, @Valid @RequestBody KeyPixPatchDto requestBody) {
        return ResponseEntity.ok().body(keyPixService.update(id, requestBody));
    }

    @GetMapping(value = "/find-by-id")
    public ResponseEntity getById(@RequestParam final UUID id) throws NotFoundException {
        return ResponseEntity.ok().body(keyPixService.findById(id));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity filter(@Valid @ModelAttribute final FilterKeyPix filterKeyPix) throws NotFoundException {
        return ResponseEntity.ok().body(keyPixService.findByFilter(filterKeyPix));
    }
}
