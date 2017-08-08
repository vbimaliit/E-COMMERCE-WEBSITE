import java.util.*;
public class Factorial{
  public static void main (String[] args)
  {
  int n =5;
  int product;
  int finalprodcut =   facts(n);
  
  int facts(int t)
   {
     if (t==0){
         return 1;}
     else{ 
     return  product = n * facts(n-1);}
	     
   }
   System.out.println(finalprodcut);
}
}