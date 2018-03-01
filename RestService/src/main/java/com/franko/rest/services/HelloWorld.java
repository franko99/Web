//package com.franko.rest.services;
//
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.MongoClient;
//
//public class HelloWorld {
//	@SuppressWarnings("deprecation")
//	public void test() {
//		System.out.println("Hello World");
//		MongoClient mongoClient = new MongoClient();
//		DB database = mongoClient.getDB("franko");
//		System.out.println(database);
//		DBCollection collection = database.getCollection("movie");
//		System.out.println(collection.find());
//		DBCursor cursor = collection.find();
//		while(cursor.hasNext()) {
//			DBObject obj = cursor.next();
//			System.out.println(obj.toString());
//		}
//		
//		//DBObject movie = new BasicDBObject("name", "Bad Boys 2");
//		//collection.insert(movie);
//		mongoClient.close();
//	}
//}