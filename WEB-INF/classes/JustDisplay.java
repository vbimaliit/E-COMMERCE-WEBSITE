

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class JustDisplay extends HttpServlet {
	
//	   ArrayList<Laptop> alist = new ArrayList<Laptop>();
  
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		 
		 HttpSession session = request.getSession();
		 String role = (String)session.getAttribute("role");
/*		 
//		if (role.equalsIgnoreCase("manager")){
//		 alist  =(ArrayList<Laptop>)session.getAttribute("laptop");
//		 }
        ArrayList<Laptop> alist = new ArrayList<Laptop>(); 
		 
		String Filename; 
		String orderpage = "/csj/OrderServlet";
		String maker = request.getParameter("maker"); 
		String viewreview = "/csj/ViewreviewServlet";
		String writereview = "/csj/ReviewServlet";
		if (maker.equalsIgnoreCase("mobile")){
					 Filename= "C:/tomcat-7.0.34/apache-tomcat-7.0.34/webapps/csj/WEB-INF/MobileCatalog.xml";
			
		}
		else if (maker.equalsIgnoreCase("laptops")){
		 Filename= "C:/tomcat-7.0.34/apache-tomcat-7.0.34/webapps/csj/WEB-INF/LaptopCatalog.xml";
	     }else if (maker.equalsIgnoreCase("tablets")){
		 Filename= "C:/tomcat-7.0.34/apache-tomcat-7.0.34/webapps/csj/WEB-INF/TabletsCatalog.xml";
	     }else {
			 
			 Filename= "C:/tomcat-7.0.34/apache-tomcat-7.0.34/webapps/csj/WEB-INF/TVSCatalog.xml";
		 }
		
		SaxParser4BestDealRetail bestdeal = new SaxParser4BestDealRetail(Filename);
		
		System.out.println(Filename);
		
		System.out.println(role);
		 
		
		PrintWriter out = response.getWriter();
		
        if (role.equalsIgnoreCase("admin")){
			alist  =(ArrayList<Laptop>)session.getAttribute("laptop");
		if (alist == null){
			alist = new ArrayList<Laptop>();
		for(Laptop laptop : bestdeal.laptops)
		{    
	       
			alist.add(laptop);
		}
		}
		}else{	
		alist = new ArrayList<Laptop>();
		for(Laptop laptop : bestdeal.laptops)
		{    
	       
			alist.add(laptop);
		}}
		
		session.setAttribute("laptop",alist);
//		System.out.println(alist.size());
		
//		 alist  =(ArrayList)session.getAttribute("laptop");
*/
//       String role = (String)session.getAttribute("role");
		 
       PrintWriter out = response.getWriter();
	   String Filename; 
		String orderpage = "/csj/OrderServlet";
		String maker = request.getParameter("maker"); 
		String viewreview = "/csj/ViewreviewServlet";
		String writereview = "/csj/ReviewServlet";
		
	   ArrayList<Product> alist = new ArrayList<Product>(); 
		 
	   alist = MySqlDataStoreUtilities.selectProduct(request.getParameter("maker"));

       response.setContentType("text/html");
       
	    
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
				if (role.equalsIgnoreCase("admin")){
					out.println("<li style = \"float:right\"> <a href=\"manager.html\">Addproduct</a></li>");
				}
		  out.println("</ul>");
	out.println("</div>");
    out.println("</nav>");

    out.println("<div id=\"body\" class=\"width\">");
        out.println("<section id=\"content\">");

	    out.println("<article>");
		out.println("<table>");
		for(int i=0; i<alist.size(); i++)
		{
			Product lap = (Product)alist.get(i);
			out.println("<tr>");
			out.println("<td>");
			out.println("ID "+lap.getId());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
		   // String img = lap.getImage();
			out.println("ProductCategory :  "+ lap.getProducttype());
		    out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("Name :  "+ lap.getName());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("Retailer: " + lap.getRetailer());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("Condition: " + lap.getCondition());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>");
			out.println("Price: " + lap.getPrice());
			out.println("</td>");
			out.println("</tr>");
			
//			<img src="bestdeal.jpg" alt="Mountain View"  height="100" width="100">
			
//new try start
           out.println("<tr>");
		   out.println("<td>");
           out.println("<FORM ACTION=\"" + orderpage + "\">\n" +
           "<INPUT TYPE=\"HIDDEN\" NAME=\"productid\" " +
           "       VALUE=\"" + lap.getId() + "\">\n" +
           "<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
           "       VALUE=\"" + lap.getName() + "\">\n" +
		   "<INPUT TYPE=\"HIDDEN\" NAME=\"price\" " +
           "       VALUE=\"" + lap.getPrice() + "\">\n" +
           "<INPUT TYPE=\"SUBMIT\" " +
           "VALUE=\"Add to Shopping Cart\"" + "style= \"background-color: white\">\n" +
           "</CENTER>\n<P>\n</FORM>");
		   out.println("</td>");
		   out.println("<td>");
		   out.println("<FORM ACTION=\"" + viewreview + "\">\n" +
           "<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
           "       VALUE=\"" + lap.getName() + "\">\n" +
           "<INPUT TYPE=\"SUBMIT\" " +
           "VALUE=\"View review\"" + "style= \"background-color: white\">\n" +
           "</CENTER>\n<P>\n</FORM>");
		   out.println("</td>");
		   		   out.println("<td>");
		   out.println("<FORM ACTION=\"" + writereview + "\">\n" +
           "<INPUT TYPE=\"HIDDEN\" NAME=\"productname\" " +
           "       VALUE=\"" +  lap.getName()+ "\">\n" +
		   "<INPUT TYPE=\"HIDDEN\" NAME=\"retailer\" " +
           "       VALUE=\"" +  lap.getRetailer()+ "\">\n" +
		   "<INPUT TYPE=\"HIDDEN\" NAME=\"price\" " +
           "       VALUE=\"" +  lap.getPrice()+ "\">\n" +
		   "<INPUT TYPE=\"HIDDEN\" NAME=\"producttype\" " +
           "       VALUE=\"" +  lap.getProducttype()+ "\">\n" +
           "<INPUT TYPE=\"SUBMIT\" " +
           "VALUE=\"Write review\"" + "style= \"background-color: white\">\n" +
           "</CENTER>\n<P>\n</FORM>");
		   out.println("</td>");
		   out.println("</tr>");
		   
		   
// new try end      			
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
				
				out.println("<li>");
				  out.println("<h4><a href=\"TrendingServlet\">Trending</h4>");
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
