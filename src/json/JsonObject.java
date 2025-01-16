package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class JsonObject {
	private static final Character[] prse = {
			',',
			'}',
			']'
	};
	public static final ArrayList<Character> parseEnd = new ArrayList<>(Arrays.asList(prse));
	public static final int LINE_NOT_REQUIRED = -1;
	public static final int STRING_LINE_INDEFINITE = -2;
	File jsonFile;
	String jsonFilePath;
	public JsonElement parsedJson;
	public JsonObject(String path) {
		jsonFilePath = path;
		jsonFile = new File(path);
	}
	public void parse() throws IOException {
		//retrieving parsed String
		System.out.println("JsonObject.java | parse()  :  Parsing Started");
		ArrayList<String> contents = new ArrayList<>();
		BufferedReader BuffjsonReader = new BufferedReader(new FileReader(jsonFile));
		String inputString;
		while((inputString = BuffjsonReader.readLine()) != null) {
			contents.add(inputString);
			System.out.println("JsonObject.java | parse()  :  JSON file contents: " + inputString);
		}
		
		//starts Line by Line, Character by Character parsing
		ArrayList<JsonElement> ConstructRAM = new ArrayList<>();
		ArrayList<JsonElement> SectorRam = new ArrayList<>();
		for (int lineindex = 0; lineindex < contents.size(); lineindex++) {
			String line = contents.get(lineindex);
			for (int CharIndex = 0; CharIndex < line.length(); CharIndex++ ) {
				System.out.println("JsonObject.java | parse()  :  Proccessing Char: " + line.charAt(CharIndex));
				char character = line.charAt(CharIndex);
				
				//check 
				if (character == '\"') { //Checks for String construction
					CharIndex = stringLoad(ConstructRAM, line, CharIndex)[0];
				}
				if (character == ',' ) { //Checks for ',' ending
					construct(ConstructRAM, line, CharIndex);
				}
				if (Character.isDigit(character)) {
					CharIndex = numberLoad(ConstructRAM, line, CharIndex)[0];
				}
				if (character == 't' || character == 'f') {
					CharIndex = booleanLoad(ConstructRAM, line, CharIndex)[0];
				}
			}
		}
	}
	private JsonElement construct(ArrayList<JsonElement> ConstructInfo, String line, int CharIndex) {
		for (int backTrack = 1; backTrack < CharIndex; backTrack++) {
			if (Character.isWhitespace(line.charAt(CharIndex - backTrack)) == false) {
				switch (line.charAt(CharIndex - backTrack)) {
				case ']':
					//Array Code
					break;
				case '}':
					//Section Code
					break;
				default:
					
					
				}
			}
		}
		return new JsonElement("PLACEHOLDER", 19491001);
	}
	private int[] arrayLoad() {
		
	}
	private int[] sectionLoad() {
		
	}
	private int[] booleanLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex) {
		System.out.println("JsonObject.java | (hidden) booleanLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  Loading Boolean at: " + StartCharIndex + "of: " + line);
		boolean bool = false;
		for (int charoffset = 0; charoffset < line.length() - 1; charoffset++) {
			try {
				line.charAt(StartCharIndex + 1 + charoffset);
			} catch (Exception e) {
				charoffset = charoffset - 1;
				switch (line.substring(StartCharIndex, StartCharIndex + charoffset + 2)) {
				case "true" :
					bool = true;
					break;
				case "false" :
					break;
				default:
					System.out.println(line.substring(StartCharIndex, StartCharIndex + charoffset + 2));
					throw new IllegalArgumentException();
					//what type of GARBAGE is in the file
				}
				JsonElement boole = new JsonElement(JsonElement.type.Bool);
				boole.boolValue = bool;
				loadto.add(boole);
				int[] returnarray = {charoffset + 1 + StartCharIndex, LINE_NOT_REQUIRED};
				System.out.println("JsonObject.java | (hidden) booleanLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  Loaded Boolean: " + bool);
				return returnarray;
			}
			if (Character.isWhitespace(line.charAt(StartCharIndex + 1 + charoffset)) == true || parseEnd.contains(line.charAt(StartCharIndex + 1 + charoffset))) {
				switch (line.substring(StartCharIndex, StartCharIndex + charoffset + 1)) {
				case "true" :
					bool = true;
					break;
				case "false" :
					break;
				default:
					System.out.println(line.substring(StartCharIndex, StartCharIndex + charoffset + 1));
					throw new IllegalArgumentException();
					//what type of GARBAGE is in the file
				}
				JsonElement boole = new JsonElement(JsonElement.type.Bool);
				boole.boolValue = bool;
				loadto.add(boole);
				int[] returnarray = {charoffset + 1 + StartCharIndex, LINE_NOT_REQUIRED};
				System.out.println("JsonObject.java | (hidden) booleanLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  Loaded Boolean: " + bool);
				return returnarray;
			}
		}
		int[] a = {line.length(),STRING_LINE_INDEFINITE};
		return a;
		
	}
	private int[] numberLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex) {
		System.out.println("JsonObject.java | (hidden) numberLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  Loading Number at: " + StartCharIndex + "of: " + line);
		float number = -19491001;
		for (int charoffset = 0; charoffset < line.length() - 1; charoffset++ ) {
			try {
				line.charAt(StartCharIndex + 1 + charoffset);
			} catch (Exception e) {
				System.out.println("JsonObject.java | (hidden) numberLoad(ArrayList<JsonElement> loadto, String line, int StartChar Index  :  Reached End Of Line. Starting from last Char");
				charoffset = charoffset - 1;
				number = Float.parseFloat(line.substring(StartCharIndex, StartCharIndex + charoffset + 2));
				System.out.println("JsonObject.java | (hidden) numberLoad(ArrayList<JsonElement> loadto, String line, int StartChar Index  :  Loaded Number: " + number);
				JsonElement added = new JsonElement(JsonElement.type.Num);
				added.numValue = number;
				loadto.add(added); 
				int[] returnarray = {charoffset + 1 + StartCharIndex, LINE_NOT_REQUIRED};
				return returnarray;
			}
			if (Character.isDigit(line.charAt(StartCharIndex + 1 + charoffset)) == false && line.charAt(StartCharIndex + 1 + charoffset) != '.') {
				number = Float.parseFloat(line.substring(StartCharIndex, StartCharIndex + charoffset + 1));
				System.out.println("JsonObject.java | (hidden) numberLoad(ArrayList<JsonElement> loadto, String line, int StartChar Index  :  Loaded Number: " + number);
				JsonElement added = new JsonElement(JsonElement.type.Num);
				added.numValue = number;
				loadto.add(added); 
				int[] returnarray = {charoffset + 1 + StartCharIndex, LINE_NOT_REQUIRED};
				return returnarray;
			}
		}
		int[] a = {0,STRING_LINE_INDEFINITE};
		return a;
	}
	private int[] stringLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex) {
		System.out.println("JsonObject.java | (hidden) stringLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  Loading string at: " + StartCharIndex + " of: " + line);
		String str = "";
		for (int charoffset = 0; charoffset < line.length() - 1; charoffset++ ) {
			if (line.charAt(StartCharIndex + 1 + charoffset) != '"') {
				str = str + line.charAt(StartCharIndex + 1 + charoffset);
				if (line.charAt(StartCharIndex + 1 + charoffset) == '\\') {
					str = str.substring(0, str.length() - 1);
					str = str + line.charAt(StartCharIndex + 2 + charoffset);
					charoffset++;
				}
			} else {
				JsonElement added = new JsonElement(JsonElement.type.Str);
				added.strValue = str;
				loadto.add(added);
				System.out.println("JsonObject.java | (hidden) stringLoad(ArrayList<JsonElement> loadto, String line, int StartCharIndex)  :  String Loaded: " + str);
				int[] returnarray = {charoffset + 1 + StartCharIndex, LINE_NOT_REQUIRED};
				return returnarray;
			}
		}
		int[] a = {line.length(),STRING_LINE_INDEFINITE};
		return a;
	}
}