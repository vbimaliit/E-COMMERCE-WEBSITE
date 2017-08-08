import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

public class AllorderServlet extends HttpServlet {

    String ordernum;
	String productid;
	String productname;
	int quantity;
	double price;
	String deliverydate;
	String orderdate;
	String username;
	Integer ordernumber;
	String msg;
	String userid;


  HashMap <Integer ,Order > retorder = new HashMap<Integer , Order> ();
  
  	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
        retorder = MySqlDataStoreUtilities.viewOrder();	  
	   
	   response.setContentType("text/html");
       PrintWriter out = response.getWriter();
	   
	   out.println("<!doctype html>");
	   out.println("<html>");
       out.println("<head>");
       out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
       out.println("<title>Bestdeal.com</title>");
       out.println("<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />");

       out.println("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1.0, maximum-scale=1.0\" />");
       out.println("</head>");
       out.println("<body>");
       out.println("<div id=\"container\">");
       out.println("<header>");
	   out.println("<div class=\"width\">");
    		out.println("<table border = \"0\">");
			out.println("<col width=\"200\">");
            out.println("<col width=\"500\">");
            out.println("<col width=\"300\">");			
			out.println("<tr>");
			out.println("<td> <img src=\"bestdeal.jpg\" alt=\"Mountain View\"  height=\"100\" width=\"100\"> </td>\n");
			out.println("<td><h1>Bestdeal</h1></td>");
			out.println("<td><form action=\"demo_form.asp\">Search: <input type=\"text\" name=\"searchfield\" size=\"25\" style= \"background-color: white\" ; ></td>");
                      
			out.println("</form>");  
			out.println("</tr>");
			out.println("</table>");
			
			
       	out.println("</div>");
    out.println("</header>");
    out.println("<nav>");
	out.println("<div class=\"width\">");
  		  out.println("<ul>");
         	  out.println("<li class=\"start\"><a href=\"index.html\">Home</a></li>");
				out.println("<li> </li>");
               
          	  	out.println("<li><a href=\"login.html\" >Mobiles</a></li>");
				
				out.println("<li><a href=\"signup.html\">Tablets</a></li>");
          	 	
				out.println("<li> <a href=\"login.html\">Laptop</a></li>");
				
				out.println("<li> <a href=\"login.html\">TVs</a></li>");

				 out.println("<li style = \"float:right\"> <a href=\"login.html\">cart</a></li>");
				 
				 out.println("<li style = \"float:right\"> <a href=\"loginup.html\">Login</a></li>");
		  
		        out.println("<li style = \"float:right\"> <a href=\"sign.html\">Signup</a></li>");
				
				out.println("<li style = \"float:right\"> <a href=\"vieworder.html\"></a></li>");
		  out.println("</ul>");
	out.println("</div>");
    out.println("</nav>");

    out.println("<div id=\"body\" class=\"width\">");
        out.println("<section id=\"content\">");

	    out.println("<article>");
		out.println("<table>");
	    
     Set set = retorder.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         
         Order order = (Order)mentry.getValue();
		  ordernumber  =  order.getOrdernumber();
		  deliverydate =  order.getDeliverydate();
		  orderdate	=	 order.getOrderdate();
		  productid  =	 order.getProductid ();
		  productname =  order.getProductname();
		  price =		  order.getPrice();
			  out.println("<tr>");
              out.println("<td>");
              out.println(ordernumber);
              out.println("</td>");
              out.println("<td>");
              out.println(productid);
              out.println("</td>");
              out.println("<td>");
              out.println(productname);
              out.println("</td>");
              out.println("<td>");
              out.println(orderdate);
              out.println("</td>");
              out.println("<td>");
              out.println(deliverydate);
              out.println("</td>");
              out.println("<td>");
              out.println(price);
              out.println("</td>");			  
			  out.println("<td>");
			  out.println("<form action=\"/csj/CancelorderServlet\">");
			  out.println("<input type=\"hidden\" name=\"ordernumber\" value=\""+ ordernumber + "\">");
			  out.println("<center><input type=\"submit\" value=\"Cancel\" style= \"background-color: white\" /></center>");
			  out.println("</form>");
			  out.println("</td>");
			  out.println("</tr>");
              			  
      }
	         out.println("<tr>") ;
			 out.println("<td>");
			 out.println("<form action=\"/csj/CheckoutServlet\">");
			 out.println("<center><input type=\"submit\" value=\"Checkout\" style= \"background-color: white\" /></center>");
			 out.println("</form>");
			 out.println("</td>"); 
         	  out.println("</tr>");
			 out.println("</table>"); 
      	out.println("</article>");
        out.println("</section>");
    	out.println("<aside class=\"sidebar\">");
		

           out.println("<ul>");	
               out.println("<li>");
               out.println("<h4><a href=\"JustDisplay?maker=mobile\">Mobile</a></h4>");
               out.println("</li>");
                
                out.println("<li>");
                    out.println("<h4><a href=\"JustDisplay?maker=laptops\">Laptops</h4>");
                out.println("</li>");
                
                out.println("<li>");
                    out.println("<h4><a href=\"JustDisplay?maker=tablets\">Tablets</h4>");

                out.println("</li>");
                out.println("<li>");
                    out.println("<h4><a href=\"JustDisplay?maker=tv\">TVs</h4>");

                out.println("</li>");
                
                                
            out.println("</ul>");
		
        out.println("</aside>");
    	out.println("<div class=\"clear\"></div>");
    out.println("</div>");
    out.println("<footer>");

        out.println("<div class=\"footer-bottom\">");
            out.println("<p>&copy; YourSite 2013. <a href=\"http://zypopwebtemplates.com/\">Free CSS Web Templates</a> by ZyPOP</p>");
         out.println("</div>");
    out.println("</footer>");
out.println("</div>");
out.println("</body>");
out.println("</html>");
}
}