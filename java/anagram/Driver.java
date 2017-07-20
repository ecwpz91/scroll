import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mike
 */
public class Driver {
	public static void main(String[] args) {
		BST<AnagramGroup> tree = null;
		AnagramGroup ag;
		String sorted;
		
        try {
            Scanner inFile = new Scanner(new File(args[0]));
            while (inFile.hasNext()) {
                String line = inFile.next(); //makes the line in the file into a String
                line = lineChecker(line); //checks the line
                
				if (line != null) {
					sorted = sort(line); //sort the line
					ag = new AnagramGroup(sorted); //create an anagram group
					if (tree == null) {
						ag.add(line); //add the line to the anagram group
						tree = new BST<AnagramGroup>(ag); //add the anagram group to the BST
					} else if (tree.search(ag) == null) { //the tree dose not contain this AG 
						//object
							ag.add(line);
							tree.insert(ag);
					} else //the tree does contain this AG object
							tree.search(ag).add(line); //add the line to the AG object contained
					//in the tree node
				}
            }
            inFile.close(); //close the file
            tree.inorder(); //call an inorder traversal on BST
            
        	/*
        	 * ***************************
        	 * *SEE AnagramGroup COMMENTS*
        	 * ***************************
               Stack<AngramGroup> treeStk = tree.inorder(); //traverse the tree in order and
               //store results into treeStk
               for (AnagramGroup agStk : treeStk)
              	 	if (agStk.getSize() >= 2) {
            			count++; //local count variable
            			System.out.println("Group " + count + "\n     " + agStk);
            		}
        	 */
            		
        } catch (FileNotFoundException e) {
        	System.err.println("Error, could not find file.");
        }
    }
	
	/**
	 * Checks that the incoming line in order to validate that it can be an anagram.
	 * @param str line being checked
	 * @return the original string or null depending on whether or not the string was valids
	 */
	private static String lineChecker(String str) {
		str = str.trim(); //eliminate trailing whitespace
		char first = str.toLowerCase().charAt(0); //get the first character
		char last = str.toLowerCase().charAt(str.length()-1); //get the last character
		
		String regex = "[^a-zA-Z]"; //regular expression to compare against the incoming line
		Pattern p = Pattern.compile(regex); //regex pattern
		Matcher m = p.matcher(str); //match the pattern to the line 
		if(m.find()) { //the regular expression was found
			if (!(first >= 'a' && first <= 'z'))
				str = str.substring(1, str.length()); //makes the substring get rid of periods
			//quotations, ect: to be able to make a anagram
			else if (!(last >= 'a' && last <= 'z')) { //makes the substring get rid of periods
				//quotations, ect: to be able to make a anagram
				str = str.substring(0, str.length()-1);
			} else
				str = null;
		}
		return str;
	}
	
	/**
	 * Sorts the incoming line into an ordered string representation of the array.
	 * @param str line being sorted
	 * @return a sorted repsresentation of the orginial string
	 */
	private static String sort(String str) {
		char[] charArray = str.toLowerCase().toCharArray(); //make the word into a character array
		Arrays.sort(charArray); //sort the character array
		return new String(charArray);
	}
}