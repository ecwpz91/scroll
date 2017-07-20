import java.util.Scanner;

/**
 * The Grid class is an object that creates a linked list of Nodes (cells) which
 * a user can use to perform arithmetic/store values in corresponding rows or columns.
 * @author msurbey
 * @version 1.0
 */

public class Grid {
	private Node head;
	private int numColumns = 6; //must always be greater than zero
	private int numRows = 10; //must always be greater than zero
	
	/**
	 * Constructs a newly allocated 10x5 (rows x columns) Grid object of linked Nodes.
	 */
	public Grid() {
		if (numRows <= 0 || numColumns <= 0)
			System.out.println("Check to make sure that numRows and numColumns are " +
					"initialized to a value greater than zero."); //validates the number of columns and then number or rows
		else {
			head = new Node(new Value()); //instantiates head to a new node
			Node curr = head; //creates a pointer to head
			//using the pointer we make head reference back to itself
			curr.setRight(head);
			curr.setDown(head);
			//instantiated default variables
			Node colHead = null;
			Node rowHead = null;
			Node mid = null;
			
			for (int r=1; r<=numRows; r++) {
				if(r > 1) {
					mid = curr; //used in the case of more than two rows to make the previous
					//curr pointer point down to the new curr poitner of the new row
					colHead = head; //used to make the last node point back up to the top of
					//its column
					curr.setDown(new Node(new Value())); //creates a new row
					curr = curr.getDown();
					curr.setDown(head);
					rowHead = curr; //used to make the right most node point back to the top 
					//of its row
				}
				for (int c=1; c<numColumns; c++) {
					if (r == 1) {
						curr.setRight(new Node(new Value()));
						curr = curr.getRight();
						curr.setRight(head);
						curr.setDown(curr);
					} else {
						colHead = colHead.getRight(); //moves colHead pointer to the right
						mid = mid.getRight(); //moves mid pointer to the right
						curr.setRight(new Node(new Value())); //create a new node to the right
						curr = curr.getRight(); //set curr pointer to the newly created node
						mid.setDown(curr);
						curr.setDown(colHead);
						curr.setRight(rowHead);	
					}
				}
				curr = curr.getRight(); //sets the curr pointer back to the top of the row
			}
		}
	}
	
	/**
	 * Used to search the grid for a specific Node.
	 * @param inRow - the row that the Node being searched for resides in.
	 * @param inCol - the column that the Node being searched for resides in.
	 * @return Node being searched for.
	 */
	private Node find(int inRow, int inCol) {
		if (head == null) //checks for null pointer error
			return null;
		Node found = head; //creates a pointer to the head
		
		for (int i=0; i<inRow; i++) {
			//if (i > 0)
			found = found.getDown(); //find the row in which the node resides
		}
		for (int i=0; i<inCol; i++)
			found = found.getRight(); //find the Node based on the current row
		return found;
	}
	
	/**
	 * Used to find the total number of Node's (distance) from an ending point (Node object) 
	 * in the Grid object continuing to a starting point (NOde object).
	 * @param sRow - desired starting row of the count.
	 * @param sCol - desired starting column of the count
	 * @param eRow - desired ending row of the count.
	 * @param eCol - desired ending column of the count.
	 * @return int of the distance between a starting and ending node
	 */
	private int endToStartCount(int sRow, int sCol, int eRow, int eCol) {
		if (head == null) //checks for null pointer error
			return 0;
		int count = 0; //initialize the count
		Node rowHead = head; 
		
		for (int i=0; i<eRow; i++)
			rowHead = rowHead.getDown();
		Node start = find(sRow, sCol); //find the starting Node
		Node end = find(eRow, eCol); //find the ending Node
		while (end != start) { //traverse the Grid object
			end = end.getRight();
			if (end == rowHead) {
				end = end.getDown();
				rowHead = end;
			}
			count++;
		}
		return count;
	}
	
