package com.netcracker.repositories;

import com.netcracker.model.Office;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRepository extends MongoRepository<Office, String> {
   Office findById(ObjectId id);
    //Office findByName(String name);

}
