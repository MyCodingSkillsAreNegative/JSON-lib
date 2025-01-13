package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonObject {
	File jsonFile;
	String jsonFilePath;
	public JsonElement parsedJson;
	public JsonObject(String path) {
		jsonFilePath = path;
		jsonFile = new File(path);
	}
	public void parse() throws FileNotFoundException {
		//retrieving parsed String
		ArrayList<String> contents = new ArrayList<>();
		Scanner jsonReader = new Scanner(jsonFile);
		while (jsonReader.hasNextLine()) {
			contents.add(jsonReader.nextLine());
		}
		jsonReader.close();
		
		//starts Line by Line, Character by Character parsing
		for (String line : contents) {
			for (int CharIndex = 0; CharIndex < line.length(); CharIndex++ ) {
				System.out.println(line.charAt(CharIndex));
			}
		}
	}
	private int arrayLoad() {
		
	}
	private int sectionLoad() {
		
	}
	private int integerLoad() {
		
	}
	private int stringLoad() {
		
	}
}