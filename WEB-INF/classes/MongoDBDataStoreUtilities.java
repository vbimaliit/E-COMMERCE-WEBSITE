
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import org.json.simple.JSONArray;  
import com.mongodb.util.JSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.text.*;
import java.util.*;
import java.lang.Object;



public class MongoDBDataStoreUtilities
{

 public static void insertReviews(String productname,String productcategory,String price,String retailername,String retailerzip,String retailercity,String retailerstate,String onsale,String manufacturename,String rebate,String userid,String userage,String gender,String occupation,String rating,String reviewdate,String reviewtext)
{    
    try{
		System.out.println("vishal");
	MongoClient mongo  = new MongoClient("localhost", 27017);
     DB db = mongo.getDB("bestdeal");
    DBCollection myReviews= db.getCollection("customerreviews");
	 BasicDBObject doc = new BasicDBObject("title", "customerreviews").
            append("Productname", productname).
            append("Productcategory", productcategory).
           append("Price", price).
            append("Retailername", retailername).
			append("Retailerzip", retailerzip).
            append("Retailercity", retailercity).
           append("Retailerstate", retailerstate).
            append("Onssale", onsale).
			append("Manufacturename", manufacturename).
            append("Rebate", rebate).
           append("Username", userid).
            append("Userage", userage).
			append("Gender", gender).
            append("Occupation", occupation).
           append("Rating", rating).
            append("Reviewdate", reviewdate).
			append("ReviewText", reviewtext);
           myReviews.insert(doc);
		   System.out.println("cool");
	}catch(Exception e){ System.out.println(e.getMessage());}
   //      System.out.println("Document inserted successfully");
 }
 public static ArrayList<Review> selectReviews(String prodcutname){
	    ArrayList<Review> Reviews = new ArrayList<Review>();
	 try{
		System.out.println("vishal");
	    MongoClient mongo  = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("bestdeal");
        DBCollection myReviews= db.getCollection("customerreviews");
		 BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("Productname", prodcutname);
		System.out.println(prodcutname);
        DBCursor cursor = myReviews.find(whereQuery);
        while(cursor.hasNext()) {
			System.out.println("query running");
          DBObject obj = cursor.next();
		  JSON json = new JSON();
		  JSONObject output;
		  JSONParser parser = new JSONParser();
		  
		  Object object = parser.parse(json.serialize(obj));
		  output = (JSONObject) object;
		  		   
		  String prodcutnm = output.get("Productname").toString();
		  String producttype = output.get("Productcategory").toString();
		  String retailer = output.get("Retailername").toString();
		 
		  String username = output.get("Username").toString();
		  String reviewdate = output.get("Reviewdate").toString();
		  String reviewtext = output.get("ReviewText").toString();
		  String rating = output.get("Rating").toString();
		  String retailerzip = output.get("Retailerzip").toString();
		  String retailercity = output.get("Retailercity").toString();
		  String retailerstate = output.get("Retailerstate").toString();
		 
		  String onsale = output.get("Onssale").toString();
		  String manufacturename = output.get("Manufacturename").toString();
		  String rebate = output.get("Rebate").toString();
		  String userage = output.get("Userage").toString();
		  
		  String gender = output.get("Gender").toString();
		  String occupation = output.get("Occupation").toString();
		 
		 
		   
		  Review review = new Review (prodcutnm,producttype,reviewdate,reviewtext,rating,username,retailer,retailerzip,retailercity,retailerstate,onsale,manufacturename,rebate,userage,gender,occupation);
          System.out.println(review);
          System.out.println(prodcutnm); 		  
		  Reviews.add(review);
		  
		} 
 }catch(Exception e){ System.out.println(e.getMessage());}
 return Reviews;} 

  public static  ArrayList <Bestrating> topProducts(){
	  ArrayList <Bestrating> Bestrate = new ArrayList <Bestrating> ();
	  try{
		  System.out.println("top5");
	  MongoClient mongo  = new MongoClient("localhost", 27017);
      DB db = mongo.getDB("bestdeal");
      DBCollection myReviews= db.getCollection("customerreviews");
	  int retlimit =5;
	  DBObject sort = new BasicDBObject();
	  sort.put("Rating",-1);
	  DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
	  while(cursor.hasNext()) {
		  DBObject objt = cursor.next();
		  JSON json = new JSON();
		  JSONObject output;
		  JSONParser parser = new JSONParser();
		  
		  Object object = parser.parse(json.serialize(objt));
		  output = (JSONObject) object;
		  		   
		  String prodcutnm = output.get("Productname").toString();
		  String rating = output.get("Rating").toString();
	      Bestrating best = new Bestrating(prodcutnm,rating);
		  Bestrate.add(best);
	  }
	
	}catch (Exception e){ System.out.println(e.getMessage());}
   return Bestrate;
  }
  public static ArrayList <Mostsold> mostsoldProducts(){
	  ArrayList <Mostsold> mostsold = new ArrayList <Mostsold> ();
	  try{
		  System.out.println("top5");
	  MongoClient mongo  = new MongoClient("localhost", 27017);
      DB db = mongo.getDB("bestdeal");
      DBCollection myReviews= db.getCollection("customerreviews");
      DBObject groupProducts = new BasicDBObject("_id","$Productname"); 
	  groupProducts.put("count",new BasicDBObject("$sum",1));
	  DBObject group = new BasicDBObject("$group",groupProducts);
	  DBObject limit=new BasicDBObject();
      limit=new BasicDBObject("$limit",5);
	  
	  DBObject sortFields = new BasicDBObject("count",-1);
	  DBObject sort = new BasicDBObject("$sort",sortFields);
	  AggregationOutput output = myReviews.aggregate(group,sort,limit);
      for (DBObject res : output.results()) {
        System.out.println(res);
		String prodcutname =(res.get("_id")).toString();
        String count = (res.get("count")).toString();	
        Mostsold mostsld = new Mostsold(prodcutname,count);
		mostsold.add(mostsld);
	
	  }
	  
	 
	  
	}catch (Exception e){ System.out.println(e.getMessage());}
      return mostsold;
  }	  
	  
