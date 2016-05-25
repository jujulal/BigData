package assignment.Lab2;

import java.util.ArrayList;
import java.util.List;
import assignment.Lab2.*;

public class MyReducer {
	private List<Pair<String,List<Integer>>> groupedList = new ArrayList<>();
	
	public static void main(String[]args){
		MyMapper mapperObj = new MyMapper();
		List<Pair<String,Integer>> mappedObj = mapperObj.maperInput();
		
		MyReducer reducerObj = new MyReducer();
		reducerObj.mergeList(mappedObj).stream().sorted().forEach(System.out::println);
	}

	public List<Pair<String,List<Integer>>> mergeList(
			List<Pair<String,Integer>> wordList){
		
		List<Pair<String,List<Integer>>> mergeWordList = new ArrayList<>();
		
		for(Pair pairObj:wordList){
			//searching for existing pair
			Pair mergeObj = this.getPair((String)pairObj.getKey(), mergeWordList);
			if(mergeObj == null){
				mergeObj = new Pair((String)mergeObj.getKey(), new ArrayList<>());
				mergeWordList.add(mergeObj);
			}
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
