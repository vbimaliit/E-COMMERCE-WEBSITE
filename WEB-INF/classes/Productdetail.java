

import java.util.ArrayList;
import java.util.List;

public class Productdetail {

    String retailer;
    String name;
    Double price;
	String producttype;
    
	public Productdetail(String name,String producttype,String retailer,Double price)
	{
	  this.name = name;
	  this.producttype = producttype;
	  this.retailer = retailer;
	  this.price = price;
			
	}



	public String getRetailer() {
		return retailer;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}

	public String getProductype() {
		return producttype;
	}


    
	
}