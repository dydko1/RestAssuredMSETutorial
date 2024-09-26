package com.dydko;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Iterator;

public class GetAllCollection2DBMain {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://192.168.10.61:27017/");
        MongoDatabase database = mongoClient.getDatabase("testMiro");

       for (String s:database.listCollectionNames())
           System.out.println(s);
    }
}