package com.dydko;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Iterator;

public class GetAllCollectionDBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

        //database.createCollection("sampleCollection1");
        MongoCollection<Document> collection = database.getCollection("sampleCollection1");

        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}