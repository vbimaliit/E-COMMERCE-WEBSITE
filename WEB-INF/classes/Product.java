
import java.util.ArrayList;
import java.util.List;

public class Product {

    String retailer;
    String name;
    int id;
    String condition;
    Double price;
	String producttype;
    
	
	public Product()
	{}

    public Product(String name,int id,String producttype,String retailer,String condition,Double price){
        this.name = name;
		this.id = id;
		this.producttype = producttype;
		this.retailer = retailer;
		this.condition = condition;
		this.price = price;
    }

	public String getRetailer() {
		return retailer;
	}



	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}




	public String getCondition() {
		return condition;
	}


	public String getProducttype() {
		return producttype;
	}

	
	public Double getPrice() {
		return price;
	}

   
	
}