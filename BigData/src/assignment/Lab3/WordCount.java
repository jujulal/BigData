package assignment.Lab3;


public class WordCount {

	private MyMapper mappers[];
	private MyReducer reducers[];
	
	public WordCount(int m, int r){
		mappers = new MyMapper[m];
		reducers = new MyReducer[r];
		for(int i=0;i<r;i++){
			reducers[i]=new MyReducer();
		}
	}
	public void buildMappers(MyMapper[] mappers){
		this.mappers = mappers;
	}
	public void shuffleSort(){
		for(int i=0;i<mappers.length;i++){
			for(Pair<String,Integer> m: mappers[i].map()){
				reducers[this.getPartition(m.getKey())].addPair(m);
			}
		}
		
	}
	
	public void mappedList(){
		System.out.println("--------------------------");
		for(int m=0;m<mappers.length;m++){
			System.out.println("Mapped "+ m + " output");
			mappers[m].map().stream().sorted().forEach(System.out::println);
		}
	}
	
	public void mergedList(){
		System.out.println(" ------------------------- ");
		for(int r=0;r<reducers.length;r++){
			System.out.println("Reducer " +r+ " merged output");
			reducers[r].merge().stream().sorted().forEach(System.out::println);
		}
	}
	
	public void reducedList(){
		System.out.println("---------------------------");
		for(int red=0;red<reducers.length;red++){
			System.out.println("Reducer " +red+" reduced output");
			reducers[red].reduce().stream().forEach(System.out::println);
		}
	}
	
	public int getPartition(String key){
		return (int)Math.abs(key.hashCode()%reducers.length);
	}
	
	public static void main(String[] arg){
		WordCount wordCountObj = new WordCount(3,4);
		
		MyMapper mappers[]= new MyMapper[3];
		for(int i=0;i<mappers.length;i++){
			mappers[i] = new MyMapper("c:/txtFile/file"+i+".txt");
		}
		
		wordCountObj.buildMappers(mappers);	
		wordCountObj.mappedList();
		wordCountObj.shuffleSort();
		wordCountObj.mergedList();
		wordCountObj.reducedList();
	}
}
