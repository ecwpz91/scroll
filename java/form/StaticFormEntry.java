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
 */
public class StaticFormEntry extends FormEntry {

	//static form entry constructor
	/**
	 * @param timeStamp - timestamp of log entry (string)
	 * @param formType - formName of log entry (string)
	 * @param nameValue - name = value pairs of log entry (string)
	 * @param byteString - bytes of log entry (string)
	 * @param statusCode - status code of log entry (string)
	 */
	public StaticFormEntry (String timeStamp, String formType, String nameValue, 
			String byteString, String statusCode) {
		
		super.updateFormEntry(timeStamp, formType, nameValue, byteString, statusCode);

	}
	
	//method to format status codes, in order to simplify the formatFormEntry method
	/**
	 * @return String - status codes (facilitates printing)
	 */
	private String formattedStatusCodes () {
		//gets the "upper" classes status codes
		ArrayList<?> superList = (ArrayList<?>) super.getStatusCodes();
		String formattedSC = "";
		//concats them to a string in order to facilitate printing
		for (int i=0; i<superList.size(); i++) {
			String superString = (String) superList.get(i);
			formattedSC = formattedSC.concat(superString + "\n<BR>\n");
			
		}
		return formattedSC;
	}
	
	//method to format name value pairs, in order to simplify the formatFormEntry method
	/**
	 * @return String - name value paris (facilitates printing)
	 */
	private String formattedNameValuePairs () {
		//gets the "upper" classes variables name value pairs
		ArrayList<?> superList = (ArrayList<?>) super.getNameValuePairs();
		String formattedNV = "";
		for (int i=0; i<superList.size(); i++) {
			//concats the elements in order to facilitate printing
			String superString = (String) superList.get(i);
			formattedNV = formattedNV.concat(superString + "\n<BR>\n");
			
		}
		return formattedNV;
	}
	
	//returns a formattedFormEntry, used to built html file
	/**
	 * @return String - string of formatted SessionFormEntry object
	 */
	public String formatFormEntry () {
		String formType = super.getForm();
		int formHits = super.getFormHits();
		String formattedFormEntry = "<tr>\n<td>\n" + formType +"\n</td>\n<td>\n" + formHits + "\n</td>\n<td>\n" 
		+ this.formattedNameValuePairs() + "</td>\n<td>\n" + this.formattedStatusCodes() + "</td>\n</tr>\n";
		
		return formattedFormEntry;
	}
	
}