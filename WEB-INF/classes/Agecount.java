import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.Date;


public class Agecount extends HttpServlet {
	
  
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	  String username = request.getParameter("userid").trim();
	  String password = request.getParameter("password").trim();
	  String bdaymonth = request.getParameter("bdaymonth");
	  String msg =  new String();
	  PrintWriter out = response.getWriter();
	  
	  
	  int flag =MySqlUtilities.selectUser(username,password);
	  int age = 0;
	  if (flag == 1){
	        	  
	  		try{
				DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
				Date Dateofbirth = new Date();
		        Dateofbirth = df.parse(bdaymonth);
        
			    Date current = new Date( );
			    long timediff = current.getTime() - Dateofbirth.getTime();
			    long totalDays = timediff / (24 * 60 * 60 * 1000);
			    
		     	age = (int)(totalDays/365);
			   
				  }
	  catch (Exception e){System.out.println(e);}
	  }
	   
 
out.println("<!doctype html>");
	 out.println("<html>");
       out.println("<head>");
	   if (flag == 1){
	   out.println("age of the person is" + age );}
		else{   
		out.println("invalid credentials");}
	   out.println("</body>");
out.println("</html>");
	  }
}
			