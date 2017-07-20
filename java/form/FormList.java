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
 * formatHTMLFile was not completed
 * -------------------------------------------------------------------------------
 * Psedocode:
 *
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/
import java.util.*;
import java.io.*;

/**
 * @author mikesurbey
 */
@SuppressWarnings("serial")
public class FormList extends ArrayList<Object> {
	
	//find the max time of form entries
	/**
	 * @return FormEntry object
	 */
	private FormEntry findMaxTime () {
		//gets the first index of the array list,
		//used for something to compare to
		FormEntry form = (FormEntry) this.get(0);
		ArrayList<FormEntry> maxArray = new ArrayList<FormEntry>();
		maxArray.add(form);
		for (int i =0; i<this.size(); i++) {
			//determines if the current this (list's) value is greater
			//or less than the object in maxArray
			FormEntry otherForm = (FormEntry) this.get(i);
			if (otherForm.compareTo("date",form) == 1) {
				maxArray.remove(0);
				maxArray.add(otherForm);
				form = (FormEntry) this.get(i);
			}
		}
		FormEntry max = maxArray.get(0);
		return max;
	}
	
	//find max hits of form entries
	/**
	 * @return FormEntry object
	 */
	private FormEntry findMaxHits () {
		//gets the first index of the array list,
		//used for something to compare to
		FormEntry form = (FormEntry) this.get(0);
		ArrayList<FormEntry> maxArray = new ArrayList<FormEntry>();
		maxArray.add(form);
		for (int i =0; i<this.size(); i++) {
			FormEntry otherForm = (FormEntry) this.get(i);
			//determines if the current this (list's) value is greater
			//or less than the object in maxArray
			if (otherForm.compareTo("hits",form) == 1) {
				maxArray.remove(0);
				maxArray.add(otherForm);
				form = (FormEntry) this.get(i);
			}
		}
		FormEntry max = maxArray.get(0);
		return max;
	}
	
	//find max bytes of form entries
	/**
	 * @return FormEntry object
	 */
	private FormEntry findMaxBytes () {
		//gets the first index of the array list,
		//used for something to compare to
		FormEntry form = (FormEntry) this.get(0);
		ArrayList<FormEntry> maxArray = new ArrayList<FormEntry>();
		maxArray.add(form);
		for (int i =0; i<this.size(); i++) {
			FormEntry otherForm = (FormEntry) this.get(i);
			//determines if the current this (list's) value is greater
			//or less than the object in maxArray
			if (otherForm.compareTo("bytes",form) == 1) {
				maxArray.remove(0);
				maxArray.add(otherForm);
				form = (FormEntry) this.get(i);
			}
		}
		FormEntry max = maxArray.get(0);
		return max;
	}
	
