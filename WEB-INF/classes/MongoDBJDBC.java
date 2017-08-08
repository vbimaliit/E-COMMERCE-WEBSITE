import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.text.*;
import java.util.*;
public class MongoDBJDBC {

   public static void main( String args[] ) {
	
      try{   
		
        
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         
         DB db = mongoClient.getDB( "bestdeal" );
         System.out.println("Connect to database successfully");
			
              
         DBCollection coll = db.getCollection("customerreviews");
         System.out.println("Collection mycol selected successfully");
			
         BasicDBObject doc = new BasicDBObject("title", "MongoDB").
            append("description", "database").
            append("likes", 100).
            append("url", "http://www.tutorialspoint.com/mongodb/").
            append("by", "tutorials point");
				
         coll.insert(doc);
         System.out.println("Document inserted successfully");
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}