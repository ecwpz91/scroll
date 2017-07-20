/**
 * The Value class is an abstract data type object that provides arithmetic operations
 * (add, subtract, multiply, and divide) with other corresponding value objects.
 * @author msurbey
 * @version 1.0
 */
public class Value {
	private double dval;
	private String sval;
	private String tag;
	
	/**
	 * Constructs a newly allocated Value object which sets sval to an empty String, tag to
	 * "STRING", and dval to zero.
	 */
	public Value() {
		sval = ""; //set sval to a string when instantiated
		tag = "STRING"; //set tag to "STRING" when instantiated
		dval = 0; //set dval to zero when instantiated
	}
	
	/**
	 * Constructs a newly allocated Value object which sets sval to data, or dval to data depending
	 * on whether or not the data contains a '"' sign, and then sets the tag to either a "STRING" or 
	 * a "DBL."
	 */
	public Value(String data) throws NumberFormatException { //if is neither case
		//throws an exception to be dealt with by another class
		if (data.startsWith("\"")) { //checks to see if the data being passed through starts
			//with a '"'
			sval = data.substring(1); //sets sval to String data (without the '"')
			tag = "STRING"; //set tag to "STRING" when instantiated
		} else {
			dval = Double.parseDouble(data); //parses the String data to make it a double
			tag = "DBL"; //changes the Value object's tag to double
		}
	}
	
	/**
	 * Alters the current value's data depending the in coming String data.
	 * @param data - if data contains a '"' before its String representation, then sval is
	 * initialized to data. Otherwise, data is changed to a parsed double, dval is set to data,
	 * and Value's tag is changed to "DBL."
	 * @throws NumberFormatException - if the data dose not represent a numerical value.
	 */
	public void setValue(String data) throws NumberFormatException { //if is neither case
		//throws an exception to be dealt with by another class
		if (data.startsWith("\"")) { //checks to see if the data being passed through starts
			//with a '"'
			sval = data.substring(1); //sets sval to String data (without the '"')
		} else {
			dval = Double.parseDouble(data); //parses the String data to make it a double
			tag = "DBL"; //changes the Value object's tag to double
		}
	}
	
	/**
	 * Compares two Value objects to determine whether or not they can be added together. If
	 * both contain "DBL" tags, then the current Value object's dval is set to the resulting
	 * arithmetic. Otherwise, the objects are compared to determine if one or both Value object 
	 * tag(s) should be changed to "INVALID".
	 * @param obj - other Value object being compared to current value object.
	 * @return Null or a new Value object with appropriate arithmetic, depending on whether 
	 * or not both this object's and the passed in object's tags were of type "DBL."
	 */
	public Value plus(Value obj) {
		Value newValue = new Value();
		if (obj.tag.equalsIgnoreCase("DBL") && tag.equalsIgnoreCase("DBL")) {
			newValue.setValue("" + (dval + obj.dval)); //add current value object and obj
			return newValue; //return new value object
		} else if (obj.tag.equalsIgnoreCase("STRING") && tag.equalsIgnoreCase("STRING")) {
			obj.tag = "INVALID"; //change obj's tag to "INVALID"
			tag = "INVALID"; //change current value object's tag to "INVALID"
		} else if (obj.tag.equalsIgnoreCase("STRING"))
			obj.tag = "INVALID"; //change only obj's tag to "INVALID"
		else
			tag = "INVALID"; //change only current object's tag to "INVALID"
		return this;
	}
	
	/**
	 * Compares two Value objects to determine whether or not they can be subtracted from one 
	 * another.
	 * @param obj - other Value object being compared to current value object.
	 * @return Null or a new Value object with appropriate arithmetic, depending on whether 
	 * or not both this object's and the passed in object's tags were of type "DBL."
	 */
	public Value minus(Value obj) {
		Value newValue = new Value();
		if (obj.tag.equalsIgnoreCase("DBL") && tag.equalsIgnoreCase("DBL")) {
			newValue.setValue("" + (dval - obj.dval)); //subtract current value object and obj
			return newValue; //return new value object
		} else if (obj.tag.equalsIgnoreCase("STRING") && tag.equalsIgnoreCase("STRING")) {
			obj.tag = "INVALID"; //change obj's tag to "INVALID"
			tag = "INVALID"; //change current value object's tag to "INVALID"
		} else if (obj.tag.equalsIgnoreCase("STRING"))
			obj.tag = "INVALID"; //change only obj's tag to "INVALID"
		else
			tag = "INVALID"; //change only current object's tag to "INVALID"
		return this;
	}
	
	/**
	 * Compares two Value objects to determine whether or not they can be multiplied together.
	 * @param obj - other Value object being compared to current value object.
	 * @return Null or a new Value object with appropriate arithmetic, depending on whether 
	 * or not both this object's and the passed in object's tags were of type "DBL."
	 */
	public Value star(Value obj) {
		Value newValue = new Value();
		if (obj.tag.equalsIgnoreCase("DBL") && tag.equalsIgnoreCase("DBL")) {
			newValue.setValue("" + (dval * obj.dval)); //multiply current value object and obj
			return newValue; //return new value object
		} else if (obj.tag.equalsIgnoreCase("STRING") && tag.equalsIgnoreCase("STRING")) {
			obj.tag = "INVALID"; //change obj's tag to "INVALID"
			tag = "INVALID"; //change current value object's tag to "INVALID"
		} else if (obj.tag.equalsIgnoreCase("STRING"))
			obj.tag = "INVALID"; //change only obj's tag to "INVALID"
		else
			tag = "INVALID"; //change only current object's tag to "INVALID"
		return this;
	}
	
	/**
	 * Compares two Value objects to determine whether or not they can be divided from one
	 * another.
	 * @param obj - other Value object being compared to current value object.
	 * @return Null or a new Value object with appropriate arithmetic, depending on whether 
	 * or not both this object's and the passed in object's tags were of type "DBL."
	 */
	public Value slash(Value obj) throws ArithmeticException {
		ArithmeticException ae = new ArithmeticException();
		Value newValue = new Value();
		if (obj.tag.equalsIgnoreCase("DBL") && tag.equalsIgnoreCase("DBL")) {
			if (obj.dval == 0 && dval != 0) //check for divide by zero
				throw ae;
			else if (dval == 0)
				newValue.setValue(""+0);
			else
				newValue.setValue("" + (dval / obj.dval)); //divide current value object and obj
			return newValue; //return new value object
		} else if (obj.tag.equalsIgnoreCase("STRING") && tag.equalsIgnoreCase("STRING")) {
			obj.tag = "INVALID"; //change obj's tag to "INVALID"
			tag = "INVALID"; //change current value object's tag to "INVALID"
		} else if (obj.tag.equalsIgnoreCase("STRING"))
			obj.tag = "INVALID"; //change only obj's tag to "INVALID"
		else
			tag = "INVALID"; //change only current object's tag to "INVALID"
		return this;
	}
	
	/**
	 * Returns a String object representing the specified tag.
	 * @return String
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Returns a String object representing the specified value.
	 * @return String
	 */
	public String toString() {
		if (tag.equalsIgnoreCase("INVALID") || tag.equalsIgnoreCase("STRING"))
			return sval;
		return Double.toString(dval);
	}
}