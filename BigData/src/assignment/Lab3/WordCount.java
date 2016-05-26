package assignment.Lab3;

import assignment.Lab2.MyMapper;
import assignment.Lab2.MyReducer;
import assignment.Lab2.Pair;

public class WordCount {

	private MyMapper mappers[];
	private MyReducer reducers[];
	
	public WordCount(int m, int r){
		mappers = new MyMapper[m];
		reducers = new MyReducer[r];
	}
	
	public void shuffleSort(){
		
		//initialing reducers instance
		for(int i=0;i<reducers.length;i++){
			reducers[i]=new MyReducer();
		}
		
		//initialing mappers instance
		for(int i=0;i<mappers.length;i++){
			mappers[i]= new MyMapper("c:/txtFile/file"+i+".txt");
			//mappers[i].maperInput();
			
			for(Pair<String,Integer> m: mappers[i].maperInput()){
				reducers[this.getPartition(m.getKey())].addMappedObj(m);
			}
		}
		for(int i=0;i<reducers.length;i++){
			System.out.println("Reducer " + i + " output:");
			//for(List<Pair<String,Integer>> p: reducers[i].mergeList(wordList))
		}
	}
	
	public int getPartition(String key){
		return (int)Math.abs(key.hashCode()%reducers.length);
	}
	
	public static void main(String[] arg){
		WordCount wordCountObj = new WordCount(3,4);
		wordCountObj.shuffleSort();
	}
}
