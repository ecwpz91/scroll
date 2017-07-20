/* CS-211-001
 * -------------------------------------------------------------------------------
 * Name: Michael Surbey / G#: G00495157 / Assignment: project #2  / Date: 12/5
 * -------------------------------------------------------------------------------
 * Honor Code Statement: I recieved no assistance on this assignment that
 * violates the ethical guidelines set forth by the professor and class syllabus.
 * -------------------------------------------------------------------------------
 * References:
 *
 * -------------------------------------------------------------------------------
 * Comments:
 * Abstract class that implements methods from log entry and comparable form
 * updates all associated variables with a FormEntry and allows user to access
 * certain attributes of their FormEntry.
 * -------------------------------------------------------------------------------
 * Psedocode:
 * Updates all variables associated with FormEntry
 * getTime() - returns time stamp
 * updateTime() - updates time stamp
 * getForm() - returns form type
 * getNameValue() - returns collection of name value pairs
 * updateNV()
 * getBytes() - return byte count
 * compareTo(option) - user selected way of sorting
 * compareTo() - compares on basis of timestamp
 * equals() - compares form entry objects
 * getStaticHits() - all hits of the form
 * getFormHits() - form hits
 * formateFormEntry() - depends on the class accessing FormEntry (print method)
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author mikesurbey
 */
public abstract class FormEntry implements LogEntry, ComparableForm {
	
	private String timeStamp, formType, nameValue, bytes, statusCode;
	private static int staticHits = 0;
	private static ArrayList<String> formArray = new ArrayList<String>();
	
	//updates all variables if there is a completely new form entry object
	/**
	 * @param timeStamp - string time stamp parameter for form entry
	 * @param formName - string form name parameter for form entry
	 * @param nVPairs - string name value pairs for form entry
	 * @param bytes - string bytes for form entry
	 * @param statusCode - string status code for form entry
	 * @return none
	 */
	public void updateFormEntry(String timeStamp, String formName, String nVPairs, String bytes,
			String statusCode) {
		this.timeStamp = timeStamp;
		this.formType = formName;
		this.nameValue = nVPairs;
		this.bytes = bytes;
		this.statusCode = statusCode;
		formArray.add(formName);
		staticHits++;
	}

	//returns the form entry objects timestamp
	/**
	 * @return timeStamp variable
	 */
	public Timestamp getTime() {
		return Timestamp.valueOf(timeStamp);//converts timestamp string, and returns timestamp object
	}
	
	//updates the form entry objects timestamp
	/**
	 * @param time - takes in a time stamp object and updates the time stamp
	 * @return none
	 */
	public void updateTime(Timestamp time) {
		String timeString = time.toString();//turns time stamp into a string
		this.timeStamp = timeString;//sets current timestamp to new timestamp
	}

	//returns the form entry objects form type (name)
	/**
	 * @return formType; string form (passed in from update) 
	 */
	public String getForm() {
		return formType; //return this form type
	}

	//returns the form entry objects name value pairs
	/**
	 * @return an array list of name value objects
	 */
	public Collection<?> getNameValuePairs() {
		String[] nVCollection = this.nameValue.split("&");//split the namveValue string into a
		//collection of strings
		Arrays.sort(nVCollection); //sort the collection
		ArrayList<String> list = new ArrayList<String>();//default list to add values to
		for (int i=0; i<nVCollection.length; i++)//iterate through nVCollection
			if (!list.contains(nVCollection[i].toString()))//add to default list (collection)
				list.add(nVCollection[i].toString());//convert to string before adding (generics)
		return list;
	}
	
	//updates the form entry objects name value pairs
	/**
	 * @param nVPairs - collection of name value pairs
	 * @return none
	 */
	public void updateNV(Collection<?> nVPairs) {
		String nameValueString = "";//string to concat new timestamps strings to
		Iterator<?> list = nVPairs.iterator();//iterate through nVPairs
		for (int i=0; i<nVPairs.size(); i++)
				nameValueString = nameValueString.concat("&"+list.next().toString());//concat to nameValue string
		this.nameValue = nameValue.concat(nameValueString);
	}

	//returns the form entry objects bytes
	/**
	 * @return long - return the bytes as a long
	 */
	public long getBytes() {
		long longBytes = Long.parseLong(bytes);//convert string to long
		return longBytes;
	}
	
	//updates the objects bytes
	/**
	 * @param bytes - this objects new bytes
	 * @return nones
	 */
	public void updateBytes(long bytes) {
		String stringBytes = Long.toString(bytes);//convert long to string
		this.bytes = stringBytes;//set this object to new bytes
	}
	
