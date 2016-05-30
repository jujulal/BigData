package test;

import java.util.HashMap;
import java.util.Map;

class TestClass {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<>();
		m.put("Key1", "Value1");
		m.put("key2", "value2");
		if(m.get("Key1")!=null){
			m.put("Key1", m.get("Key1")+" Value3");
		}
		
		
		System.out.println(m.toString());
	}
}
