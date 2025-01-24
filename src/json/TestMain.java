package json;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		//console-like testing commands
		Scanner inputScanner = new Scanner(System.in);
		JsonObject FOR_json = new JsonObject(Paths.get("src\\json\\Test.Formatted.json"));
		JsonObject UNF_json = new JsonObject(Paths.get("src\\json\\Test.Unformatted.json"));
		String input = inputScanner.nextLine();
		switch (input) {
		case "FOR_json":
			try {
				FOR_json.parse();
				System.out.println(FOR_json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "UNF_json":
			try {
				UNF_json.parse();
				System.out.println(UNF_json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "LN_PRC":
			input = inputScanner.nextLine();
			JsonObject cust = new JsonObject(input);
			try {
				cust.parse();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(cust.parsedJson.getTagValue());
			break;
		default:
			try {
				JsonObject customjson = new JsonObject(Paths.get(input));
				customjson.parse();
				System.out.println(customjson.parsedJson.getTagValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		inputScanner.close();
	}
}