	//sort the form entries depending on "users" option
	/**
	 * @param option - user selected optino to sort by
	 */
	public void sortByOption (String option) {
		//determine the option the user selects
		if (option.equalsIgnoreCase("date")) {
			//create a temp array list in order to store the removed items from array list (this)
			ArrayList<FormEntry> temp = new ArrayList<FormEntry>();
			FormEntry maxTime;
			while (this.size()!=0) {
				for (int i=0; i<this.size(); i++) {
					//use findMaxTime to determine the form with the newest time stamp 
					//in array list (this)
					maxTime = this.findMaxTime();
					FormEntry form = (FormEntry) this.get(i);
					//if the current array list = max time, add to temp list and remove from
					//array list (this)
					if (form.equals(maxTime)) {
						temp.add(form);
						this.remove(form);
					}
				}
			}
			
			//adds the objects back into array list (this), in order
			for (int i=0; i<temp.size(); i++)
				this.add(temp.get(i));
			
		} else if (option.equalsIgnoreCase("hits")) {
			//create a temp array list in order to store the removed items from array list (this)
			ArrayList<FormEntry> temp = new ArrayList<FormEntry>();
			FormEntry maxHits;
			while (this.size()!=0) {
				for (int i=0; i<this.size(); i++) {
					//use findMaxHits to determine the form with most hits in array list (this)
					maxHits = this.findMaxHits();
					FormEntry form = (FormEntry) this.get(i);
					//if the current array list = max time, add to temp list and remove from
					//array list (this)
					if (form.equals(maxHits)) {
						temp.add(form);
						this.remove(form);
					}
				}
			}
			
			//adds the objects back into array list (this), in order
			for (int i=0; i<temp.size(); i++)
				this.add(temp.get(i));
			
		} else if (option.equalsIgnoreCase("bytes")) {
			//create a temp array list in order to store the removed items from array list (this)
			ArrayList<FormEntry> temp = new ArrayList<FormEntry>();
			FormEntry maxBytes;
			while (this.size()!=0) {
				for (int i=0; i<this.size(); i++) {
					//use findMaxBytes to determine the form with the largest amount of
					//bytes in array list (this)
					maxBytes = this.findMaxBytes();
					FormEntry form = (FormEntry) this.get(i);
					//if the current array list = max time, add to temp list and remove from
					//array list (this)
					if (form.equals(maxBytes)) {
						temp.add(form);
						this.remove(form);
					}
				}
			}
			
			//adds the objects back into array list (this), in order
			for (int i=0; i<temp.size(); i++)
				this.add(temp.get(i));
			
		} else {
			//default if user does not pass an option
			ArrayList<FormEntry> temp = new ArrayList<FormEntry>();
			FormEntry maxTime;
			while (this.size()!=0) {
				for (int i=0; i<this.size(); i++) {
					maxTime = this.findMaxTime();
					FormEntry form = (FormEntry) this.get(i);//cast to form entry object
					if (form.equals(maxTime)) {
						temp.add(form);
						this.remove(form);
					}
				}
			}
			
			for (int i=0; i<temp.size(); i++)
				this.add(temp.get(i));
		}
	}
	
	//Build unformatted html file
	/**
	 * @param fileName - name of desired file to create
	 */
	public void buildHTMLFile (String fileName) {
		try {
			//creates a file (user selected) to build an unformatted html file
			FileOutputStream out = new FileOutputStream(fileName);
			PrintStream p = new PrintStream (out);
			
			//dynamic array lists so it is easy to add the objects to for later printing
			ArrayList<String> sessionList = new ArrayList<String>();
			ArrayList<String> staticList = new ArrayList<String>();
			
			//beginning of html file
			String sessionBeginningHTML = "<HTML>\n<HEAD>\n<TITLE>\nLog Summary\n</TITLE>\n</HEAD>\n<BODY>\n" +
			"<TABLE border=1>\n<TR>\n<TD>\n<STRONG>\nForm\n</STRONG>\n</TD>\n<TD>\n<STRONG>\nHits\n" +
			"</STRONG>\n</TD>\n<TD>\n<STRONG>\nForm Fields\n</STRONG>\n</TD>\n<TD>\n<STRONG>\nUsers\n" +
			"</STRONG>\n</TD>\n</TR>\n";
			
			//middle of html file (after session has been added)
			String staticBeginningHTML = "</TABLE>\n<BR>\n<TABLE border=1>\n<TR>\n<TD>\n<STRONG>\nForm\n" +
				"</STRONG>\n</TD>\n<TD>\n<STRONG>\nHits\n</STRONG>\n</TD>\n<TD>\n<STRONG>\nForm Fields\n" +
				"</STRONG>\n</TD>\n<TD>\n<STRONG>\nCodes\n</STRONG>\n</TD>\n</TR>\n";
			
			//ending of html file
			String endingHTML = "</TABLE>\n</BODY>\n</HTML>";
			
			//add strings to list (first index)
			sessionList.add(sessionBeginningHTML);
			staticList.add(staticBeginningHTML);
			
			//determine the instance of the array list (this) objects to add
			//to appropriate lists
			for (int i=0; i<this.size(); i++) {
				FormEntry form = (FormEntry) this.get(i);
				if (form instanceof SessionFormEntry)
					sessionList.add(form.formatFormEntry());
				else
					staticList.add(form.formatFormEntry());
				
			}
			
			//add ending html string to static list (end of html file)
			staticList.add(endingHTML);
			
			//print strings into user defined html file
			for (int i=0; i<sessionList.size(); i++)
				p.print(sessionList.get(i));
			
			for (int i=0; i< staticList.size(); i++)
				p.print(staticList.get(i));
			
		} catch (Exception e) {
			
			//if an error occurs
			System.err.println("Error, could not write file.");
			
		}
	}
	
