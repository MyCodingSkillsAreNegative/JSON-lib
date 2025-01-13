package json;

import java.io.FileNotFoundException;

public class TestMain {
	public static void main(String[] args) {
		JsonObject json = new JsonObject("src\\json\\Test.json");
		try {
			json.parse();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
