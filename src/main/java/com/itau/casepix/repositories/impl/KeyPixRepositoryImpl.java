package com.itau.casepix.repositories.impl;

import com.itau.casepix.entities.KeyPix;
import com.itau.casepix.repositories.KeyPixCustomRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class KeyPixRepositoryImpl implements KeyPixCustomRepository {

    private MongoOperations mongoOperations;

    private final static String INACTIVE = "inactive";

    public KeyPixRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<KeyPix> filterBy(HashMap<String, Object> filter) {
        var query = new Query();
        filter.entrySet().stream().filter(f -> f.getValue() != null).forEach((entry) -> {
            query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
        });

        return mongoOperations.find(query, KeyPix.class);
    }

    @Override
    public KeyPix upsert(UUID id, Map mapPut) {
        var query = new Query();
        query.addCriteria(Criteria.where("_id").is(id))
                .addCriteria(Criteria.where("status").ne(INACTIVE));
        var update = new Update();

        mapPut.forEach((key, value) -> update.set(String.valueOf(key), value));
        update.currentDate("updatedDate");
        mongoOperations.upsert(query, update, KeyPix.class);

        return mongoOperations.findOne(query, KeyPix.class);
    }
}
