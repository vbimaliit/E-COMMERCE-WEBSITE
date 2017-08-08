

import java.util.ArrayList;
import java.util.List;

public class Review {

    String productname;
    String producttype;
    String reviewdate;
    String reviewtext;
    String rating;
    String username;
	String retailer;
	
	String retailerzip;
	String retailercity;
	String retailerstate;
	String onsale;
	String manufacturename;
	String rebate;
	String userage;
	String gender;
	String occupation;
	
	
	
	
	

   public Review(String productname,String producttype,String reviewdate,String reviewtext,String rating, String username,String retailer,String retailerzip,String retailercity,String retailerstate,String onsale,String manufacturename,String rebate,String userage,String gender,String occupation){
   
   this.productname = productname;
   this.producttype = producttype;
   this.reviewdate = reviewdate;
   this.reviewtext = reviewtext;
   this.rating = rating;
   this.username = username;
   this.retailer  = retailer;
   this.retailerzip = retailerzip;
   this.retailercity = retailercity;
   this.retailerstate = retailerstate;
   this.onsale = onsale;
   this.manufacturename = manufacturename;
   this.rebate = rebate;
   this.userage = userage;
   this.gender = gender;
   this.occupation = occupation;
   
   }

	public String getRetailer() {
		return retailer;
	}


	public String getProductname() {
		return productname;
	}


	public String getReviewdate() {
		return reviewdate;
	}


	public String getReviewtext() {
		return reviewtext;
	}


	public String getRating() {
		return rating;
	}

	public String getProducttype() {
		return producttype;
	}

	
	public String getUsername() {
		return username;
	}

	
	public String getRetailerzip(){
		return retailerzip;
	}
	
	public String getRetailercity(){
		return retailercity;
	}
	
	public String getRetailerstate(){
		return retailerstate;
		}
		
	public String getOnsale(){
		return onsale;
		
	}
	
	public String getManufacturename(){
		return manufacturename;
		}
		
	public String getRebate(){
		return rebate;
	}
	public String getUserage(){
		return userage;
	}
	
	public String getGender(){
		return gender;		
	}
	
	public String getOccupation(){
		return occupation;
}
}