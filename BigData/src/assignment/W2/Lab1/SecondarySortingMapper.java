package assignment.W2.Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SecondarySortingMapper {
	public List<keyValuePair<keyValuePair<String, String>,String>> valuesList = new ArrayList<>();
	public List<keyValuePair<Integer,Integer>> initialValue = new ArrayList<>();

	String filename;

	public SecondarySortingMapper(String fileLocation) {
		this.filename = fileLocation;
	}

	public List<keyValuePair<keyValuePair<String, String>,String>> getValuesList() {
		return valuesList;
	}

	public void mapValues() {
		try {
			Scanner scan = new Scanner(new File(filename));
			while (scan.hasNextLine()) {
				Scanner line = new Scanner(scan.nextLine());
				//List<Integer> numberArray = new ArrayList<>();
				List<String> valueArray = new ArrayList<>();
				while (line.hasNext()) {
					String values[] = line.nextLine().split("\t");
					keyValuePair<String, String> key = new keyValuePair<String,String>(values[1],values[0]);
					keyValuePair<keyValuePair<String,String>,String> pairValue = new keyValuePair<>(key,values[2]);
					
					valuesList.add(pairValue);
				}
			}
			valuesList.stream().forEach(System.out::println);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	public void printSortedList() {
		System.out.println("-----------Sorted List-----------");
		valuesList.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------------");
	}

	public void printUnSortedList() {
		System.out.println("-----------UnSorted List-----------");
		valuesList.stream().forEach(System.out::println);
		System.out.println("---------------------------------");
	}
	 public static void main(String[] args) {
		 String filePath = System.getProperty("user.dir");
		 filePath += "\\src\\assignment\\W2\\Lab1\\data0.txt";
		// System.out.println(filePath);
		SecondarySortingMapper obj = new SecondarySortingMapper(filePath);
		obj.mapValues();
		//obj.inMapperPairs().stream().forEach(System.out::println);
		
	}
}
