
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoCompletion extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try{	
		String action = request.getParameter("action");
		String hint   = request.getParameter("searchId");
		StringBuffer stringBuffer = new StringBuffer();
		boolean namesAdded = false;
		
		if(action.equals("complete"))
		{
			AjaxUtility ajaxUtility = new AjaxUtility();
			stringBuffer = ajaxUtility.streamData(hint);
			
			if(stringBuffer != null || !stringBuffer.equals(""))
			{
				namesAdded = true;
			}
			if(namesAdded)
			{
				response.setContentType("text/xml");
				response.getWriter().write("<products>"+stringBuffer.toString()+"</products>");
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
