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

public class ReviewServlet extends HttpServlet {

   
   String productid ;
   String comments;
   
   	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
	 String productname = request.getParameter("productname");
	 String retailer =     request.getParameter("retailer");
	 System.out.println(retailer);
	 String price   = request.getParameter("price");
	 String producttype = request.getParameter("producttype");
	    
	 response.setContentType("text/html");
     PrintWriter out = response.getWriter();
	 
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
				
				out.println("<li style = \"float:right\"> <a href=\"veiworder.html\">Vieworder</a></li>");
				
				
		  out.println("</ul>");
	out.println("</div>");
    out.println("</nav>");

    out.println("<div id=\"body\" class=\"width\">");
        out.println("<section id=\"content\">");

	    out.println("<article>");
		out.println("<h4> Please write review for the product </h4>");
		out.println("<table border = \"1\" cellpadding=\'2\' cellspacing=\'1\'>");
		out.println("<tr>");
		out.println("<td border: 1px >");
		out.println("Productname");
		out.println("</td>");
		out.println("<td border: 1px >");
		out.println(productname);
		out.println("</td>");
		out.println("<tr>");
		out.println("<td border: 1px >");
		out.println("Prodcuttype");
		out.println("</td>");
		out.println("<td border: 1px solid #dddddd>");
		out.println(producttype);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td border: 1px solid #dddddd>");
		out.println("Price");
		out.println("</td>");
		out.println("<td border: 1px solid #dddddd>");
		out.println(price);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td border: 1px solid #dddddd>");
		out.println("Retailer");
		out.println("</td>");
		out.println("<td border: 1px solid #dddddd>");
		out.println(retailer);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<form method=\"get\" action=\"/csj/WritereviewServlet\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Retailerzip");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"10\" name=\"retailerzip\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("RetailerCity");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"15\" name=\"retailercity\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("RetailerState");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"10\" name=\"retailerstate\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Productonsale");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"radio\" name=\"productonsale\" value = \"yes\" style= \"background-color: white\"></input> Yes");
		out.println("<input type=\"radio\" name=\"productonsale\" value = \"no\" style= \"background-color: white\"></input> No");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Manufacturer");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"10\" name=\"manufacturer\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Manufacturerrebate");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"radio\" name=\"manufacturerrebate\" value = \"yes\" style= \"background-color: white\"></input> Yes");
		out.println("<input type=\"radio\" name=\"manufacturerrebate\" value = \"no\" style= \"background-color: white\"></input> No");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Userage");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"2\" name=\"userage\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Usergender");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"radio\" name=\"usergender\" value = \"m\" style= \"background-color: white\"></input> Male");
		out.println("<input type=\"radio\" name=\"usergender\" value = \"f\" style= \"background-color: white\"></input> Female");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Useroccupation");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"10\" name=\"useroccupation\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Rating");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"1\" name=\"rating\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Reviews");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" size=\"50\" name=\"reviews\" style= \"background-color: white\"></input>");
		out.println("</td");
		out.println("</tr>");
		out.println("</table>");
		out.println("<input type=\"hidden\" name=\"productname\" value=\""+ productname + "\">");
//		System.out.println(productname);
//        out.println("<input type=\"hidden\" name=\"ordernumber\" value=\""+ ordernumber + "\">");
		out.println("<input type=\"hidden\" name=\"produdcttype\" value=\""+ producttype + "\">");
		
		out.println("<input type=\"hidden\" name=\"price\" value=\""+ price + "\">");
		out.println("<input type=\"hidden\" name=\"retailer\" value=\""+ retailer + "\">");
		out.println("<center><input type=\"submit\" value=\"Submit\" style= \"background-color: white\" /></center>");
        out.println("</form>");
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