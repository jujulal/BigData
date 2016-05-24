package test;


public class Child extends Super{
	int x;
	@Override
	public void display(){
		System.out.println("I am from Child!");
	}
	public void xyz(){
		System.out.println("Iam from xyz!");
	}
	
	public static void main(String[]arg){
		Super c1 = new Child();
		c1.display();
		//c1.xyz();
	}
	
}
