
public class Cart 
{
String productid;
String productname ;
int quantity;
double price;


public  Cart(String productid,String productname,int quantity,double price)
{
	
	this.productid = productid;
	this.productname = productname;
	this.quantity = quantity;
	this.price = price;
	
	
}
//void setUserid(String userid){
//this.userid = userid;
//}

//void setPassword (String password) {
//this.password = password;
//}

//void setUsertype (String usertype){
//this.usertype = usertype;
//}


public String getProductid(){
 return productid;
}

public String getProductname () {
 return productname;
}

public int getQuantity(){
return quantity;
}

public double getPrice(){
return price;
}


}