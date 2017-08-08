import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.text.*;
import java.util.*;

public class MySqlDataStoreUtilities
{
   public static Connection conn = null;
  public static void getConnection()
  {
    try
   {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal?useSSL=false","root","root");
	   System.out.println("got connection");
   }
   catch(Exception e)
  {}
}
  public static void deletetable()
  {
	  try{
	 getConnection();
      String deleteTableQuery = "DROP TABLE IF EXISTS product1;";
      PreparedStatement pst =
      conn.prepareStatement(deleteTableQuery); 
	  pst.execute();
	  
	  }
	  catch(Exception e){System.out.println(e);}
	  
  }
  
    public static void createtable()
  {
	  try{
	 getConnection();
      String deleteTableQuery = "CREATE TABLE product1 (product_category varchar(10),product_id int(3),product_name varchar(20),retailer varchar(20),product_condition varchar (20),price double(5,2));";
      PreparedStatement pst =
      conn.prepareStatement(deleteTableQuery); 
	  pst.execute();
	  
	  }
	  catch(Exception e){System.out.println(e);}
	  
  }
  public static void insertProduct(HashMap<String,Laptop> insproduct)
  {
    try{
	   System.out.println("Attempt for connection");
      getConnection();
	  Iterator<Map.Entry<String,Laptop>> itr = insproduct.entrySet().iterator() ;
        while(itr.hasNext()){
            Map.Entry<String,Laptop> inspro = itr.next();
			Laptop lap = inspro.getValue();
	  
      String insertIntoProduct = "INSERT INTO product1(product_category,product_id,product_name,retailer,product_condition,price) "
         + "VALUES (?,?,?,?,?,?);";
      PreparedStatement pst =
      conn.prepareStatement(insertIntoProduct);
       pst.setString(1,lap.getProducttype());
       pst.setString(2,lap.getId());
	   pst.setString(3,lap.getName());
       pst.setString(4,lap.getRetailer());
	   pst.setString(5,lap.getCondition());
	   pst.setInt(6,lap.getPrice());
       pst.execute();
	  }
	   System.out.println("Data inserted");
}
catch(Exception e){System.out.println(e);}
}
  
  
  public static void insertUser(String username,String password,String confirmpassword,String usertype){
  try{
	   System.out.println("Attempt for connection");
      getConnection();
      String insertIntoCustomerRegisterQuery = "INSERT INTO USER(username,password,confirmpass,role) "
         + "VALUES (?,?,?,?);";
      PreparedStatement pst =
      conn.prepareStatement(insertIntoCustomerRegisterQuery);
       pst.setString(1,username);
       pst.setString(2,password);
	   pst.setString(3,confirmpassword);
       pst.setString(4,usertype);
       pst.execute();
	   System.out.println(username);
}
catch(Exception e){System.out.println(e);}
}
  
