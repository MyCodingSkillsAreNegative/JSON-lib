package json;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		//console-like testing commands
		Scanner inputScanner = new Scanner(System.in);
		JsonObject FOR_json = new JsonObject("src\\json\\Test.Formatted.json");
		JsonObject UNF_json = new JsonObject("src\\json\\Test.Unformatted.json");
		switch (inputScanner.nextLine()) {
		case "FOR_json":
			try {
				FOR_json.parse();
				System.out.println(FOR_json.parsedJson.getTagValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "UNF_json":
			try {
				UNF_json.parse();
				System.out.println(UNF_json.parsedJson.getTagValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		inputScanner.close();
	}
}
