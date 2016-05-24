package test;
class MyClass { 
 static String input="Hello";
	static void subString(int startIndex, int endIndex)
	{
		if(startIndex ==input.length() && endIndex == input.length())
			return;
		else
		{
			if(endIndex == input.length()+1){
				subString(startIndex+1,startIndex+1);
			}else{
				System.out.println(input.substring(startIndex, endIndex))
				subString(startIndex,endIndex+1);
			}
		}
	}
	
	public static void main(String[]args]){
		subString(0,1);
	}
}
