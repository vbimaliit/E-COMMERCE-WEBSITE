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

public class DealMatches extends HttpServlet {
       HashMap <String,Product> allproducts =  new HashMap<String,Product>();
	   HashMap <String,Product> selectedproduct =  new HashMap<String,Product>();
       public void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {
		  
		  String orderpage = "/csj/OrderServlet";
		String viewreview = "/csj/ViewreviewServlet";
		String writereview = "/csj/ReviewServlet";
	    int count =0;
	   BufferedReader br = null;
	   String msg = "";
       System.out.println("vishal");
					   
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
		allproducts = MySqlDataStoreUtilities.AllProduct();
		Iterator<Map.Entry<String, Product>> iterator = allproducts.entrySet().iterator() ;
        while(iterator.hasNext() && count < 2 ){
            Map.Entry<String, Product> allpro = iterator.next();
			Product prod1 = allpro.getValue();
			String prodname = prod1.getName().toLowerCase();
			System.out.println(prodname);
		   

		try {

			String line;

			br = new BufferedReader(new FileReader("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\csj\\DealMatches.txt"));

			while (((line = br.readLine()) != null) && count < 2 )  {
				    String line1 = line.toLowerCase();
				    if(line1.contains(prodname))
					{
					
                      count = count + 1;
					  selectedproduct.put(line,prod1);
					  break;

                    }

			}

            } catch (IOException e){}
		}

        System.out.println(selectedproduct.size());





        Iterator<Map.Entry<String, Product>> it =selectedproduct.entrySet().iterator() ;
        while(it.hasNext()){
            Map.Entry<String, Product> entry = it.next();
               out.println(entry.getKey());
			   out.println("<br>");

		}
		out.println("<table>");
       Iterator<Map.Entry<String, Product>> itr = selectedproduct.entrySet().iterator() ;
        while(itr.hasNext()){
            Map.Entry<String, Product> selectpro = itr.next();
			Product prod = selectpro.getValue();
						
                        out.println("<tr>");
			            out.println("<td>");
			            out.println("ID "+prod.getId());
			            out.println("</td>");
			            out.println("</tr>");
			            out.println("<tr>");
			            out.println("<td>");
		  
			            out.println("ProductCategory :  "+ prod.getProducttype());
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>");
						out.println("Name :  "+ prod.getName());
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>");
						out.println("Retailer: " + prod.getRetailer());
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>");
						out.println("Condition: " + prod.getCondition());
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>");
						out.println("Price: " + prod.getPrice());
						out.println("</td>");
						out.println("</tr>");
			

						out.println("<tr>");
						out.println("<td>");
						out.println("<FORM ACTION=\"" + orderpage + "\">\n" +
						"<INPUT TYPE=\"HIDDEN\" NAME=\"productid\" " +
						"       VALUE=\"" + prod.getId() + "\">\n" +
						"<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
						"       VALUE=\"" + prod.getName() + "\">\n" +
						"<INPUT TYPE=\"HIDDEN\" NAME=\"price\" " +
						"       VALUE=\"" + prod.getPrice() + "\">\n" +
						"<INPUT TYPE=\"SUBMIT\" " +
						"VALUE=\"Add to Shopping Cart\"" + "style= \"background-color: white\">\n" +
						"</CENTER>\n<P>\n</FORM>");
						   out.println("</td>");
						   out.println("<td>");
						   out.println("<FORM ACTION=\"" + viewreview + "\">\n" +
						   "<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
						   "       VALUE=\"" + prod.getName() + "\">\n" +
						   "<INPUT TYPE=\"SUBMIT\" " +
						   "VALUE=\"View review\"" + "style= \"background-color: white\">\n" +
						   "</CENTER>\n<P>\n</FORM>");
						   out.println("</td>");
								   out.println("<td>");
						   out.println("<FORM ACTION=\"" + writereview + "\">\n" +
						   "<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
						   "       VALUE=\"" +  prod.getName()+ "\">\n" +
						   "<INPUT TYPE=\"HIDDEN\" NAME=\"retailer\" " +
						   "       VALUE=\"" +  prod.getRetailer()+ "\">\n" +
						   "<INPUT TYPE=\"HIDDEN\" NAME=\"price\" " +
						   "       VALUE=\"" +  prod.getPrice()+ "\">\n" +
						   "<INPUT TYPE=\"HIDDEN\" NAME=\"producttype\" " +
						   "       VALUE=\"" +  prod.getProducttype()+ "\">\n" +
						   "<INPUT TYPE=\"SUBMIT\" " +
						   "VALUE=\"Write review\"" + "style= \"background-color: white\">\n" +
						   "</CENTER>\n<P>\n</FORM>");
						   out.println("</td>");
						   out.println("</tr>"); 						
						  
						}
				  
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