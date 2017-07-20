import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The AnagramGroup class is a template for an ADT grouping of unique anagrams, 
 * where a group of words are anagrams if each can be obtained from the others 
 * by simply reordering the letters. For example post, stop, tops, and spot form 
 * a group of anagrams. 
 * @author mike
 */
public class AnagramGroup implements Comparable<AnagramGroup> {
	private String sorted;
	private ArrayList<String> group;
	public  static int count = 0;
	
	/**
	 * Constructs an empty AnagramGroup object that initializes the instance 
	 * variables sorted and group.
	 */
	public AnagramGroup() {
		sorted = null; //initialize sorted to null
		group = new ArrayList<String>(); //initialize group to an empty array list
	}
	
	/**
	 * Constructs an AnagramGroup object containing one word that initializes 
	 * the instance variables sorted to a sorted version of that word and adds 
	 * that word to this grouping.
	 */
	public AnagramGroup(String inSorted) {
		sorted = inSorted; //initialize sorted to a sorted version of the character array
		group = new ArrayList<String>(); //initialize group to an empty array list
	}
	
	/**
	 * Adds a unique word to this AnagramGroup.
	 * @param word element to be added to the this AnagramGroup
	 */
	public void add(String word) {
		word = word.toLowerCase(); //change the word to lower case
		if (sorted == null) { //check if sorted is initialized
			char[] charArray = word.toCharArray(); //make the word into a character array
			Arrays.sort(charArray); //sort the character array
			sorted = new String(charArray);
		}
		
		if (!group.contains(word))  {//checks if this AnagramGroup group contains the word
			group.add(word);
			Collections.sort(group); //sorts this AnagramGroup's group
		}
	}
	
	/**
	 * Returns the number of elements in this AnagramGroup.
	 * @return int number of elements in this AnagramGroup
	 */
	public int getSize() {
		return group.size(); //size of group array list
	}
	
	/**
	 * Indicates whether some other AnagramGroup is "equal to" this one.
	 * @param ag element that determines equivalence
	 * @return boolean whether or not this AnagramGroup is "equal to" some other AnagramGroup
	 */
	public boolean equals(AnagramGroup ag) {
		return sorted == ag.sorted; //determines if two AnagramGroups are equal to one another
	}
	
	/**
	 * Returns a negative integer, zero, or a positive integer as AnagramGroup 
	 * object is less than, equal to, or greater than the specified AnagramGroup 
	 * object argument.
	 * @param ag element thats being compared
	 * @return int representation of whether or not this AnagramGroup is less than,
	 * equal to, or greater than the specified AnagramGroup object argument
	 */
	@Override public int compareTo(AnagramGroup ag) {
		if (sorted.compareTo(ag.sorted) > 0) //if this AnagramGroup is greater
			return 1;
		else if (sorted.compareTo(ag.sorted) < 0) //if this anagramGroup is less than
			return -1;
		return 0; //if both AnagramGroup's are equal
	}
	
	/**
	 * Returns a string representation of this AnagramGroup.
	 * @return String representation of this AnagramGroup
	 */
	 public String toString() {
		 String str = "";
		 if (getSize() >= 2) {
			 count++;
			 str = "Group " + count + "\n     ";
			 for (String s : group)
				 str += s + " ";
			 str += "\n";
			 return str;
		 }
		 return str;
	 }
	
	/*
	 * *****************
	 * *AUTHOR COMMENTS*
	 * *****************
	 * From a design perspective it would be more elegant code to not limit the 
	 * toString() method, alternatively toString() could look like this:
	 
	   public String toString() {
	 		String str = "";
	 		for (String s : group)
	 			str += s + " ";
	 		return str;
	   }
	   
	 * This would then incorporate the need for a Stack<T> Class to be used in 
	 * the BST class and Driver.
	 * 
	 * ***Talked to professor Nord and he confirmed that either way would be acceptable, 
	 * just that the currently listed way was easier.***
	 */
	 
}