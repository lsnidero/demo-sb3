package com.example.demo.entity;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("BsonDocumentItem")
@Data
public class BsonDocument {

    @Id
    private String id;

    private String title;
    private String description;
    private int quantity;
}
