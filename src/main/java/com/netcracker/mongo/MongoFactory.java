package com.netcracker.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@SuppressWarnings("deprecation")
public class MongoFactory {
    private static MongoClient mongoClient;

    public static MongoClient getMongo() {
        if (mongoClient == null) {
            try {
                MongoClientURI uri = new MongoClientURI("mongodb+srv://xtended16:<password>@cluster0-awovx.mongodb.net/test?retryWrites=true&w=majority");
                MongoClient mongoClient = new MongoClient(uri);
                //System.out.println("Connect to database successfully");
                return mongoClient;
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return mongoClient;
    }

    public static DB getDB(String db_name) {
        return getMongo().getDB(db_name);
    }

    public static DBCollection getCollection(String db_name, String db_collection) {
        return getDB(db_name).getCollection(db_collection);
    }
}
