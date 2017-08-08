import java.util.*;
public class Hashmulti {
   public static void main(String[] args) {
	   int t;
	   
	   HashMap <Integer,Integer> input = new HashMap<Integer,Integer>();
	   HashMap <Integer,Integer> secinput = new HashMap<Integer,Integer>();
	   input.put(1,1);
	   input.put(2,2);
	   input.put(3,4);
	   input.put(4,8);
	   secinput.put(1,3);
	   secinput.put(2,4);
	   secinput.put(3,7);
	   secinput.put(4,9);
	   long startTime = System.currentTimeMillis();
	   for (int i= 1;i<=4;i++){
	        for (int j=1;j<=4;j++){
			t = input.get(i) * secinput.get(j);
			System.out.println(t);
			}
	   
	   }
	   
	   
	      long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
	   }
	  	   
	   }
	   