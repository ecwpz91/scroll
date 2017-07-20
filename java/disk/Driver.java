import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Driver application creates a DirectFile object containing a simulated Disk in order to read and seach for
 * records of a database using hashing.
 * @author mike surbey
 */
public class Driver {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in); //enables user input
		boolean exit = false; //determines if user wants to quit
		String response = ""; //user responses
		char[] record = new char[60]; //size of records
		boolean inserted = false; //whether or not a record is inserted
		boolean found = false; //whether or not a record is found
		
		Disk d = new Disk(2000, 512); //constructs Disk object
		DirectFile df = new DirectFile(d, 60, 27, 1024, 600); //constructs DirectFile object
		
        try {
            Scanner inFile = new Scanner(new File("mountains.txt")); //opens file
            while (inFile.hasNextLine()) {
            	String line = inFile.nextLine();
        		record = formatString(line);
        		df.insertRecord(record); //inserts record constructed from the line into the
        		//DirectFile object
            }
            inFile.close(); //closes file
            System.out.println("File contents successfully loaded.\n");
            
        } catch (FileNotFoundException e) {
        	System.err.println("Error, could not find file.");
        }
        
        while (!exit) {
        	menu(); //prompts main menu
        	response = scan.nextLine();
        	if (response.equalsIgnoreCase("i") || 
        			response.equalsIgnoreCase("insert")) {
        		record = subMenu(); //prompts the sub-menu and stores the result in record
        		
        		inserted = df.insertRecord(record); //determines if the record was inserted or not
        		if(inserted)
        			System.out.println("Record was successfully inserted.");
        		else
        			System.out.println("Sorry, but that record " +
        					"was not inserted becuase it already exists.");
        		
        	} else if (response.equalsIgnoreCase("f") || 
        			response.equalsIgnoreCase("find")) {
        		
        		System.out.print("Search for: ");
        		response = scan.nextLine(); //prompts the sub-menu and stores the result in record
        		System.out.println();
        		
        		record = formatString(response +"##"); //convert the string into character array
        		
        		found = df.findRecord(record); //determines if the record was found or not
        		if (found)
        			System.out.println(printRecord(record)); //prints the formatted record
        		else
        			System.out.println("Sorry, but that record does not exist.");
        		
        	} else if (response.equalsIgnoreCase("q") || 
        			response.equalsIgnoreCase("quit")) //exits the program
        		exit = true;
        	
        	System.out.println(); //makes main menu display "nicely"
        }
	}
	
	/**
	 * Prompts a main menu for the the user to select options from.
	 */
	public static void menu() {
		//makes menu border
		for (int r=0; r<3; r++) {
			if (r==1)
				System.out.print("*Direct Access File Program*");
			for (int c=0; c<28; c++)
				if (r != 1)
					System.out.print("*");
			System.out.println();
		}
		
		System.out.println("(I)nsert new record");
		System.out.println("(F)ind record");
		System.out.println("(Q)uit\n");
	    System.out.print("What would you like to do? ");
	}
	
	/**
	 * Prompts a sub-menu for the user to search or insert records for.
	 * @return char array of users input
	 */
	public static char[] subMenu() {
		Scanner scan = new Scanner(System.in);
		String userInput;
		
		//ask the user for mountain name, country and altitude
		System.out.print("Mountain Name: ");
		userInput = scan.nextLine() + "#";
		System.out.print("Country: ");
		userInput += scan.nextLine() + "#";
		System.out.print("Altitude: ");
		userInput += scan.nextLine();
		System.out.println();
		
		return formatString(userInput);
	}
	
	/**
	 * Formats the record with the proper format in order to insert or search for.
	 * @param record to be converted into a char array containing null characters
	 * @return char array of record that has been passed as a parameter
	 */
	public static char[] formatString(String record) {
		String name = record.substring(0, record.indexOf("#"));
		String country = record.substring(record.indexOf("#")+1, record.lastIndexOf("#"));
		String altitude = record.substring(record.lastIndexOf("#")+1);
		
		//adds null characters
		for (int i=name.length(); i<27; i++)
			name += "\000";
		name = name.substring(0,27);
		
		for (int i=country.length(); i<27; i++)
			country += "\000";
		country = country.substring(0,27);
		
		for (int i=altitude.length(); i<6; i++)
			altitude += "\000";
		altitude = altitude.substring(0,6);
		
		record = name + country + altitude; //concatenate the record
	
		return record.toCharArray();
	}
	
	/**
	 * Formats a character record to output: "mountain name", "country", altitude: "#" ft.
	 * @param record character array
	 * @return String representation of a record formatted accordingly
	 */
	public static String printRecord(char[] record) {
		String str = new String(record); //turn character array into a string
		//make substrings of record and remove nulls
		String name = str.substring(0, 26).replaceAll("\000", "");
		String country = str.substring(27, 53).replaceAll("\000", "");
		String altitude = str.substring(54, 60).replaceAll("\000", "");
		
		//concatenate record into string representation
		str = name + ", " + country + ", " + "altitude: " + altitude + " ft.";
		
		return str;
	}
}