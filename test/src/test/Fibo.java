package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo {
	static BufferedReader keyboard = new
            BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException
   {
  	  int firstFibNum;
  	  int secondFibNum;
  	  int nth;

  	  System.out.print("Enter the first Fibonacci number: ");
       firstFibNum = Integer.parseInt(keyboard.readLine());
 	  System.out.println();

       System.out.print("Enter the second Fibonacci number: ");
       secondFibNum = Integer.parseInt(keyboard.readLine());
       System.out.println();

    	  System.out.print("Enter the desired Fibonacci number: ");
   	  nth = Integer.parseInt(keyboard.readLine());
 	  System.out.println();

    	  System.out.println("The Fibonacci number at position "
                   + nth + " is: "
	              + rFibNum(firstFibNum, secondFibNum, nth));
   }

   public static int rFibNum(int a, int b, int n)
   {
 	   	if(n == 1)
			return a;
 	   	else if(n == 2)
	    	     return b;
	   	else
	      	return rFibNum(a, b, n - 1) + rFibNum(a, b, n - 2);
   }
}
