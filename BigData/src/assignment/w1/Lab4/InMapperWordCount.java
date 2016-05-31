package assignment.w1.Lab4;



public class InMapperWordCount {
	private MyMapper mappers[];
	private MyReducer reducers[];
	
	public InMapperWordCount(int m, int r){
		String filePath = System.getProperty("user.dir");
		mappers = new MyMapper[m];
		for(int i=0;i<mappers.length;i++){
			mappers[i]= new MyMapper(filePath + "/src/assignment/Lab4/file"+i+".txt");
		}
		reducers = new MyReducer[r];
		for(int i=0;i<reducers.length;i++){
			reducers[i]=new MyReducer();
		}
	}
	
	public void print(){
		System.out.println("Mapper output ----------------------------");
		for(MyMapper m: mappers){
		   System.out.println("Mapper output" );
		   m.map().stream().sorted().forEach(System.out::println);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InMapperWordCount inMapperWCObj = new InMapperWordCount(4,3);
		inMapperWCObj.print();

	}

}
