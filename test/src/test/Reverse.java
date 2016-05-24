package test;

public class Reverse {
	public static void main(String[] args) {
		xMethod(1234567);
		System.out.println();
		int x[]={5,10,12,15,7,0};
		int size = x.length;
		System.out.println(search(x,6,12));
		
	}
	public static void xMethod(int n) {
		if (n > 0) {
		System.out.print(n % 10);
		xMethod(n / 10);
		}
		}
	
	public static boolean search(int[] x, int size, int n) { 
		 if (size > 0) { 
		 if (x[size-1] == n) { 
		 return true; 
		 } else { 
		 return search(x, size-1, n); 
		 } 
		 } 
		 return false; 
		}
	}
