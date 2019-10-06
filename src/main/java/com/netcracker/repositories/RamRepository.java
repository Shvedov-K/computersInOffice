package com.netcracker.repositories;

import com.netcracker.model.components.Ram;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RamRepository extends MongoRepository<Ram, String> {
    Ram findById(ObjectId id);
}
