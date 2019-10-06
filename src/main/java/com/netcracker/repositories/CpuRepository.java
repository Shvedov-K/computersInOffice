package com.netcracker.repositories;

import com.netcracker.model.components.Cpu;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CpuRepository extends MongoRepository<Cpu, String> {
    Cpu findById(ObjectId id);
}
