package com.dydko;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class CollectionDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");
        database.createCollection("sampleCollection123");
        // System.out.println(database.getCollection("post").);
    }
}
