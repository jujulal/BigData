package test;
class MyClass2 { 
	public static void main(String[] args) {
		new MyClass2(); 
		} 
	MyClass2() {
		recurse("Hello"); 
		} 
	String recurse(String s){
		if(s==null || s.equals("")) return ""; 
		int n = s.length(); 
		String t = permute(s); //rearrange characters of s
		return recurse(t);
	}
}