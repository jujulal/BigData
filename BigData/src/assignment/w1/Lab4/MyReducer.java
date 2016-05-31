package assignment.w1.Lab4;

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
		groupedListPair = new ArrayList<>();
		reducedPairList = new ArrayList<>();
	}
	
	public void addPair(Pair<String, Integer> p){
		listOfPairs.add(p);
	}

	public Pair getPair(String key) {
		if(groupedListPair == null)return null;
		for (Pair<String, List<Integer>> p : groupedListPair) {
			if (p.getKey().equals(key)) {
				return p;
			}
		}
		return null;
	}
	
	public List<Pair<String,List<Integer>>> merge(){
		for(Pair p:listOfPairs){
			Pair tempMergedPair = this.getPair((String)p.getKey()); 
			if(tempMergedPair == null)
				{
					tempMergedPair = new Pair((String)p.getKey(), new ArrayList<>());
					groupedListPair.add(tempMergedPair);
				}
			((List)tempMergedPair.getValue()).add(p.getValue());//adding value
		}
		return groupedListPair;
	}
	
	public List<Pair<String,Integer>> reduce(){
		for(Pair p:groupedListPair){
			int val=0;
			for(Integer v: (List<Integer>)p.getValue()){
				val+=v;
			}
			reducedPairList.add(new Pair(p.getKey(),val));
		}
		return reducedPairList;
	}
	
	public static void main(String[] args) {
		MyMapper mapperObj = new MyMapper("c:/txtFile/testDataForW1D1.txt");
		List<Pair<String, Integer>> mappedObj = mapperObj.map();
		//mappedObj.stream().sorted().forEach(System.out::println);
		
		MyReducer reducerObj = new MyReducer(mappedObj);
		List<Pair<String, List<Integer>>> tmpList = reducerObj.merge();
		tmpList.stream().sorted().forEach(System.out::println);

		List<Pair<String, Integer>> reducedList = reducerObj.reduce();
		reducedList.stream().sorted().forEach(System.out::println);
		//List<Pair<String,Integer>> reducedWList = reducerObj.reduceMergeList();
		//reducedWList.stream().sorted().forEach(System.out::println);
	}
}
