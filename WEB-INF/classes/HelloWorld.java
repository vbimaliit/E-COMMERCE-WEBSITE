public class HelloWorld {
   public static void main(String[] args) {
//	   long startTime = System.currentTimeMillis();
	   
   int a[] =new int [4];
   int b[] =new int [4];
   int y = 0;
   a[0] = 2; a[1] = 3;a[2] = 4; a[3] = 5; b[0] =1 ; b[1] = 3;b[2] =6 ; b[3] = 7;
   int c;
   long startTime = System.currentTimeMillis();
   for (int i=0;i<4;i++){
         for (int j=0;j<4;j++){
		 c = (a[i] * b[j]);
//		 System.out.println(a[i]);
//		 System.out.println(b[j]);
		 System.out.println(c);
		 
		 }
   
   }
   long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
   }
   }
   
   