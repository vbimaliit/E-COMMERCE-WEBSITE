import java.io.*;
public class User
{
String userid ;
String password;
String confirmpassword;
String usertype;

public  User(String userid,String password,String confirmpassword,String usertype)
{
	
	this.userid = userid;
	this.password = password;
	this.confirmpassword = confirmpassword;
	this.usertype = usertype;
	
	
}


public String getUserid(){
 return userid;
}

public String getPassword () {
 return password;
}

public String getUsertype(){
return usertype;
}
public String getConfirmpassowrd(){
return confirmpassword;
}

}