  public static HashMap<String,User> selectUser(){
	  HashMap<String,User> userdata = new HashMap<String,User> ();
  try{
	  
      getConnection();
      
	  String selectIntoCustomerRegisterQuery = "SELECT * FROM USER;";
        
      PreparedStatement pst =
      conn.prepareStatement(selectIntoCustomerRegisterQuery);
	  ResultSet rs = pst.executeQuery();
	  while(rs.next())
	  {
		 String username = rs.getString("username");
		 String password = rs.getString("password");
		 String confirmpassword = rs.getString("confirmpass");
		 String usertype = rs.getString("role");
		 User user = new User(username,password,confirmpassword,usertype);
		 userdata.put(username,user);
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return userdata;
}
  public static ArrayList selectProduct(String maker){
	  ArrayList<Product> prods = new ArrayList<Product> ();
  try{
	  
      getConnection();
      
	  String selectfromproduct = "SELECT * FROM product1 where product_category = ?;";
        
      PreparedStatement pst =
      conn.prepareStatement(selectfromproduct);
	  pst.setString(1,maker);
	  ResultSet rs = pst.executeQuery();
	  while(rs.next())
	  {
		 String producttype = rs.getString("product_category");
		 int productid = rs.getInt("product_id");
		 String productname = rs.getString("product_name");
		 String retailer= rs.getString("retailer");
		 String condition = rs.getString("product_condition");
		 Double price = rs.getDouble("price");
		 Product product = new Product(productname,productid,producttype,retailer,condition,price);
		 prods.add(product);
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return prods;
}


  public static HashMap<String,Product> AllProduct(){
	  HashMap <String,Product> allproduct = new HashMap<String,Product> ();
	 
  try{
	  
      getConnection();
      
	  String selectfromproduct = "SELECT * FROM product1 ;";
        
      PreparedStatement pst =
      conn.prepareStatement(selectfromproduct);
	  ResultSet rs = pst.executeQuery();
	  while(rs.next())
	  {
		 String producttype = rs.getString("product_category");
		 int productid = rs.getInt("product_id");
		 String productname = rs.getString("product_name");
		 String retailer= rs.getString("retailer");
		 String condition = rs.getString("product_condition");
		 Double price = rs.getDouble("price");
		 Product product = new Product(productname,productid,producttype,retailer,condition,price);
		 allproduct.put(productname,product);
		
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return allproduct;
}



  public static Product selectexactProduct(int productid){
	  Product product = new Product();
  try{
	  
      getConnection();
      
	  String selectfromproduct = "SELECT * FROM product1 where product_id = ?;";
        
      PreparedStatement pst =
      conn.prepareStatement(selectfromproduct);
	  pst.setInt(1,productid);
	 ResultSet rs = pst.executeQuery();
	  while(rs.next())
	  {
		 String producttype = rs.getString("product_category");
	//	 int productid = rs.getInt("product_id");
		 String productname = rs.getString("product_name");
		 String retailer= rs.getString("retailer");
		 String condition = rs.getString("product_condition");
		 Double price = rs.getDouble("price");
		 product = new Product(productname,productid,producttype,retailer,condition,price);
	
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return product;
}


//  (ordernumber,username,orderdate,deliverydate,productid,productname,price); 
  public static void insertOrder(int ordernumber,String username,String orderdate,String deliverydate,String productid,String productname,Double price){
  try{
	   System.out.println("Attempt for connection");
      getConnection();
      String insertIntoCustomerOrder = "INSERT INTO ORDERDETAIL(order_id,username,orderdate,deliverydate,productid,productname,price) "
         + "VALUES (?,?,?,?,?,?,?);";
      PreparedStatement pst =
      conn.prepareStatement(insertIntoCustomerOrder);
       pst.setInt(1,ordernumber);
       pst.setString(2,username);
	   pst.setString(3,orderdate);
       pst.setString(4,deliverydate);
	   pst.setString(5,productid);
	   pst.setString(6,productname);
	   pst.setDouble(7,price);
       pst.execute();
	   System.out.println(username);
}
catch(Exception e){System.out.println(e);}
}
  public static HashMap <Integer ,Order >  viewOrder(){
	  HashMap <Integer ,Order > ordercheck = new HashMap <Integer ,Order > ();
  try{
	  
      getConnection();
      
	  String selectIntoOrder = "SELECT * FROM orderdetail;";
        
      PreparedStatement pst =
      conn.prepareStatement(selectIntoOrder);
	  ResultSet rs = pst.executeQuery();
	  while(rs.next())
	  {
		 int ordernumber = rs.getInt("order_id");
		 String username = rs.getString("username");
		 String orderdate = rs.getString("orderdate");
		 String deliverydate = rs.getString("deliverydate");
		 String productid = rs.getString("productid");
		 String productname = rs.getString("productname");
		 Double price = rs.getDouble("price");
		 
         Order order = new Order(username,ordernumber,orderdate,deliverydate,productid,productname,price);
		 ordercheck.put(ordernumber,order);
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return ordercheck;
}
  public static  String cancelOrder(int ordernumber){
	    try{
	  
      getConnection();
      
	  String deletefromOrder = "DELETE FROM orderdetail WHERE order_id = ?;";
	  
        
      PreparedStatement pst =
      conn.prepareStatement(deletefromOrder);
	  pst.setInt(1,ordernumber);
	  pst.execute();
	  System.out.println("order deleted");
	  return "yes";

	  
}
catch(Exception e){System.out.println(e);}
 return "no";
}


  public static void insertProduct(String producttype,int productid,String retailer,String productname,String condition,Double price){
  try{
	   System.out.println("Attempt for connection");
      getConnection();
      String insertIntoProduct = "INSERT INTO product1(product_category,product_id,product_name,retailer,product_condition,price) "
         + "VALUES (?,?,?,?,?,?);";
      PreparedStatement pst =
      conn.prepareStatement(insertIntoProduct);
       pst.setString(1,producttype);
       pst.setInt(2,productid);
	   pst.setString(3,retailer);
       pst.setString(4,productname);
	   pst.setString(5,condition);
	   pst.setDouble(6,price);
       pst.execute();
	   
}
catch(Exception e){System.out.println(e);}
}

  public static String updateProduct(String producttype,int productid,String retailer,String productname,String condition,Double price){
  try{
	   System.out.println("Attempt for connection");
      getConnection();
      String upadteProduct = "update product1 set price = ? where product_id = ?";
         
      PreparedStatement pst =
      conn.prepareStatement(upadteProduct);
//       pst.setString(1,retailer);
//       pst.setString(2,condition);
	   pst.setDouble(1,price);
       pst.setInt(2,productid);
	   pst.execute();
	   return "yes";
	   
}
catch(Exception e){System.out.println(e);return "no";}
} 
  public static String deleteProduct(int productid){
  try{
	   System.out.println("Attempt for connection");
      getConnection();
      String deleteProduct = "delete from product1 where product_id = ?";
         
      PreparedStatement pst =
      conn.prepareStatement(deleteProduct);
       pst.setInt(1,productid);
	   pst.execute();
	   System.out.println("product deleted");
	   return "yes";
	   
}
catch(Exception e){System.out.println(e);return "no";}
}
}