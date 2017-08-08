import java.io.*;
public class Order implements Serializable
{

String userid ;
int ordernumber;
String deliverydate;
String orderdate;
String productid;
String productname;
Double price;

public  Order(String userid,int ordernumber,String orderdate,String deliverydate,String productid,String productname,Double price)
{
	
	this.userid = userid;
	this.ordernumber = ordernumber;
	this.deliverydate = deliverydate;
	this.orderdate = orderdate;
	this.productid = productid;
	this.productname = productname;
	this.price = price;

}

public String getUserid(){
 return userid;
}

public int getOrdernumber () {
 return ordernumber;
}

public String getDeliverydate(){
return deliverydate;
}
public String getOrderdate(){
 return orderdate;
}

public String getProductid () {
 return productid;
}

public String getProductname(){
return productname;
}

public Double getPrice(){
	return price;
}


}