	/**
	 * Displays the formatted Gird object to the command line (terminal).
	 */
	public void display() {
		Node curr = head; //uses a current pointer in order to space the 
		//Node's away from each other properly
		String currValue = ""; //String object of the curr Node's value
		Node prev; //used to get the node previous to the curr node
		String prevValue = ""; //initializes a String object of the previous 
		//Node's value
		String row = ""; //initializes the String object of the formatted row
		int prevValLen = 0; //initializes the String length count
		
		for (int r=0; r<numRows; r++) { //iterate through the grid rows			
			row = "row" + r; //set String of how many rows are in the Grid
			String spaces = "     ";
			int rowLen = row.length();
			//adjusts for rows headings that are longer than 4 characters
			if (rowLen > 4) {
				spaces = spaces.substring(0, rowLen-1);
			}

			//object
			for (int c=0; c<numColumns; c++) { //iterate through the grid columns
				if (r==0) {
					if (c == 0) //set String of how many columns are in the
						//Grid object
						System.out.print("         col" + c);
					else
						System.out.print("       " + "col" + c);
				}

				currValue = curr.getValue().toString(); //set the String of 
				//currValue = curr.toString();
				//the current Node object
				if (currValue.length() > 10) {
					currValue = currValue.substring(0,10); //makes sure the Strings
					//in the row are no longer than 10
					//currValue = currValue + " ";
				}
				
				if (c>0) { //corrects the spacing of the rows for printing to 
					//the terminal
					int prevColumn = c - 1;
					prev = find(r,prevColumn); //find the previous nodes value
					prevValue = prev.getValue().toString(); //set the String of the 
					//previous Node object Value
					prevValLen = prevValue.length(); //get the previous Node's Value 
					//object to determine spacing

					for (int i=prevValLen; i<=10; i++)
						currValue = " " + currValue; //add spaces the the current Node 
					//based on the previous Node's Value object's length
				}
				
				if (c == 0)
					row = row + spaces + currValue; //first columns String value
				//(selective row spacing)
				else
					row = row + currValue; //every other columns row spacing
				curr = curr.getRight(); //go to the next Node
			}
			if (r==0)
				System.out.println();
			System.out.println(row); //print the formatted row
			curr = curr.getDown(); //go to the next row of the Grid object
		}
		System.out.println(); //space the terminally printed Grid object from the
		//menu of options
	}

	/**
	 * Assigns a cell to specified Value object.
	 * @param inRow - row of the cell interested in being changed
	 * @param inCol - column of the cell interested in being changed
	 * @param inValue is the Value object that the Node's value object is being changed to.
	 */
	public void assignCell(String inRow, String inCol, String inValue) {
		int row; 
		int col;
		
		try { //validates input is an integer
			row = Integer.parseInt(inRow);
			col = Integer.parseInt(inCol);
		} catch (NumberFormatException nfe){
			row = 0;
			col = 0;
		}
		
		if ((row < 0 | row >= numRows) | (col < 0 | col >= numColumns))
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			try { //Catches a NumberFormatException if the input isn't appropriate
				Node curr = find(row, col); //finds the desired cell in the Grid
				curr.setValue(new Value(inValue)); //changes the cell's Value object
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid value entry, please try again.");
			}
		}
	}
	
