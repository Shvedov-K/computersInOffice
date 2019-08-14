package com.netcracker.repositories;

import com.netcracker.model.Computer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComputerRepository extends MongoRepository<Computer, String> {
    Computer findById(ObjectId id);
}
