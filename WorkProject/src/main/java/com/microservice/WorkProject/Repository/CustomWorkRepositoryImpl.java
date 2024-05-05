package com.microservice.WorkProject.Repository;

import com.microservice.WorkProject.Model.WorkModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomWorkRepositoryImpl implements CustomWorkRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<WorkModel> getByCity(String s) {

        List<WorkModel> searchResult = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("WorkMicroserviceDB");
        MongoCollection<Document> collection = database.getCollection("Work");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                        new Document("$search",
                        new Document("text",
                        new Document("query", s)
                        .append("path", Arrays.asList("cCity", "status", "problem"))))));

        result.forEach(doc -> searchResult.add(mongoConverter.read(WorkModel.class,doc)));

        return searchResult;
    }
}
