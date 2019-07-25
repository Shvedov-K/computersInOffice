package com.netcracker.repositories;

import com.netcracker.model.Office;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.LinkedList;

public interface IRepository extends MongoRepository<Office, String> {
    void AddOffice(Office office);
    void RemoveOffice(Office office);
    void UpdateOffice(ObjectId id);

   Office findById(ObjectId id);

}
