package com.netcracker.repositories;

import com.netcracker.model.components.Rom;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RomRepository extends MongoRepository<Rom, String> {
    Rom findById(ObjectId id);
}
