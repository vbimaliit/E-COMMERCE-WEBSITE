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

public class MainServlet extends HttpServlet {

 
		
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    
	HttpSession session = request.getSession();
		 
      session.setAttribute("role","nouser");
	  MySqlDataStoreUtilities.deletetable();
	  MySqlDataStoreUtilities.createtable();
	 String  Filename= "C:/tomcat-7.0.34/apache-tomcat-7.0.34/webapps/csj/WEB-INF/LaptopCatalog.xml";
	  SaxParser4BestDealRetail bestdeal = new SaxParser4BestDealRetail(Filename);
		
		System.out.println(Filename);
		System.out.println(bestdeal.prods.size());
/*
	//	System.out.println(role);
		 
    //    ArrayList<Laptop> alist = new ArrayList<Laptop>(); 
		HashMap<String,Laptop> insproduct = new HashMap<String,Laptop> ();
    //    alist = new ArrayList<Laptop>();
		for(Laptop laptop : bestdeal.laptops)
		{    
            String name = laptop.getName();   	       
			insproduct.put(name,laptop);
		}
	  System.out.println(insproduct.size());
*/	  
	  MySqlDataStoreUtilities.insertProduct(bestdeal.prods);
	 response.setContentType("text/html");
    PrintWriter out = response.getWriter();
	response.sendRedirect("DealMatches");
	
	}
	}