	//format the htmlfile
	/**
	 * @param fileName - name of file name to format
	 */
	public void formatHTMLFile (String fileName) {
		
		try {
			 //read the builtHTMLFile
			BufferedReader inputFile = new BufferedReader (new FileReader(fileName));
			String line = null;
			
			//default variables
			Node root = null;
			Node curr = null;
			
			//read the html file
			while ((line=inputFile.readLine())!=null) {
				
				
				
				//if root is equal to node, set parent node
				if (root == null) {
					root = new Node(line);
					curr = root;
					
				//these cases, create a new node ==> shift current pointer to that node
				//add line elements
				} else if (line.startsWith("<") && line.endsWith(">") && !line.equalsIgnoreCase("<BR>") && !line.startsWith("</")) {
					
					curr = curr.addChild(line);
					
				//closing cases, get the parent class
				//work your way back through the tree
				} else if (line.startsWith("</") && line.endsWith(">")) {
					
					curr = curr.getParent();
						
				} else {
					
					curr.addChild(line);
					
				}
				
			}
			
			root.print();
			
		} catch (IOException e) {

			System.err.println("Error, could not find file.");
		
		}

	}

	//parse line (server log), determine if session or static form entry
	//add session or static object to array list (this - extended class);
	/**
	 * @param line - desired string to format (log entry)
	 */
	public void add (String line) {
		//Common String Values
		int questionMark = line.indexOf("?");
		int lastDoubleQuote = line.lastIndexOf('"');
		int lastSpace = line.lastIndexOf(" ");
		
		//Timestamp String
		String timeStamp;
		String timeStampBracketless;
		String timeStampSpaceless;
		int firstBracket = line.indexOf("[");
		int secondBracket = line.indexOf("]");
		timeStampBracketless = line.substring(firstBracket+1, secondBracket);
		int space = timeStampBracketless.indexOf(" ");
		timeStampSpaceless = timeStampBracketless.substring(0,space);
		timeStamp = timeStampSpaceless.replaceFirst(":", " ");

		//Form String 
		String formType;
		int lastForwardSlash = line.lastIndexOf("/");
		formType = line.substring(lastForwardSlash+1, questionMark);

		//Name-value String
		String nameValue;
		nameValue = line.substring(questionMark+1, lastDoubleQuote);

		//Bytes
		String byteString = line.substring(lastSpace+1);
		
		//Status code
		String statusCode;
		statusCode = line.substring(lastDoubleQuote+2, lastSpace);
		
		FormEntry fEntry = null;

		if (line.contains("sessionID=")) {
			//Session ID String
			String sessionIDAnd;
			int startSessionID = line.indexOf("sessionID=");
			int endSessionID = line.indexOf("&", startSessionID);
			sessionIDAnd = line.substring(startSessionID, endSessionID+1);
			
			//Remove sessionID
			nameValue = nameValue.replace(sessionIDAnd, "");

			fEntry = new SessionFormEntry (timeStamp, formType, nameValue, byteString, statusCode);
			
		} else { 
			
			fEntry = new StaticFormEntry (timeStamp, formType, nameValue, byteString, statusCode);
			
		}
		//determine if array list (this) is empty
		if (this.isEmpty())
			this.add(fEntry);
		else {
			for (int i=0; i<this.size(); i++) {
				//update objects existing in array list
				if (fEntry.equals(this.get(i))) {
					FormEntry form = (FormEntry) this.get(i);
					form.updateBytes(fEntry.getBytes());
					form.updateTime(fEntry.getTime());
					form.updateNV(fEntry.getNameValuePairs());
					form.updateStatusCodes(fEntry.getStatusCodes());
				} else
					//if the array list dosen't contain the object, add to array list
					if (!this.contains(fEntry))
						this.add(fEntry);
			}
		}
	}
	
}