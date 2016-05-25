package assignment.Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintWords {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
		String line;
		try {
			FileReader fileReader = new FileReader("c:/tmp/testDataForW1D1.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			Pattern r = Pattern.compile("\"??([A-Za-z]+-??[A-Za-z]+|[A-Za-z])\"??\\.??");
			//Pattern r = Pattern.compile("([A-Za-z])");
			Matcher m;
			
			while((line = bufferReader.readLine()) != null){
				String[] tokens =  line.split(" ");
				for(String word: tokens){
					m=r.matcher(word);
					//System.out.println(m.find());
					if(m.find()){
						word = word.replace(".", "");
						word = word.replace("\"", "");
						word = word.toLowerCase();
						stringMap.put(word, 1);
						//System.out.println(word);
					}else{
						continue;
					}
					}
				}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//printing Map values
		Map<String, Integer> map2 = new TreeMap<String, Integer>(stringMap);
		Set set2 = map2.entrySet();
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext()){
			Map.Entry me2 = (Map.Entry)iterator2.next();
			System.out.println(me2.getKey()+ " , " + me2.getValue());
		}
		
	}
	
	private static class MapComparator implements Comparator<HashMap<String, Integer>> {
        @Override
        public int compare(HashMap<String, Integer> first, HashMap<String, Integer> second) {
            String firstValue = first.keySet().iterator().next();
            String secondValue = second.keySet().iterator().next();
            return firstValue.compareTo(secondValue);
        }
    }
}

