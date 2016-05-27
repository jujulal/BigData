package assignment.Lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMapper {
	String fileName;
	public MyMapper(String fileName){
		this.fileName = fileName;
	}
	
	public static void main(String []args){
		MyMapper mapperObj = new MyMapper("c:/txtFile/testDataForW1D1.txt"); 
		
		mapperObj.printMapperValue(mapperObj.map());
	}
	
	public List<Pair<Character,Integer>> map() {

		try {
			List<Pair<Character, List<Integer>>> wordList = new ArrayList<>();

			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line;

			String regexPattern = "\"??([A-Za-z]+-??[A-Za-z]+|[A-Za-z])\"??\\.??";
			Pattern r = Pattern.compile(regexPattern);
			Matcher m;

			String[] tokens;
			while ((line = bufferReader.readLine()) != null) {

				tokens = line.split(" ");
				for (String token : tokens) {
					m = r.matcher(token);
					if (m.find()) {
						/*System.out.println(m.group(0)
								.replace('"', '\0')
								.trim()
								.toLowerCase());*/
						String myKey = m.group(0)
								.replace('"', '\0')
								.trim()
								.toLowerCase();
						wordList.add(new Pair<Character, Pair<Integer, Integer>(myKey.charAt(0),new Pair(myKey.length(),1)));
					}
				}

			}
			bufferReader.close();
			return wordList;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void printMapperValue(List<Pair<Character,Integer>> wordList){
		System.out.println("Sorted List");
		wordList
			.stream()
			//.map(Pair::getKey)
			.sorted()
			.forEach(System.out::println);
	}
}
