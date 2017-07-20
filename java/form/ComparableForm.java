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
 * Overrides compareTo to take in a string option (user selected)
 * -------------------------------------------------------------------------------
 * Psedocode:
 *
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/
/** 
 * @author mikesurbey
 * interface
 */
public interface ComparableForm extends Comparable<Object> {
	
	/**
	 * override compare to, to accept a string option
	 * @param option - user selected option
	 * @param form - FormEntry object
	 * @return int
	 */
	public int compareTo(String option, FormEntry form); 

}