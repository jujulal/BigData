package assignment.Lab2;

import java.util.ArrayList;
import java.util.List;
import assignment.Lab2.Pair;
import assignment.Lab2.MyMapper;

public class MyReducer {
	private List<Pair<String,List<Integer>>> groupedList = new ArrayList<>();
	
	public static void main(String[]args){
		String filename = "c:/txtFile/testDataForW1D1.txt";
		MyMapper mapperObj = new MyMapper();
		List<Pair<String,Integer>> mappedObj = mapperObj.maperInput(filename);
		
		MyReducer reducerObj = new MyReducer();
		//reducerObj.mergeList(mappedObj).stream().sorted().forEach(System.out::println);
		reducerObj.mergeList(mappedObj)
			.stream()
			.sorted()
			.forEach(item->System.out.println(item.getKey()));;
	}

	public List<Pair<String,List<Integer>>> mergeList(
			List<Pair<String,Integer>> wordList){
		
		List<Pair<String,List<Integer>>> mergeWordList = new ArrayList<>();
		
		for(Pair pairObj:wordList){
			//searching for existing pair
			System.out.println(pairObj.toString());
			Pair mergeObj = this.getPair((String)pairObj.getKey(), mergeWordList);
			
			if(mergeObj == null){
				mergeObj = new Pair((String)mergeObj.getKey(), new ArrayList<>());
				mergeWordList.add(mergeObj);
			}else
			((List)mergeObj.getValue()).add(pairObj.getValue());
		}
		
		return mergeWordList;
	}
	public Pair getPair(String key, List<Pair<String,List<Integer>>> mergeWordList){
		for(Pair p: mergeWordList){
			if(p.getKey().equals(key)){
				return p; 
			}
		}
		return null;
	}
}
