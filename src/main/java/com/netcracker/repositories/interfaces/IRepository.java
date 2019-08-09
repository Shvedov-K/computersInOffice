package com.netcracker.repositories.interfaces;

import com.netcracker.model.Office;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository extends MongoRepository<Office, String> {
   Office findById(ObjectId id);
}
