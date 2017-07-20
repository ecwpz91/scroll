import java.util.Scanner;

/**
 * Displays the user interactive menu, in order to use the Grid class.
 * @author msurbey
 * @version 1.0
 */
public class Driver {
	public static void main(String[] args) {
		Grid g = new Grid();//instantiate the grid object
		
		Scanner scan = new Scanner(System.in); //initialize scanner (user input)
		
		mainMenu(); //print main menu
		String option = scan.next(); //get users input
		
		while (!option.equals("q")) {
			if (option.equalsIgnoreCase("dis")) { //display grid
					g.display();
			} else if (option.equalsIgnoreCase("as")) { //change an idividual cell
				System.out.print("Row: ");
				String row = scan.next();
				System.out.print("Column: ");
				String col = scan.next();
				scan.nextLine();
				System.out.print("Value (A \" before an entry specifies a String object): ");
				String value = scan.nextLine(); //makes it possible for value to have a space
				g.assignCell(row, col, value);
			} else if (option.equalsIgnoreCase("f")) { //fill a block of cells in the Grid object
				System.out.print("From row: ");
				String sRow = scan.next();
				System.out.print("From column: ");
				String sColumn = scan.next();
				System.out.print("To row: ");
				String eRow = scan.next();
				System.out.print("To column: ");
				String eColumn = scan.next();
				scan.nextLine();
				System.out.print("Value (A \" before an entry specifies a String object): ");
				String value = scan.nextLine();
				g.fill(sRow, sColumn, eRow, eColumn, value);
			} else if (option.equalsIgnoreCase("n")) { //number the Grid object's cells
				System.out.print("From row: ");
				String startRow = scan.next();
				System.out.print("From column: ");
				String startColumn = scan.next();
				System.out.print("To row: ");
				String endRow = scan.next();
				System.out.print("To column: ");
				String endColumn = scan.next();
				g.number(startRow, startColumn, endRow, endColumn);
			} else if (option.equalsIgnoreCase("a")) { //add two cells
				String[] operations = operationsPrompt();
				g.add(operations);
			} else if (option.equalsIgnoreCase("s")) { //subtract two cells
				String[] operations = operationsPrompt();
				g.subtract(operations);
			} else if (option.equalsIgnoreCase("m")) { //multiply two cells
				String[] operations = operationsPrompt();
				g.multiply(operations);
			} else if (option.equalsIgnoreCase("d")){ //divide two cells
				String[] operations = operationsPrompt();
				g.divide(operations);
			} else if (option.equalsIgnoreCase("ar")) { //add two rows
				String[] operations = rowOperationsPrompt();
				g.addRow(operations);
			} else if (option.equalsIgnoreCase("sr")) { //subtract two row
				String[] operations = rowOperationsPrompt();
				g.subtractRows(operations);
			} else if (option.equalsIgnoreCase("mr")) { //multiply two rows
				String[] operations = rowOperationsPrompt();
				g.multiplyRows(operations);
			} else if (option.equalsIgnoreCase("dr")) { //divide two rows
				String[] operations = rowOperationsPrompt();
				g.divideRows(operations);
			}else if (option.equalsIgnoreCase("ac")) { //add two columns
				String[] operations = columnOperationsPrompt();
				g.addColumns(operations);
			}else if (option.equalsIgnoreCase("sc")) { //subtract two columns
				String[] operations = columnOperationsPrompt();
				g.subtractColumns(operations);
			}else if (option.equalsIgnoreCase("mc")) { //multiply two columns
				String[] operations = columnOperationsPrompt();
				g.multiplyColumns(operations);
			}else if (option.equalsIgnoreCase("dc")) { //divide two columns
				String[] operations = columnOperationsPrompt();
				g.divideColumns(operations);
			}else if (option.equalsIgnoreCase("ir")) { //insert a row
				System.out.print("Row: ");
				String insertRow = scan.next();
				g.insertRow(insertRow);
			}else if (option.equalsIgnoreCase("ic")) { //insert a column
				System.out.print("Column: ");
				String insertColumn = scan.next();
				g.insertColumn(insertColumn);
			}else if (option.equalsIgnoreCase("delr")) { //delete a row
				System.out.print("Row number: ");
				String deleteRow = scan.next();
				g.deleteRow(deleteRow);
			}else if (option.equalsIgnoreCase("delc")) { //delete a column
				System.out.print("Column number: ");
				String deleteColumn = scan.next();
				g.deleteColumn(deleteColumn);
			} else { //input check
				System.out.println("Sorry, that option does not exist. Please try another option. " +
						"Otherwise, press\nthe letter 'q' to quit.\n");
			}
			
			mainMenu(); //once operation is performed, if the option was not 'q' display menu
			option = scan.next(); //get users input
		}
		
	}
	
