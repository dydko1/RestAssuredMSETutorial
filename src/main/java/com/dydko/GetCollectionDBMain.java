package com.dydko;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Set;

public class GetCollectionDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

        MongoCollection<Document> collections = database.getCollection("post");
        MongoCursor<Document> cursor =  collections.find().cursor();
        cursor.forEachRemaining(System.out::println);
    }
}