package test;

public class CloneTest implements Cloneable {
	int a;
	Integer b; 
	CloneTest(int a, Integer b){
		this.a = a;
		this.b=b;
	}
	void display(){
		System.out.println("Value of a is "+a);
		System.out.println("Value of b is "+b);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone(); 
	}
	public static void main(String[]arg){
		try{
		CloneTest Orijinal = new CloneTest(5,6);
		System.out.println("Original");
		Orijinal.display();
	
		CloneTest Duplicate =(CloneTest) Orijinal.clone();
		System.out.println("Changing value of duplicate");
		Duplicate.setA(9);
		Duplicate.setB(99);
		
		System.out.println("Duplicate");
		Duplicate.display();
		
	
		System.out.println("Original");
		Orijinal.display();
		}catch (CloneNotSupportedException e){
			e.getStackTrace();
		}
		
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setB(Integer b) {
		this.b = b;
	}
}
