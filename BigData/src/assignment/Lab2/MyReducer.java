package assignment.Lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyReducer {
	Map mapString = new HashMap();

	public void maperInput() {
		FileReader fileReader;
		String line;
		try {
			fileReader = new FileReader("c:/txtFile/testDataForW1D1.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);

			while ((line = bufferReader.readLine()) != null) {

				String[] tokens = line.split(" ");

				for (int i = 0; i < tokens.length; i++) {
					if (isWord(tokens[i]) != null) {
						stringMap.put(tokens[i], 1);
						// System.out.println(tokens[i]);
					}

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
