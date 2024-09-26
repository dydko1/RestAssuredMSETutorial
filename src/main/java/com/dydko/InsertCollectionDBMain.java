package com.dydko;

import com.mongodb.client.*;
import org.bson.Document;

public class InsertCollectionDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

        //database.createCollection("sampleCollection1");
        MongoCollection<Document> collection = database.getCollection("sampleCollection1");

        Document document = new Document("title", "MongoDB128")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.tutorialspoint.com/mongodb/")
                .append("by", "tutorials point");

        collection.insertOne(document);
    }
}