/**
 * Fills cells with an assigned value.
 * @param fromRow - the starting cell's row
 * @param fromColumn - the starting cell's column
 * @param toRow - the ending cell's row
 * @param toColumn - the ending cell's column
 * @param inValue is the value that the cells designated will be changed to.
 */
	public void fill(String fromRow, String fromColumn, String toRow,
			String toColumn, String inValue) {
		int startRow;
		int startColumn;
		int endRow;
		int endColumn;
		
		try { //validates input is an integer
			startRow = Integer.parseInt(fromRow);
			startColumn = Integer.parseInt(fromColumn);
			endRow = Integer.parseInt(toRow);
			endColumn = Integer.parseInt(toColumn);
		} catch (NumberFormatException nfe){
			startRow = -1;
			startColumn = -1;
			endRow = -1;
			endColumn = -1;
		}
		
		if (((startRow < 0 | startRow >= numRows) | 
				(startColumn < 0 | startColumn >= numColumns)) | 
				((endRow < 0 | endRow >= numRows) | 
				(endColumn < 0 | endColumn >= numColumns)))
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			try {
				int rows = endRow - startRow; //determines whether or not the user is 
				//going forwards of backwards with their filling
				int cols = endColumn - startColumn;
				
				if (cols >= 0) {
					Node start = find(startRow, startColumn); //finds the starting node point
					Node rowHead = start; //used to indicate starting position of 
					//the row (in order to move down)
					for (int r=0; r<=rows; r++) {
						for (int c=0; c<=cols; c++) {
							start.setValue(new Value(inValue)); //changes the Node's value
							start = start.getRight(); //changes the Node to the next Node
						}
						while (start!=rowHead) { //goes back to the rowHead
							start = start.getRight();
						}
						start = start.getDown(); //goes to the next row
						rowHead = start; //sets the starting position of the row
					}
				} else {//is starting from a forwards position and heading backwards
					rows = startRow - endRow; //makes rows positive
					cols = startColumn - endColumn; //makes columns positive
					Node start = find(endRow, endColumn); //changes position of the 
					//starting point from the 
					//starting column & row to the ending column & row
					Node rowHead = start;
					for (int r=0; r<=rows; r++) {
						for (int c=0; c<=cols; c++) {
							start.setValue(new Value(inValue));
							start = start.getRight();
						}
						while (start!=rowHead) {
							start = start.getRight();
						}
						start = start.getDown();
						rowHead = start;
					}
					
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid value entry, please try again.");
			}
		}
	}
	
	/**
	 * Numbers the cell depending on their distances from one another starting at zero. 
	 * @param fromRow - the starting cell's row
	 * @param fromColumn - the starting cell's column
	 * @param toRow - the ending cell's row
	 * @param toColumn - the ending cell's column
	 */
	public void number(String fromRow, String fromColumn,
			String toRow, String toColumn) {
		int startRow;
		int startColumn;
		int endRow;
		int endColumn;
		
		try { //validates input is an integer
			startRow = Integer.parseInt(fromRow);
			startColumn = Integer.parseInt(fromColumn);
			endRow = Integer.parseInt(toRow);
			endColumn = Integer.parseInt(toColumn);
		} catch (NumberFormatException nfe){
			startRow = -1;
			startColumn = -1;
			endRow = -1;
			endColumn = -1;
		}
		
		if (((startRow < 0 | startRow >= numRows) |
				(startColumn < 0 | startColumn >= numColumns)) | 
				((endRow < 0 | endRow >= numRows) |
				(endColumn < 0 | endColumn >= numColumns)))
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			Node rowHead = head;
			Node start = null;
			Node end = null;
			int count = 0;
			int rowsApart = endRow - startRow; //checks the distance between 
			//the ending row and the starting row
			
			if (rowsApart >= 0) {
				for (int i=0; i<startRow; i++)
					rowHead = rowHead.getDown(); //changes the row head to match the 
				//start positions row
				start = find(startRow, startColumn); //gets the starting Node
				end = find(endRow, endColumn); //gets the ending Node
				while (!end.equals(start)) {
					start.setValue(new Value(""+count)); //sets the current start Node to the
					//new count value (incremented by 1)
					start = start.getRight(); //moves to the next row's next Node
					if (start == rowHead) {
						start = start.getDown(); //moves down a row
						rowHead = start; //changes the rowHead to the top of current row
					}
					count++; //increments the count so the Node's go up in value
				}
				end.setValue(new Value(""+count)); //sets the ending Node to the designated count
			} else { //same as previous (but reversed and uses endToStartCount())
				//gets how many nodes are in the grid
				count = endToStartCount(startRow, startColumn, endRow, endColumn);
				for (int i=0; i<endRow; i++)
					rowHead = rowHead.getDown();
				start = find(startRow, startColumn);
				end = find(endRow, endColumn);
				while (!end.equals(start)) {
					end.setValue(new Value(""+count));
					end = end.getRight();
					if (end == rowHead) {
						end = end.getDown();
						rowHead = end;
					}
					count--; //decrements the count so the Node's go down in value
				}
				end.setValue(new Value(""+count));
			}
		}
	}
	
	/**
	 * Changes a destination Node in the Gird object to the sum of two separate Nodes in the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void add(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		for (String i : ops) {
			try { //validate input as an integer
				Integer.parseInt(i);
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		//initialize searchable coordinates for the Grid
		int firstRow = Integer.parseInt(ops[0]);
		int firstColumn = Integer.parseInt(ops[1]);
		int secondRow = Integer.parseInt(ops[2]);
		int secondColumn = Integer.parseInt(ops[3]);
		int destinationRow = Integer.parseInt(ops[4]);
		int destinationColumn = Integer.parseInt(ops[5]);
		
		//check that the number is within range of the Grid
		if ((firstRow >= numRows | firstRow < 0) | (secondRow >= numRows | secondRow < 0) |
				(destinationRow >= numRows | destinationRow < 0) | (firstColumn >= numColumns | firstColumn < 0) |
				(secondColumn >= numColumns | secondColumn < 0) | (destinationColumn >= numColumns | destinationColumn < 0))
			isValid = false;
		
		if (isValid == false)
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			//find the Node's in the Grid
			Node firstNode = find(firstRow, firstColumn);
			Node secondNode = find(secondRow, secondColumn);
			Node destination = find(destinationRow, destinationColumn);
			
			//instantiate dummy value "sum"
			Value sum = firstNode.getValue().plus(secondNode.getValue());
			if (sum.getTag().equalsIgnoreCase("DBL")) {
				destination.setValue(sum); //set the destination Node to the sum of two Node objects
			}
		}
	}
	
	/**
	 * Changes a destination Node in the Gird object to the difference of two separate Nodes in the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void subtract(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		for (String i : ops) {
			try { //validate input as an integer
				Integer.parseInt(i);
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		//initialize searchable coordinates for the Grid
		int firstRow = Integer.parseInt(ops[0]);
		int firstColumn = Integer.parseInt(ops[1]);
		int secondRow = Integer.parseInt(ops[2]);
		int secondColumn = Integer.parseInt(ops[3]);
		int destinationRow = Integer.parseInt(ops[4]);
		int destinationColumn = Integer.parseInt(ops[5]);
		
		//check that the number is within range of the Grid
		if ((firstRow >= numRows | firstRow < 0) | (secondRow >= numRows | secondRow < 0) |
				(destinationRow >= numRows | destinationRow < 0) | (firstColumn >= numColumns | firstColumn < 0) |
				(secondColumn >= numColumns | secondColumn < 0) | (destinationColumn >= numColumns | destinationColumn < 0))
			isValid = false;
		
		if (isValid == false)
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			//find the Node's in the Grid
			Node firstNode = find(firstRow, firstColumn);
			Node secondNode = find(secondRow, secondColumn);
			Node destination = find(destinationRow, destinationColumn);
			
			//instantiate dummy value "difference"
			Value difference = firstNode.getValue().minus(secondNode.getValue());
			if (difference.getTag().equalsIgnoreCase("DBL")) {
				destination.setValue(difference); //set the destination Node 
				//to the difference of the two Node objects
			}
		}
	}
	
	/**
	 * Changes a destination Node in the Gird object to the multiplicate of two separate Nodes in the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void multiply(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		for (String i : ops) {
			try { //validate input as an integer
				Integer.parseInt(i);
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		//initialize searchable coordinates for the Grid
		int firstRow = Integer.parseInt(ops[0]);
		int firstColumn = Integer.parseInt(ops[1]);
		int secondRow = Integer.parseInt(ops[2]);
		int secondColumn = Integer.parseInt(ops[3]);
		int destinationRow = Integer.parseInt(ops[4]);
		int destinationColumn = Integer.parseInt(ops[5]);
		
		//check that the number is within range of the Grid
		if ((firstRow >= numRows | firstRow < 0) | (secondRow >= numRows | secondRow < 0) |
				(destinationRow >= numRows | destinationRow < 0) | (firstColumn >= numColumns | firstColumn < 0) |
				(secondColumn >= numColumns | secondColumn < 0) | (destinationColumn >= numColumns | destinationColumn < 0))
			isValid = false;
		
		if (isValid == false)
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			//find the Node's in the Grid
			Node firstNode = find(firstRow, firstColumn);
			Node secondNode = find(secondRow, secondColumn);
			Node destination = find(destinationRow, destinationColumn);
			
			//instantiate dummy value "multiplicate"
			Value multiplicate = firstNode.getValue().star(secondNode.getValue());
			if (multiplicate.getTag().equalsIgnoreCase("DBL")) {
				destination.setValue(multiplicate); //set the destination Node 
				//to the multiplicate of the two Node objects
			}
		}
	}
	
	/**
	 * Changes a destination Node in the Gird object to the ratio of two separate Nodes in the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void divide(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		for (String i : ops) {
			try { //validate input as an integer
				Integer.parseInt(i);
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		//initialize searchable coordinates for the Grid
		int firstRow = Integer.parseInt(ops[0]);
		int firstColumn = Integer.parseInt(ops[1]);
		int secondRow = Integer.parseInt(ops[2]);
		int secondColumn = Integer.parseInt(ops[3]);
		int destinationRow = Integer.parseInt(ops[4]);
		int destinationColumn = Integer.parseInt(ops[5]);
		
		//check that the number is within range of the Grid
		if ((firstRow >= numRows | firstRow < 0) | (secondRow >= numRows | secondRow < 0) |
				(destinationRow >= numRows | destinationRow < 0) | (firstColumn >= numColumns | firstColumn < 0) |
				(secondColumn >= numColumns | secondColumn < 0) | (destinationColumn >= numColumns | destinationColumn < 0))
			isValid = false;
		
		if (isValid == false)
			//Checks that the row or column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			//find the Node's in the Grid
			Node firstNode = find(firstRow, firstColumn);
			Node secondNode = find(secondRow, secondColumn);
			Node destination = find(destinationRow, destinationColumn);
			
			try {
				//instantiate dummy value "ratio"
				Value ratio = firstNode.getValue().slash(secondNode.getValue());
				if (ratio.getTag().equalsIgnoreCase("DBL")) //check for divide by zero
					destination.setValue(ratio); //set the destination Node to 
				//the ratio of the two Node objects
			} catch (ArithmeticException ae) {
				System.out.println("Can't divide by zero, please try again.");
			}
		}
	}
	
	/**
	 * Adds two rows together and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void addRow(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numRows) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the row is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first row's position
			int second = Integer.parseInt(ops[1]); //the second row's position
			int target = Integer.parseInt(ops[2]); //the target row's position
			
			for (int c=0; c<numColumns; c++) {
				Node firstRow = find(first, c); //get firstRow's node
				Node secondRow = find(second, c); //get the secondRow's Node
				Node targetRow = find(target, c); //get the targetRow's Node
				
				Value sum = firstRow.getValue().plus(secondRow.getValue()); //find the sum of 
				//the first and second row's nodes
				if (sum.getTag().equalsIgnoreCase("DBL"))
					//sum is set to the fristRow's value
					if (!secondRow.getValue().getTag().equalsIgnoreCase("INVALID"))
						targetRow.setValue(sum); //set the target's Node to 
						//the sum of the first and second row's Nodes
			}
		}
	}
	
	/**
	 * Subtracts two rows and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void subtractRows(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numRows) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the row is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first row's position
			int second = Integer.parseInt(ops[1]); //the second row's position
			int target = Integer.parseInt(ops[2]); //the target row's position
			
			for (int c=0; c<numColumns; c++) {
				Node firstRow = find(first, c); //get firstRow's node
				Node secondRow = find(second, c); //get the secondRow's Node
				Node targetRow = find(target, c); //get the targetRow's Node
				
				Value difference = firstRow.getValue().minus(secondRow.getValue()); //find the 
				//difference of the first and second row's nodes
				if (difference.getTag().equalsIgnoreCase("DBL"))
					//difference is set to the fristRow's value
					if (!secondRow.getValue().getTag().equalsIgnoreCase("INVALID"))
						targetRow.setValue(difference); //set the target's Node to 
				//the difference of the first and second row's Nodes
			}
		}
	}
	
	/**
	 * Multiplies two rows and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void multiplyRows(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numRows) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the row is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first row's position
			int second = Integer.parseInt(ops[1]); //the second row's position
			int target = Integer.parseInt(ops[2]); //the target row's position
			
			for (int c=0; c<numColumns; c++) {
				Node firstRow = find(first, c); //get firstRow's node
				Node secondRow = find(second, c); //get the secondRow's Node
				Node targetRow = find(target, c); //get the targetRow's Node
				
				Value multiplicate = firstRow.getValue().star(secondRow.getValue()); //find the 
				//multiplicate of the first and second row's nodes
				if (multiplicate.getTag().equalsIgnoreCase("DBL"))
					if (!secondRow.getValue().getTag().equalsIgnoreCase("INVALID")) //multiplicate is 
						//set to the fristRow's value
						targetRow.setValue(multiplicate); //set the target's Node to the multiplicate 
						//of the first and second row's Nodes
			}
		}
	}
	
	/**
	 * Divides two rows and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void divideRows(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numRows) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the row is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first row's position
			int second = Integer.parseInt(ops[1]); //the second row's position
			int target = Integer.parseInt(ops[2]); //the target row's position
			
			for (int c=0; c<numColumns; c++) {
				Node firstRow = find(first, c); //get firstRow's node
				Node secondRow = find(second, c); //get the secondRow's node
				Node targetRow = find(target, c); //get the targetRow's node
				
				try { //checks for zero division
					Value ratio = firstRow.getValue().slash(secondRow.getValue()); //find the 
					//ratio of the first and second row's nodes
					if (ratio.getTag().equalsIgnoreCase("DBL"))
						if (!secondRow.getValue().getTag().equalsIgnoreCase("INVALID")) //ratio is
							//set to the fristRow's value
							targetRow.setValue(ratio); //set the target's Node to the 
							//ratio of the first and second row's Nodes
				} catch (ArithmeticException ae) {
					System.out.println("Can't divide by zero, please check the value " +
							"at row: " + second + ", column: " + c +".");
				}
			}
		}
	}
	
	/**
	 * Adds two columns together and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void addColumns(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numColumns) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first column's position
			int second = Integer.parseInt(ops[1]); //the second column's position
			int target = Integer.parseInt(ops[2]); //the target column's position
			
			for (int r=0; r<numRows; r++) {
				Node firstColumn = find(r, first); //get the first Node (column)
				Node secondColumn = find(r, second); //get the second Node (column)
				Node targetColumn = find(r, target); //get the target Node (column)
				
				Value sum = firstColumn.getValue().plus(secondColumn.getValue()); //find the sum of 
				//the first and second column's Nodes
				if (sum.getTag().equalsIgnoreCase("DBL"))
					//sum is set to the firstColumn's value
					if (!secondColumn.getValue().getTag().equalsIgnoreCase("INVALID"))
						targetColumn.setValue(sum); //set the target's Node to 
						//the sum of the first and second column's Nodes
			}
		}
	}
	
	/**
	 * Subtracts two columns and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void subtractColumns(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numColumns) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first column's position
			int second = Integer.parseInt(ops[1]); //the second column's position
			int target = Integer.parseInt(ops[2]); //the target column's position
			
			for (int r=0; r<numRows; r++) {
				Node firstColumn = find(r, first); //get the first Node (column)
				Node secondColumn = find(r, second); //get the second Node (column)
				Node targetColumn = find(r, target); //get the target Node (column)
				
				Value difference = firstColumn.getValue().minus(secondColumn.getValue()); //find the difference of 
				//the first and second column's Nodes
				if (difference.getTag().equalsIgnoreCase("DBL"))
					//difference is set to the firstColumn's value
					if (!secondColumn.getValue().getTag().equalsIgnoreCase("INVALID"))
						targetColumn.setValue(difference); //set the target's Node to 
						//the difference of the first and second column's Nodes
			}
		}
	}
	
	/**
	 * Multiplies two columns and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */
	public void multiplyColumns(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numColumns) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first column's position
			int second = Integer.parseInt(ops[1]); //the second column's position
			int target = Integer.parseInt(ops[2]); //the target column's position
			
			for (int r=0; r<numRows; r++) {
				Node firstColumn = find(r, first); //get the first Node (column)
				Node secondColumn = find(r, second); //get the second Node (column)
				Node targetColumn = find(r, target); //get the target Node (column)
				
				Value multiplicate = firstColumn.getValue().star(secondColumn.getValue()); //find the 
				//multiplicate of the first and second column's Nodes
				if (multiplicate.getTag().equalsIgnoreCase("DBL"))
					if (!secondColumn.getValue().getTag().equalsIgnoreCase("INVALID")) //multiplicate is 
						//set to the firstColumn's value
						targetColumn.setValue(multiplicate); //set the target's Node to the multiplicate 
						//of the first and second column's Nodes
			}
		}
	}
	/**
	 * Divides two columns and then places the results in a targeted row inside the Grid.
	 * @param ops - is a String array of objects containing coordinates to Nodes within the Gird
	 */	
	public void divideColumns(String[] ops) {
		boolean isValid = true; //checks to see if the String's are valid inputs
		int test; //test variable
		for (String i : ops) {
			try { //validate input as an integer
				test = Integer.parseInt(i);
				if ((test >= numColumns) | (test < 0)) //check that
					//the number is within range of the Grid
					isValid = false;
			} catch (NumberFormatException nfe) {
				isValid = false;
			}
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row or column does not exist, please try again.");
		else {
			int first = Integer.parseInt(ops[0]); //the first column's position
			int second = Integer.parseInt(ops[1]); //the second column's position
			int target = Integer.parseInt(ops[2]); //the target column's position
			
			for (int r=0; r<numRows; r++) {
				Node firstColumn = find(r, first); //get the first Node (column)
				Node secondColumn = find(r, second); //get the second Node (column)
				Node targetColumn = find(r, target); //get the target Node (column)
				
				try { //checks for zero division
					Value ratio = firstColumn.getValue().slash(secondColumn.getValue()); //find the 
					//ratio of the first and second column's Nodes
					if (ratio.getTag().equalsIgnoreCase("DBL"))
						if (!secondColumn.getValue().getTag().equalsIgnoreCase("INVALID")) //ratio is
							//set to the firstColumn's value
							targetColumn.setValue(ratio); //set the target's Node to the 
							//ratio of the first and second column's Nodes
					
				} catch (ArithmeticException ae) {
					System.out.println("Can't divide by zero, please check the value " +
							"at column: " + second + ", row: " + r +".");
				}
			}
		}
	}
	
	/**
	 * Inserts a row after a row specified.
	 * @param row - the row before the insertion
	 */
	public void insertRow (String row) {
		int test;
		boolean isValid = true;
		try { //validate input as an integer
			test = Integer.parseInt(row);
			if ((test >= numRows) | (test < 0)) //check that
				//the number is within range of the Grid
				isValid = false;
		} catch (NumberFormatException nfe) {
			isValid = false;
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row does not exist, please try again.");
		else {
			numRows++; //increment the number of rows in the Gird object
			int startRow = Integer.parseInt(row);
			Scanner scan = new Scanner(System.in);
			System.out.print("(B)efore or (a)fter? ");
			String answer = scan.next();
			if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("before"))
					startRow = startRow - 1;
			
			if (startRow < 0) {
				Node origin = head; //sets the original Grid
				Node prev = origin; //initialize pointer to first row & column of origin
				Node last = origin; //Initialize the pointer to the last column of origin
				while (last.getDown() != origin)
					last = last.getDown();
				head = new Node(new Value()); //create new head
				Node curr = head; //Initialize current pointer
				
				for (int c=0; c<numColumns; c++) {
					if (c>0) {
						curr.setRight(new Node(new Value()));
						curr.getRight().setRight(head); //set the right node
						curr = curr.getRight(); //change curr pointer
						prev = prev.getRight(); //change prev pointer
						last = last.getRight(); //change last pointer
					}
					for (int r=0; r<1; r++) {
						curr.setDown(prev); //"skip" over the row node
						last.setDown(curr); //set last pointer to the top of the Grid object's (head)
					}
				}
				origin = null; //free up memory
			} else {
				Node header = find(startRow, 0);
				Node curr = header; //find the Node in the Grid object (current pointer)
				//that that is before the inserted row
				Node next = curr.getDown(); //save the next rows (points back to the head)
				Node rowHead = null; //initialize the row head pointer
				Node mid = null; //initialize the middle pointer
				
				for (int r=0; r<1; r++) {
					for (int c=0; c<numColumns; c++) {
						if (c==0) { //creates new row
							curr.setDown(new Node(new Value())); //new row Node
							curr.getDown().setDown(next); //set the new row Node right down Node to next
							rowHead = curr.getDown(); //set the row head
							mid = rowHead; //set the middle
							curr.getDown().setRight(rowHead);
							curr = curr.getRight(); //change the current pointer position
							next = next.getRight(); //change the next node's position
						} else {
							curr.setDown(new Node(new Value())); //new row Node
							curr.getDown().setDown(next); //set the new row Node down Node to next
							mid.setRight(curr.getDown()); //set previous Node to new row Node
							//the top of the row
							mid = mid.getRight(); //set the middle pointer to the new node
							mid.setRight(rowHead);
							curr = curr.getRight();
							next = next.getRight();
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * Inserts a column after a row specified.
	 * @param column - the column before the insertion
	 */
	public void insertColumn(String column) {
		int test;
		boolean isValid = true;
		try { //validate input as an integer
			test = Integer.parseInt(column);
			if ((test >= numColumns) | (test < 0)) //check that
				//the number is within range of the Grid
				isValid = false;
		} catch (NumberFormatException nfe) {
			isValid = false;
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That column does not exist, please try again.");
		else {
			numColumns++; //increment the number of columns in the Gird object
			int startCol = Integer.parseInt(column);
			Scanner scan = new Scanner(System.in);
			System.out.print("(B)efore or (a)fter? ");
			String answer = scan.next();
			if (answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("before"))
				startCol = startCol - 1;
			
			if (startCol < 0) {
				Node origin = head; //sets the original Grid
				Node prev = origin; //initialize pointer to first row of origin
				Node last = origin; //Initialize the pointer to the last row of origin
				while (last.getRight() != origin)
					last = last.getRight();
				head = new Node(new Value()); //create new head
				Node curr = head; //Initialize current pointer
				
				for (int r=0; r<numRows; r++) {
					if (r>0) {
						curr.setDown(new Node(new Value()));
						curr.getDown().setRight(head); //set the right node
						curr = curr.getDown(); //change curr pointer
						prev = prev.getDown(); //change prev pointer
						last = last.getDown(); //change last pointer
					}
					for (int c=0; c<1; c++) {
						curr.setRight(prev); //"skip" over the row node
						last.setRight(curr); //set last pointer to the top of the Grid object's (head)
					}
				}
				origin = null; //free up memory
			} else {
				Node header = find(0, startCol);
				Node curr = header; //find the Node in the Grid object (current pointer)
				//that that is before the inserted column
				Node next = curr.getRight(); //save the next column (points back to the head)
				Node colHead = null; //initialize the column head pointer
				Node mid = null; //initialize the middle pointer
				
				for (int r=0; r<numRows; r++) {
					if (r>0) {
						curr = curr.getDown();
						next = next.getDown();
					}
					for (int c=0; c<1; c++) {
						if (r==0) { //creates new column
							curr.setRight(new Node(new Value())); //new column Node
							curr.getRight().setRight(next); //set the new columns right pointer to next
							colHead = curr.getRight(); //set the column head
							mid = colHead;
							curr.getRight().setDown(colHead); //set the new columns down pointer to the colHead
						} else {
							curr.setRight(new Node(new Value())); //new column Node
							curr.getRight().setRight(next); //set the new column Node right node to next
							mid.setDown(curr.getRight()); //set the previous Node down to the new Node
							curr.getRight().setDown(colHead); //set the new column Node 
							//right Node to the top of the row
							mid = mid.getDown(); //set the middle pointer
						}
					}
				}
			}
		}
	}
	
	/**
	 * Deletes a specified row in the Grid object.
	 * @param row - the row that is being deleted
	 */
	public void deleteRow(String row) {
		int test;
		boolean isValid = true;
		try { //validate input as an integer
			test = Integer.parseInt(row);
			if ((test >= numRows) | (test < 0)) //check that
				//the number is within range of the Grid
				isValid = false;
		} catch (NumberFormatException nfe) {
			isValid = false;
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row does not exist, please try again.");
		else {
			numRows--; //decrement to Grid's number of rows
			if (Integer.parseInt(row) == 0) { //check if row zero
				head = head.getDown(); //change the head
				Node next = head; //create a pointer to the head
				Node prev = find(numRows, 0); //find the node before the node being deleted
				for (int c=0; c<numColumns; c++) {
					if (c>0) {
						prev = prev.getRight();
						next = next.getRight();
					}
					for (int r=0; r<1; r++)
						prev.setDown(next); //"skip" over the row node 
					//that is to be deleted
				}
			} else {
				int startRow = Integer.parseInt(row) - 1;
				Node prev = find(startRow, 0);
				//that that is before the inserted column
				Node next = prev.getDown().getDown(); //save the next column
				//(points back to the head)
				for (int c=0; c<numColumns; c++) {
					if (c>0) {
						prev = prev.getRight();
						next = next.getRight();
					}
					for (int r=0; r<1; r++)
						prev.setDown(next); //"skip" over the row node 
					//that is to be deleted
				}
			}
		}
	}
	
	/**
	 * Deletes a specified column in the Grid object.
	 * @param col
	 */
	public void deleteColumn(String col) {
		int test;
		boolean isValid = true;
		try { //validate input as an integer
			test = Integer.parseInt(col);
			if ((test >= numRows) | (test < 0)) //check that
				//the number is within range of the Grid
				isValid = false;
		} catch (NumberFormatException nfe) {
			isValid = false;
		}
		
		if (isValid == false)
			//Checks that the column is inside the Grid object
			System.out.println("That row does not exist, please try again.");
		else {
			numColumns--; //decrement to Grid's number of columns
			if (Integer.parseInt(col) == 0) { //check if row zero
				head = head.getRight(); //change the head
				Node next = head; //create a next node pointer 
				Node prev = find(0, numColumns-1); //create the pointer that is before the column to delete
				for (int r=0; r<numRows; r++) {
					if (r>0) {
						prev = prev.getDown();
						next = next.getDown();
					}
					for (int c=0; c<1; c++)
						prev.setRight(next); //"skip" over the column node that is to be deleted
				}
			} else {
				int startCol = Integer.parseInt(col) - 1;
				Node header = find(0, startCol);
				Node prev = header;
				//that that is before the inserted column
				Node next = prev.getRight().getRight(); //save the next 
				//column (points back to the head)
				for (int r=0; r<numRows; r++) {
					if (r>0) {
						prev = prev.getDown();
						next = next.getDown();
					}
					for (int c=0; c<1; c++)
						prev.setRight(next); //"skip" over the column node 
					//that is to be deleted
				}
			}
		}
	}
	
	/**
	 * The Node class is an object that stores a right and bottom pointer, and an abstract data
	 * type called Value.
	 * @author msurbey
	 * @version 1.0
	 */
	private class Node {
		private Value value;
		private Node right;
		private Node down;
		
		/**
		 * Constructs a newly allocated Node object that sets it's abstract Value data type
		 * object to the incoming data. It's right pointing Node is null and it's down pointing 
		 * Node is null.
		 * @param inValue - the Node's Value object data entry.
		 */
		public Node(Value inValue) {
			value = inValue; //initializes the Node object's Value object to the in coming value
		}
		
		/**
		 * Returns the current Node's Value object.
		 * @return The current Node object's abstract Value data object.
		 */
		public Value getValue() {
			return value; //returns the Node object's abstract Value data object
		}
		
		/**
		 * Changes the Node's Value object to the new corresponding data.
		 * @param data - the new Value object that the current Node's Value object will 
		 * reference.
		 */
		public void setValue(Value data) {
			value = data; //sets the Node's Value object to data.
		}
		
		/**
		 * Returns the pointer to the "right" of the current Node object.
		 * @return The current Node object's right Node.
		 */
		public Node getRight() {
			return right;
		}
		
		/**
		 * Changes the Node's right pointer to the new corresponding Node.
		 * @param node - the new Node object that the current Node's right Node will 
		 * reference.
		 */
		public void setRight(Node node) {
			right = node;
		}
		
		public Node getDown() {
			return down;
		}
		
		public void setDown(Node node) {
			down = node;
		}
	}
}