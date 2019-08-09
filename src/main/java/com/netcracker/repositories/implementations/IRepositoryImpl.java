package com.netcracker.repositories.implementations;

import com.netcracker.model.Office;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class IRepositoryImpl extends SimpleMongoRepository<Office, String> {

    public IRepositoryImpl(MongoEntityInformation metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}
