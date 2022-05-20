package com.itau.casepix.repositories;

import com.itau.casepix.entities.KeyPix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface KeyPixCustomRepository {
    List<KeyPix> filterBy(HashMap<String, Object> filter);

    KeyPix upsert(UUID id, Map mapUpdate);
}
