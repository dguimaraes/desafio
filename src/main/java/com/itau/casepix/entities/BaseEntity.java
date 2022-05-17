package com.itau.casepix.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Document
public class BaseEntity {
    @Id
    private UUID id;

    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OffsetDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(OffsetDateTime updatedDate) {
        this.updatedDate = OffsetDateTime.now();
    }

    public BaseEntity() {
        this.id = UUID.randomUUID();;
        this.createdDate = OffsetDateTime.now();
    }
}
