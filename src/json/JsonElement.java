package json;

import java.util.ArrayList;

public class JsonElement {
	//Data type enums
	enum type {
		Str,
		Int,
		Sec,
		ArrInt,
		ArrStr,
		ArrArr
	}
	//Element type
	type ElementType;
	//Element name
	public String Name;
	//Values
	String strValue;
	int intValue;
	ArrayList<JsonElement> secValue = new ArrayList<JsonElement>(); //also for ArrArr
	ArrayList<Integer> arrIntValue = new ArrayList<>();
	ArrayList<String> arrStrValue = new ArrayList<>();
	public JsonElement(String name, String val) {
		Name = name;
		strValue = val;
		ElementType = type.Str;
	}
	public JsonElement(String name, int val) {
		Name = name;
		intValue = val;
		ElementType = type.Int;
	}
	public JsonElement(String name, type ELEMENT_TYPE) {
		Name = name;
		ElementType = ELEMENT_TYPE;
	}
	public Object getValue() {
		switch (this.ElementType) {
		case Str :
			return strValue;
		case Int :
			return intValue;
		case Sec :
			return secValue;
		case ArrInt :
			return arrIntValue;
		case ArrStr :
			return arrStrValue;
		case ArrArr :
			return secValue;
		default : 
			return "ERROR: UNCONFINED ENUM VALUE";
		}
	}
}