	/**
	 * Displays the main menu in the command prompt.
	 */
	public static void mainMenu() {
		//instantiate main menu operations and their shorthand commands
		String line0 = newMainMenuLine("display", "dis", "assign cell", "as");
		String line1 = newMainMenuLine("fill", "f", "number", "n");
		String line2 = newMainMenuLine("add cells", "a", "subtract cells", "s");
		String line3 = newMainMenuLine("multiply cells", "m", "divide cells", "d");
		String line4 = newMainMenuLine("add rows", "ar", "subtract rows", "sr");
		String line5 = newMainMenuLine("multiply rows", "mr", "divide rows", "dr");
		String line6 = newMainMenuLine("add columns", "ac", "subtract columns", "sc");
		String line7 = newMainMenuLine("multiply columns", "mc", "divide columns", "dc");
		String line8 = newMainMenuLine("insert row", "ir", "insert column", "ic");
		String line9 = newMainMenuLine("delete row", "delr", "delete column", "delc");
		String line10 = newMainMenuLine("quit", "q", "","");
		
		//prints out the main menu
		System.out.println("Operations");
		System.out.println(line0);
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		System.out.println(line4);
		System.out.println(line5);
		System.out.println(line6);
		System.out.println(line7);
		System.out.println(line8);
		System.out.println(line9);
		System.out.println(line10);
		System.out.print("--> ");
	}
	
	/**
	 * Returns a standardized line of two string operations and their shorthand commands.
	 * @param op1 - the line's first operation.
	 * @param sh1 - the first operation's (op1) corresponding shorthand command.
	 * @param op2 - the line's second operation.
	 * @param sh2 - the second operation's (op2) corresponding shorthand command.
	 * @return a standardized string representation of the line.
	 */
	public static String newMainMenuLine(String op1, String sh1, String op2, String sh2) {
		String line = "   " + op1; //initialize line and add three spaces to operation1 (op1)
		int count = line.length(); //initialize count to line's length
		
		for (int i=count; i<21; i++) //append spaces to line
			line = line.concat(" ");
		line = line.concat(sh1); //append op1's shorthand (sh1) to line
		count = line.length(); //change count to line's current length
		for(int i=count; i<35; i++)
			line = line.concat(" "); //append spaces to line
		line = line.concat(op2); //append operation2 (op2) to line
		count = line.length(); //change count to line's current length
		for(int i=count; i<53; i++)
			line = line.concat(" "); //append spaces to line
		line = line.concat(sh2); //append op2's shorthand (sh2) to line
		
		return line; //return a line of two operations and their shorthands with standardized
		//line spacing
	}
	
	/**
	 * Prompt used for doing arithmetic with individual cells.
	 * @return String array - inputs from the user
	 */
	public static String[] operationsPrompt() {
		Scanner scan = new Scanner(System.in);
		String[] ops = new String[6];
		
		System.out.print("First node row: ");
		String firstNodeRow = scan.next();
		ops[0] = firstNodeRow;
		System.out.print("First node column: ");
		String firstNodeColumn = scan.next();
		ops[1] = firstNodeColumn;
		System.out.print("Second node row: ");
		String secondNodeRow = scan.next();
		ops[2] = secondNodeRow;
		System.out.print("Second node column: ");
		String secondNodeColumn = scan.next();
		ops[3] = secondNodeColumn;
		System.out.print("Destination node row: ");
		String destinationRow = scan.next();
		ops[4] = destinationRow;
		System.out.print("Destination node column: ");
		String destinationColumn = scan.next();
		ops[5] = destinationColumn;
		
		return ops;
	}
	
	/**
	 * Prompt used for doing arithmetic with rows.
	 * @return String array - inputs from the user
	 */
	public static String[] rowOperationsPrompt() {
		Scanner scan = new Scanner(System.in);
		String[] ops = new String[3];
		
		System.out.print("First row: ");
		String firstRow = scan.next();
		ops[0] = firstRow;
		System.out.print("Second row: ");
		String secondRow = scan.next();
		ops[1] = secondRow;
		System.out.print("Target row: ");
		String targetRow = scan.next();
		ops[2] = targetRow;
		
		return ops;
	}
	
	/**
	 * Prompt used for doing arithmetic with columns.
	 * @return String array - inputs from the user
	 */
	public static String[] columnOperationsPrompt() {
		Scanner scan = new Scanner(System.in);
		String[] ops = new String[3];
		
		System.out.print("First column: ");
		String firstCol = scan.next();
		ops[0] = firstCol;
		System.out.print("Second column: ");
		String secondCol = scan.next();
		ops[1] = secondCol;
		System.out.print("Target column: ");
		String targetCol = scan.next();
		ops[2] = targetCol;
		
		return ops;
	}
}