	//returns status codes of the form entry object
	/**
	 * @return collection of status codes
	 */
	public Collection<?> getStatusCodes () {
		String[] sCCollection = this.statusCode.split("&");//split status codes
		Arrays.sort(sCCollection);//sort status codes
		ArrayList<String> list = new ArrayList<String>();//default list to add status code to (later returned)
		for (int i=0; i<sCCollection.length; i++)//iterate through collection of split status codes
			if (!list.contains(sCCollection[i].toString()))//see if collection contains status codes
				list.add(sCCollection[i].toString());
		return list;
	}
	
	//updates the form entry object status codes
	/**
	 * @param statusCodes - collection of current object staus codes
	 * @return none
	 */
	public void updateStatusCodes (Collection<?> statusCodes) {
		String statusCodesString = "";//default string
		Iterator<?> list = statusCodes.iterator();//iterate through collection
		for (int i=0; i<statusCodes.size(); i++)
				statusCodesString = statusCodesString.concat("&"+list.next().toString()); //concat objects of collection statusCodes to default string
		this.statusCode = statusCode.concat(statusCodesString);//set the status codes to new string
	}

	//used to determine a basis of comparing one form entry object to another
	//timestamp related
	/**
	 * @param object - takes in an object
	 * @return int - return 1 if object is bigger than parameter
	 * return -1 if object is smaller than parameter
	 * return 0 if they are the same
	 */
	public int compareTo(Object o) {
		FormEntry other = (FormEntry) o; //convert object into FormEntry
		Timestamp oTimestamp = other.getTime();//get objects timestamp
		long otherTime = oTimestamp.getTime();//convert timestamp to long
		
		Timestamp thisTimestamp = this.getTime();//get this objects timestamp
		long thisTime = thisTimestamp.getTime();//convert to long
		
		if (thisTime > otherTime)//compare timestamp objects long to eachother
			return 1;//return if this is bigger than other
		else if (thisTime < otherTime)
			return -1;//return if this is smaller than other
		else
			return 0;//return if this is equal to other
	}

	//depending on the users selected option, compares one form entry
	//object to another
	/**
	 * @param optinon - string (user selected option)
	 * @param o - FormEntry object
	 * @return int - return -1, 1, 0
	 */
	public int compareTo(String option, FormEntry o) {
		//user wants to compare dates
		if (option.equalsIgnoreCase("date")) {//if option is date
			Timestamp oTimestamp = o.getTime();//get timestamp of other
			long otherTime = oTimestamp.getTime();//convert to long
			
			Timestamp thisTimestamp = this.getTime();//get timestamp of this
			long thisTime = thisTimestamp.getTime();//convert to long
			
			if (thisTime > otherTime)//compare on basis of time
				return 1;
			else if (thisTime < otherTime)
				return -1;
			else
				return 0;
			
		//user wants to compare hits	
		} else if (option.equalsIgnoreCase("hits")) {//if option is hits
			int otherHits = o.getFormHits();//get hits of other
			
			int thisHits = this.getFormHits();//get hits of this
			
			if(thisHits > otherHits)//compare on basis of hits
				return 1;
			else if (thisHits < otherHits)
				return -1;
			else
				return 0;
		
		//user wants to compare bytes
		} else {//if option is bytes
			long otherBytes = o.getBytes();//get bytes of other
			
			long thisBytes = this.getBytes();//get bytes of this
			
			if (thisBytes > otherBytes)//compare on basis of bytes
				return 1;
			else if (thisBytes < otherBytes)
				return -1;
			else
				return 0;
		}
	}
	
	//determines if an object is equal to another
	/**
	 * @param object - compare an object
	 */
	public boolean equals(Object o) {
		FormEntry other = (FormEntry) o;//cast object to FormEntry object
		String otherFormName = other.getForm();//get others form
		String thisFormName = this.getForm();//get this objects form
		
		if (thisFormName.equalsIgnoreCase(otherFormName))//compare form names (types); .php
			return true;
		else
			return false;
	}
	
	//get the total form entry objects hits (that is of all the objects created using
	//form entry)
	/**
	 * @return int - return forms total number of hits
	 */
	public static int getStaticHits() {
		return staticHits; //return static hits
	}
	
	//gets the form entry objects hits
	/**
	 * @return int - return current form entry's number of hits
	 */
	public int getFormHits () {
		int count = 0;//default count variable
		String formName = this.getForm();//get this form entries form name
		for(int i=0; i<formArray.size(); i++)//iterate through static array list
			if (formArray.get(i).equalsIgnoreCase(formName))//if the array list objects equals the form name
				count++;//increase count
		return count;
	}
	
	//depending on the type of form entry, we return different html information
	public abstract String formatFormEntry();
}