package com.dydko;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class DeletDocDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

        //database.createCollection("sampleCollection1");
        MongoCollection<Document> collection = database.getCollection("sampleCollection1");

        collection.deleteOne(Filters.eq("title", "MongoDB128"));
    }
}