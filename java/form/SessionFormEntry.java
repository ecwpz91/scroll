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
 * 
 * -------------------------------------------------------------------------------
 * Psedocode:
 *
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/

import java.util.ArrayList;

/**
 * @author mikesurbey
 *
 */
public class SessionFormEntry extends FormEntry {

	//session entry constructor
	/**
	 * @param timeStamp - timestamp of log entry (string)
	 * @param formType - formName of log entry (string)
	 * @param nameValue - name = value pairs of log entry (string)
	 * @param byteString - bytes of log entry (string)
	 * @param statusCode - status code of log entry (string)
	 */
	public SessionFormEntry (String timeStamp, String formType, String nameValue, 
			String byteString, String statusCode) {
		
		super.updateFormEntry(timeStamp, formType, nameValue, byteString, statusCode);
		
	}
	
	//keeps track of user names
	/**
	 * @return ArrayList<String> - returns an array list of user names for the session object 
	 */
	private ArrayList<String> getUserNames() {
		//gets "upper" classes name value pairs
		ArrayList<?> superList = (ArrayList<?>) super.getNameValuePairs();
		ArrayList<String> uNList = new ArrayList<String>();
		String username;
		//determines what user names to add to uNList array list
		for (int i=0; i<superList.size(); i++)
			if (((String) superList.get(i)).contains("username=")) {
				String superString = (String) superList.get(i);
				int equals = superString.indexOf("=");
				//concats the elements into an arrray list
				username = superString.substring(equals+1);
				if (!uNList.contains(username))
						uNList.add(username);
			}
		return uNList;
	}
	
	//method to format name value pairs, in order to simply the formatFormEntry method
	/**
	 * @return String - facilitates printing of name value pairs
	 */
	private String formattedNameValuePairs () {
		//gets "upper" classes name value pairs
		ArrayList<?> superList = (ArrayList<?>) super.getNameValuePairs();
		String formattedNV = "";
		//concats the elements in superList to enable printing
		for (int i=0; i<superList.size(); i++) {
			String superString = (String) superList.get(i);
			formattedNV = formattedNV.concat(superString + "\n<BR>\n");
			
		}
		return formattedNV;
	}
	
	//method to format user names, in order to simply the formatFormEntry method
	/**
	 * @return String - facilitates printing of user name pairs
	 */
	private String formattedUserNames () {
		ArrayList<String> userList = this.getUserNames();
		String formattedUN = "";
		for (int i=0; i<userList.size(); i++) {
			String userString = userList.get(i);
			formattedUN = formattedUN.concat(userString + "\n<BR>\n");
		}
		return formattedUN;
	}
	
	//returns a formattedFormEntry, used to built html file
	/**
	 * @return String - string of formatted SessionFormEntry object
	 */
	public String formatFormEntry () {
		String formType = super.getForm();
		int formHits = super.getFormHits();
		String formattedFormEntry = "<tr>\n<td>\n" + formType +"\n</td>\n<td>\n" + formHits + "\n</td>\n<td>\n" 
		+ this.formattedNameValuePairs() + "</td>\n<td>\n" + this.formattedUserNames() + "</td>\n</tr>\n";
		
		return formattedFormEntry;
	}
	
}