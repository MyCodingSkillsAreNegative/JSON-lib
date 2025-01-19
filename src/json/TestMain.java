package json;

public class TestMain {
	public static void main(String[] args) {
		JsonObject FOR_json = new JsonObject("src\\json\\Test.Formatted.json");
		JsonObject UNF_json = new JsonObject("src\\json\\Test.Unformatted.json");
		try {
			FOR_json.parse();
			//UNF_json.parse();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(FOR_json.parsedJson.getTagValue());
	}
}
