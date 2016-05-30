package assignment.w1.Lab1.copy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReadWords {
	
	public static String isWord(String word){
		String sWord="";
		
		for(int i=0;i<word.length();i++){
			Character charAt = word.charAt(i);
			if(Character.isAlphabetic(charAt) || charAt=='-'){
				sWord += charAt;
			}else{
				return null;
			}
		}
		
		return sWord; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map stringMap = new HashMap();
		String line;
		try {
			FileReader fileReader = new FileReader("c:/txtFile/testDataForW1D1.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			while((line = bufferReader.readLine()) != null){
				
				String[] tokens =  line.split(" ");
					
				for(int i=0; i<tokens.length;i++){	
					if(isWord(tokens[i]) != null){
						stringMap.put(tokens[i], 1);
						//System.out.println(tokens[i]);
					}
				
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
