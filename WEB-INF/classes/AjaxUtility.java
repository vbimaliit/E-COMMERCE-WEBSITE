import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AjaxUtility {
	
 
	
		public StringBuffer streamData(String hint)
		{
			StringBuffer buffer = new StringBuffer();
			HashMap<String, ArrayList<Product>> hml = new HashMap<String, ArrayList<Product>>();
			
			hml = autoCompletion();
			
			for(Map.Entry<String, ArrayList<Product>> map : hml.entrySet())
			{
				for(Product bean : map.getValue())
				{
					if(bean.getName().toLowerCase().startsWith(hint))
					{
						buffer.append("<product>");
						buffer.append("<id>"+bean.getId()+"</id>");
						buffer.append("<productName>"+bean.getName()+"</productName>");
						buffer.append("</product>");
					}
				}
			}
			
			
			
			return buffer;
		}
		
	
	
	
	public HashMap<String, ArrayList<Product>> autoCompletion()
	{
		HashMap<String, ArrayList<Product>> hacpltn = new HashMap<String, ArrayList<Product>>();
		ArrayList<Product> products = new ArrayList<Product>();
		MySqlDataStoreUtilities dataStoreUtilities =  new MySqlDataStoreUtilities();
		ResultSet resultSet = null;
		
		try {
			dataStoreUtilities.getConnection();
			
			String query = "SELECT PRODUCT_NAME, PRODUCT_ID FROM PRODUCT1";
			PreparedStatement preparedstatement = dataStoreUtilities.conn.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			
			while(resultSet.next())
			{
				Product product = new Product();
				product.id = resultSet.getInt("PRODUCT_ID");
				product.name = resultSet.getString("PRODUCT_NAME");
				System.out.println(product.id);
				
				products.add(product);
				
			}
			
		} catch (Exception e) {		
			e.printStackTrace();
		} 		
		hacpltn.put("PRODUCTS", products);				
		return hacpltn;
	}
		
	
	//CODE FOR AUTOCOMPLETION ENDS HERE 
	
}
