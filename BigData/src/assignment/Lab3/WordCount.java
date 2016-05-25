package assignment.Lab3;

import assignment.Lab2.MyMapper;
import assignment.Lab2.MyReducer;

public class WordCount {

	private MyMapper mappers[];
	private MyReducer reducers[];
	
	public WordCount(int m, int r){
		mappers = new MyMapper[m];
		reducers = new MyReducer[r];
	}
	
	public void shuffleSort(){
		//initialing mappers instance
		for(int i=0;i<mappers.length;i++){
			mappers[i]= new MyMapper();
		}
		//initialing reducers instance
		for(int i=0;i<reducers.length;i++){
			reducers[i]=new MyReducer();
		}
		
	}
}
