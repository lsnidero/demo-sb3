package com.example.demo.service;

import com.example.demo.entity.BsonDocument;
import com.example.demo.repository.BsonObjectsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MongoService {

    private final BsonObjectsRepository repository;

    public MongoService(@Autowired BsonObjectsRepository repository) {
        this.repository = repository;
    }


    public long countAll(){
        List<BsonDocument> allDocuments = repository.findAll();
        allDocuments.forEach(bsonDocument -> log.info(bsonDocument.toString()));
        return allDocuments.size();
    }
}
