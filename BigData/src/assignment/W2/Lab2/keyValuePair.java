package assignment.W2.Lab2;

public class keyValuePair<k,v> {
	private k key;
	private v value;

	public keyValuePair(k key, v value) {
		this.key = key;
		this.value = value;
	}
	
	public keyValuePair()
	{
		
	}

	public k getKey() {
		return key;
	}

	public v getValue() {
		return value;
	}

	public void setKey(k key) {
		this.key = key;
	}

	public void setValue(v value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "<" + key + " , " + value + " >";
	}
}
