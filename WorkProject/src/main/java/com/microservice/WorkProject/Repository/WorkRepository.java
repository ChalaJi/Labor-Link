package com.microservice.WorkProject.Repository;

import com.microservice.WorkProject.Model.WorkModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends MongoRepository<WorkModel, String> {
}
