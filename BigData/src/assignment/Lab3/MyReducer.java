package assignment.Lab3;

import java.util.ArrayList;
import java.util.List;
import assignment.Lab2.*;

public class MyReducer {
	private List<Pair<String,Integer>> listOfPairs;
	private List<Pair<String, List<Integer>>> groupedListPair;
	private List<Pair<String, Integer>> reducedPairList;
	
	public MyReducer(){
		listOfPairs = new ArrayList<>();
		groupedListPair = new ArrayList<>();
		reducedPairList = new ArrayList<>();
	}
	public MyReducer(List<Pair<String,Integer>> listOfPairs){
		this.listOfPairs=listOfPairs;
	}
	
	public void addPair(Pair<String, Integer> p){
		listOfPairs.add(p);
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
	
	public List<Pair<String,List<Integer>>> merge(){
		for(Pair p:listOfPairs){
			Integer val=0;
			for(int v: p.getValue(){
				val +=v;
			}
			groupedListPair.add(new Pair(p.getKey(),val));
		}
		return groupedListPair;
	}
	
	
	public static void main(String[] args) {
		MyMapper mapperObj = new MyMapper("c:/txtFile/testDataForW1D1.txt");
		List<Pair<String, Integer>> mappedObj = mapperObj.map();
		//mappedObj.stream().sorted().forEach(System.out::println);
		
		MyReducer reducerObj = new MyReducer(mappedObj);
		List<Pair<String, List<Integer>>> tmpList = reducerObj.merge();
		
		tmpList.stream().sorted().forEach(System.out::println);
		//List<Pair<String,Integer>> reducedWList = reducerObj.reduceMergeList();
		//reducedWList.stream().sorted().forEach(System.out::println);
	}
}
