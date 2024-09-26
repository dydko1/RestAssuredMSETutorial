package com.dydko;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DeleteDocDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

        //database.createCollection("sampleCollection1");
        MongoCollection<Document> collection = database.getCollection("sampleCollection1");

        collection.deleteOne(Filters.eq("title", "MongoDB128"));
    }
}