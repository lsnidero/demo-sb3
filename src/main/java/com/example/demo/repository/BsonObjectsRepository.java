package com.example.demo.repository;

import com.example.demo.entity.BsonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BsonObjectsRepository extends MongoRepository<BsonDocument,String > {

}
