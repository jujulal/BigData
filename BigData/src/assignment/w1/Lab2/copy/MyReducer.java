package assignment.w1.Lab2.copy;

import java.util.ArrayList;
import java.util.List;
import assignment.Lab2.*;

public class MyReducer {
	
	private List<Pair<String, List<Integer>>> groupedList;
	private List<Pair<String, Integer>> mappedObjs;
	
	public MyReducer(){
		groupedList = new ArrayList<>();
		mappedObjs = new ArrayList<>();
	}
	public MyReducer(List<Pair<String,Integer>> mappedObjs){
		this.mappedObjs = mappedObjs;
	}
	
	

	public List<Pair<String, Integer>> reduceMergeList(
			List<Pair<String, List<Integer>>> listOfWords) {
		List<Pair<String, Integer>> reducedWordList = new ArrayList<>();
		
		for(Pair p:listOfWords){
			Integer val = 0; 
			for(Integer v: (List<Integer>)p.getValue()){
				val += v;
			}
			reducedWordList.add(new Pair(p.getKey(),val));
		}
		
		return reducedWordList;
	}

	public List<Pair<String, List<Integer>>> mergeList(
			List<Pair<String, Integer>> wordList) {

		List<Pair<String, List<Integer>>> mergeWordList = new ArrayList<>();

		for (Pair pairObj : wordList) {
			// searching for existing pair
			Pair mergeObj = this.getPair((String) pairObj.getKey(),
					mergeWordList);
			if (mergeObj == null) {
				mergeObj = new Pair((String) pairObj.getKey(),
						new ArrayList<>());
				mergeWordList.add(mergeObj);
			}

			((List) mergeObj.getValue()).add(pairObj.getValue());
			// System.out.println(mergeObj.getValue());
		}

		return mergeWordList;
	}

	public Pair getPair(String key,
			List<Pair<String, List<Integer>>> mergeWordList) {
		for (Pair p : mergeWordList) {
			if (p.getKey().equals(key)) {
				return p;
			}
		}
		return null;
	}
	
	public void addMappedObj(Pair<String, Integer> p){
		mappedObjs.add(p);
	}
	
	public static void main(String[] args) {
		MyMapper mapperObj = new MyMapper("c:/txtFile/testDataForW1D1.txt");
		List<Pair<String, Integer>> mappedObj = mapperObj.maperInput();

		MyReducer reducerObj = new MyReducer();
		List<Pair<String, List<Integer>>> tmpList = reducerObj
				.mergeList(mappedObj);

		//tmpList.stream().sorted().forEach(System.out::println);
		List<Pair<String,Integer>> reducedWList = reducerObj.reduceMergeList(tmpList);
		reducedWList.stream().sorted().forEach(System.out::println);
	}
}
