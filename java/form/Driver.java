import java.io.*;

public class Driver {
	
	public static void main(String[] args) {

		try {
		  
			BufferedReader inputFile = new BufferedReader (new FileReader("input.txt"));
			String line = null; //line corresponds to one string in the file
			FormList list = new FormList();
		  
			//while there lines left in the input file	
			while ((line=inputFile.readLine())!=null)
				list.add(line); //System.out.println(list.toString());
			list.sortByOption("bytes");
			list.buildHTMLFile("hello.html");
			//list.formatHTMLFile("hello.html");

	       	} catch (IOException e) {

			System.err.println("Error, could not find file.");
		
		}

	}

}