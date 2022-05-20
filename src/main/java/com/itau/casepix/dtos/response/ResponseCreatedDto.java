package com.itau.casepix.dtos.response;

import java.util.UUID;

public class ResponseCreatedDto {

    private UUID id;

    public ResponseCreatedDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
