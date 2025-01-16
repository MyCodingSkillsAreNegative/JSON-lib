package json;

import java.util.ArrayList;

/*
 * On GitHub
 * @author MyCodingSkillsAreNegative
 */

public class JsonElement {
	//The name of a element without a name
	public static final String ELEMENT_ANONYMOUS = "ELEMENT_NO_NAME_INA:hn2Z19491001S19221230";
	//Data type enums
	enum type {
		Str,
		Num,
		Sec,
		Bool,
		ArrNum,
		ArrStr,
		ArrJsE,
		ArrBool
	}
	//Element type
	type ElementType;
	//Element name
	public String Name;
	//Values
	String strValue;
	float numValue;
	boolean boolValue;
	ArrayList<JsonElement> secValue = new ArrayList<JsonElement>(); //also for ArrArr
	ArrayList<Boolean> arrBoolValue = new ArrayList<>();
	ArrayList<Float> arrNumValue = new ArrayList<>();
	ArrayList<String> arrStrValue = new ArrayList<>();
	public JsonElement(String name, String val) {
		Name = name;
		strValue = val;
		ElementType = type.Str;
	}
	public JsonElement(String name, int val) {
		Name = name;
		numValue = val;
		ElementType = type.Num;
	}
	public JsonElement(String name, boolean val) {
		Name = name;
		boolValue = val;
		ElementType = type.Bool;
	}
	public JsonElement(String name, type ELEMENT_TYPE) {
		Name = name;
		ElementType = ELEMENT_TYPE;
	}
	public JsonElement(type VALUE) {
		Name = ELEMENT_ANONYMOUS;
		ElementType = VALUE;
	}
	public Object getValue() {
		switch (this.ElementType) {
		case Str :
			return strValue;
		case Num :
			return numValue;
		case Sec :
			return secValue;
		case Bool :
			return boolValue;
		case ArrNum :
			return arrNumValue;
		case ArrStr :
			return arrStrValue;
		case ArrJsE :
			return secValue;
		case ArrBool :
			return arrBoolValue;
		default : 
			return "ERROR: UNCONFINED ENUM VALUE";
		}
	}
}