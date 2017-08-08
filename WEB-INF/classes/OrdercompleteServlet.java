import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

public class OrdercompleteServlet extends HttpServlet {

	HashMap <String ,Cart > shoppingcart = new HashMap<String , Cart> ();
	HashMap <Integer ,Order > orderhash = new HashMap<Integer , Order> ();
	String productid;
	String productname;
	int quantity;
	double price;
	
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	Random t = new Random();
	int ordernumber = t.nextInt(100);
	
	String username = (String)session.getAttribute("username");
//	Date current = new Date( );

//    String orderdate = (current.toString());
	
	Date current = new Date( );
    SimpleDateFormat formatdate = 
    new SimpleDateFormat ("MM/dd/yyyy");
	String orderdate = formatdate.format(current);
 
    Calendar d = Calendar.getInstance();
    d.setTime(new Date()); 
    d.add(Calendar.DATE, 14); 
    String deliverydate = formatdate.format(d.getTime());
    
	shoppingcart = (HashMap)session.getAttribute("shoppingCart");
	
	 Set set = shoppingcart.entrySet();
     Iterator iterator = set.iterator();
     while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
         Cart cart1 = (Cart)mentry.getValue();
         productid = cart1.getProductid();
         productname = cart1.getProductname();
		 quantity = cart1.getQuantity();
        price = cart1.getPrice();
	 }
	 
	 Order order = new Order(username,ordernumber,orderdate,deliverydate,productid,productname,price);
	 
	 orderhash.put(ordernumber,order);
	 MySqlDataStoreUtilities.insertOrder(ordernumber,username,orderdate,deliverydate,productid,productname,price);
     
	 
	
	
	
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
				
				out.println("<li style = \"float:right\"> <a href=\"vieworder.html\">Veiworder</a></li>");
		  out.println("</ul>");
	out.println("</div>");
    out.println("</nav>");

    out.println("<div id=\"body\" class=\"width\">");
        out.println("<section id=\"content\">");

	    out.println("<article>");
	    out.println("<center><h1>Order is successfully palced. Ordernumber :" + ordernumber + "Delierydate:" + deliverydate + "</h1></center>");
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