package assignment.w1.Lab5_uncomplete.copy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assignment.Lab5_uncomplete.Pair;

public class MyMapper {
	String fileName;

	public MyMapper(String fileName) {
		this.fileName = fileName;
	}

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir");
		MyMapper mapperObj = new MyMapper(filePath + "/src/assignment/Lab5/input0.txt");

		 mapperObj.printMapperValue(mapperObj.map());
		// mapperObj.map().stream().forEach(System.out::println);
		//System.out.println(mapperObj.map().toString());
		// String[] tmp = {"12","90","80", "12", "19", "80","33","80"};
		// System.out.println(mapperObj.getNeighbors(3, tmp));
	}

	public List<String> getNeighbors(int pos, String[] inputList) {
		List<String> listOfNeighbors = new ArrayList<String>();

		if (pos < 0 || pos >= inputList.length)
			return null;

		for (int i = pos + 1; i < inputList.length; i++) {
			if (inputList[pos].equals(inputList[i])) {
				break;
			} else {
				listOfNeighbors.add(inputList[i]);
			}
		}
		return listOfNeighbors;
	}

	public Map<Pair<String,String>,Integer> map() {

		try {
			//List<Pair<Pair<String, String>,Integer>> wordList=new ArrayList();
			Map<Pair<String,String>,Integer> wordList=new HashMap<>();
			
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line;
			String[] tokens;

			while ((line = bufferReader.readLine()) != null) {
				tokens = line.split(" ");
				for (int i = 0; i < tokens.length; i++) {
					List<String> neighbors = this.getNeighbors(i, tokens);
					
					if(wordList.containsKey(tokens[i])){
						
						Pair<String,String> valueMap = wordList.get(new Pair(tokens[i], tokens[i+1]));
						for(int k=0;k<neighbors.size();k++){
							if(valueMap.containsKey(neighbors.get(k))){
								valueMap.put(neighbors.get(k), valueMap.get(neighbors.get(k))+1);
							}
							else{
								//Map<String,Integer> valueMap1 = new HashMap();
								valueMap.put(neighbors.get(k), 1);
							}
						}
					}
					else{
						Map<String, Integer> valueMap = new HashMap();
						for(int j=0;j<neighbors.size();j++){
							if(valueMap.containsKey(neighbors.get(j))){
								valueMap.put(neighbors.get(j), valueMap.get(neighbors.get(j))+1);
							}else{
								valueMap.put(neighbors.get(j), 1);
							}
						}
						wordList.put(tokens[i], valueMap);
					}
				}
			}
			bufferReader.close();
			return wordList;

		}catch(

	FileNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}catch(
	IOException e)
	{
		e.printStackTrace();
		return null;
	}

	}

	public void printMapperValue(Map<String,Map<String,Integer>> wordList) {
		System.out.println("Sorted List");
		/*wordList.stream()
				// .map(Pair::getKey)
				.sorted().forEach(System.out::println);*/

			
		for(int i=0;i<wordList.size();i++){
			System.out.print(wordList.toString());
		}
	}
}