	  public static ArrayList <Mostsoldzip> mostsoldZip(){
	  ArrayList <Mostsoldzip> mostsoldzip = new ArrayList <Mostsoldzip> ();
	  try{
		  System.out.println("top5");
	  MongoClient mongo  = new MongoClient("localhost", 27017);
      DB db = mongo.getDB("bestdeal");
      DBCollection myReviews= db.getCollection("customerreviews");
      DBObject groupProducts = new BasicDBObject("_id","$Retailerzip"); 
	  groupProducts.put("count",new BasicDBObject("$sum",1));
	  DBObject group = new BasicDBObject("$group",groupProducts);
	  DBObject limit=new BasicDBObject();
      limit=new BasicDBObject("$limit",5);
	  
	  DBObject sortFields = new BasicDBObject("count",-1);
	  DBObject sort = new BasicDBObject("$sort",sortFields);
	  AggregationOutput output = myReviews.aggregate(group,sort,limit);
      for (DBObject res : output.results()) {
        System.out.println(res);
		String zipcode =(res.get("_id")).toString();
        String count = (res.get("count")).toString();	
        Mostsoldzip mostsldzip = new Mostsoldzip(zipcode,count);
		mostsoldzip.add(mostsldzip);
	
	  }
	  
	 
	  
	}catch (Exception e){ System.out.println(e.getMessage());}
      return mostsoldzip;
  }

  
  /*	  public static ArrayList <Review> advanceSearch(String prodcutname,String price,String pricecomp,String ratings,String comprating,String city,String comparegender,String age,String compage,String occupation,String [] filters){
	  ArrayList <Review> Reviews = new ArrayList <Review> ();
	  try{

	  MongoClient mongo  = new MongoClient("localhost", 27017);
      DB db = mongo.getDB("bestdeal");
      DBCollection myReviews= db.getCollection("customerreviews");
	  DBObject match = new BasicDBObject(); 
	  DBObject priccomp = new BasicDBObject();
	  BasicDBObject andQuery = new BasicDBObject();
      List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	  for (int i=0;i< filters.length;i++)
	  {if (filters[i].equals("value1")) 
		  {		
	        if (prodcutname.equals("allproducts")){
				obj.add(new BasicDBObject("title", "customerreviews"));
			}
			else
			{  obj.add(new BasicDBObject("Productname", prodcutname));                                                                                   
	          }
		  }
	   if (filters[i].equals("value2")){
		   		     
		   if (pricecomp.equals("equal")) {
			      System.out.println("equal");
                 obj.add(new BasicDBObject("Price",new BasicDBObject("$eq",price)));           
            }else if (pricecomp.equals("greater")){
				           obj.add(new BasicDBObject("Price",new BasicDBObject("$gt",price)));
						   
            }else{
				 obj.add(new BasicDBObject("Price",new BasicDBObject("$lt",price)));
				  
			}
	   }
	   	   if (filters[i].equals("value3")){
		   		     
		   if (comprating.equals("equal")) {
			   
                 obj.add(new BasicDBObject("Rating",new BasicDBObject("$eq",ratings)));           
            }else if (comprating.equals("greater")){
				           obj.add(new BasicDBObject("Rating",new BasicDBObject("$gt",ratings)));
						   
            }else{
				 obj.add(new BasicDBObject("Rating",new BasicDBObject("$lt",ratings)));
				  
			}
	   }
	   if (filters[i].equals("value4")) 
		  {		
	        obj.add(new BasicDBObject("Retailerzip", city));                                                                                   
	          }
	   
	   if (filters[i].equals("value5")){
		   	 obj.add(new BasicDBObject("Gender",comparegender));           
            }
	   if (filters[i].equals("value6")){
		   		     
		   if (compage.equals("equal")) {
			   
                 obj.add(new BasicDBObject("Userage",new BasicDBObject("$eq",age)));           
            }else if (compage.equals("greater")){
				           obj.add(new BasicDBObject("Userage",new BasicDBObject("$gt",age)));
						   
            }else{
				 obj.add(new BasicDBObject("Userage",new BasicDBObject("$lt",age)));
				  
			}
	   }
	   	   if (filters[i].equals("value7")){
		   	 obj.add(new BasicDBObject("Occupation",occupation));           
            }
	   		   
	   }
        System.out.println("query running");
        andQuery.put("$and", obj);
		System.out.println(andQuery.toString());
		DBCursor cursor = myReviews.find(andQuery);
        while(cursor.hasNext()) {
		 DBObject objt = cursor.next();
          JSON json = new JSON();
		  JSONObject output;
		  JSONParser parser = new JSONParser();
		  
		  Object object = parser.parse(json.serialize(objt));
		  output = (JSONObject) object;
		  		   
		  String prodcutnm = output.get("Productname").toString();
		  String producttype = output.get("Productcategory").toString();
		  String retailer = output.get("Retailername").toString();
		  String username = output.get("Username").toString();
		  String reviewdate = output.get("Reviewdate").toString();
		  String reviewtext = output.get("ReviewText").toString();
		  String rating = output.get("Rating").toString();
		   
		  Review review = new Review (prodcutnm,producttype,reviewdate,reviewtext,rating,username,retailer);
          	  
		  Reviews.add(review);
	
	  }
	  
	 
	  
	}catch (Exception e){ System.out.println(e.getMessage());}
    
  return Reviews;}
  */
  
 }


