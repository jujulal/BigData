package assignment.w1.Lab5_uncomplete;

public class Pair<k extends Comparable<k>,v> implements Comparable<Pair<k,v>> {
	private k key; 
	private v value;
	
	public Pair(k key, v value){
		this.key =key;
		this.value = value;
	}
	public k getKey() {
		return key;
	}
	public void setKey(k key) {
		this.key = key;
	}
	public v getValue() {
		return value;
	}
	public void setValue(v value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return "(" + key + "," + value + ")";
	}
	
	@Override
	public int compareTo(Pair<k, v> o) {
		// TODO Auto-generated method stub
		return key.compareTo(o.getKey());
	}
	
}
