import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class MySqlUtilities
{
   public static Connection conn = null;
  public static void getConnection()
  {
    try
   {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false","root","root");
	   System.out.println("got connection");
   }
   catch(Exception e)
  {}
  }
  public static int selectUser(String username,String password){
	  int flag=0;
  try{
	  
      getConnection();
      
	  String selectuserid = "SELECT * FROM USER2 WHERE USERNAME = ? AND PASSWORD = ? ;";  
      PreparedStatement pst = conn.prepareStatement(selectuserid);
	  System.out.println("query execution");
	  pst.setString(1,username);
	  pst.setString(2,password);
	  ResultSet rs = pst.executeQuery();
	  while(rs.next()){
	  flag = 1;
	  String user = rs.getString("username");
	  String pass = rs.getString("password");
	  }
	  
}
catch(Exception e){System.out.println(e);}
 return flag;
}
  
  
  
  
  
  }
