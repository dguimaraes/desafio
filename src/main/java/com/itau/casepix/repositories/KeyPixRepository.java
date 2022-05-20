package com.itau.casepix.repositories;

import com.itau.casepix.entities.KeyPix;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KeyPixRepository extends MongoRepository<KeyPix, UUID>, KeyPixCustomRepository {
}
