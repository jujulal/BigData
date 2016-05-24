package test;
// a simple example of recursion.
class Factorials{
// this is recursive method
	int fact(int n)
	{
		int result;
		System.out.println("Step One------Value of n"+n);
		if(n==1) return 1;
		System.out.println("Step Two------Value of n"+n);
		result= fact(n-1)*n;
		System.out.println("Step of n in relation to result------Value of n"+n);
		System.out.println("Step Result------Value of n"+result);
		return result;
	}
}
public class Recursion {
public static void main(String args[])
{
	Factorials f=new Factorials();
	System.out.println("Factorial of 3 is"+f.fact(3));
	//System.out.println("Factorial of 3 is"+f.fact(4));
	//System.out.println("Factorial of 3 is"+f.fact(5));
}
}
