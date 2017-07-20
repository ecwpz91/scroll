public class ZipCode {
	private int zipCode;
	
	public ZipCode(String zip) {
		zipCode = checkZip(zip);
	}
	
	private int checkZip(String zip) {
		if (zip.length() == 5 | zip.length() == 9)
			try {
				zipCode = Integer.parseInt(zip);
			} catch (NumberFormatException nfe) { //receives any NumberFormatException objects
				//thrown within the try block
				System.out.println(zip + " is not a set of only numbers: defaulted to zero.");
				//System.out.println(nfe.getMessage());
				//nfe is similar to a method definition's argument list, it contains the class
				//of exception to be caught and a variable name
				//nfe.printStackTrace(); //allows the program to continue executing, while printing
				//the sequence of method calls that led to the statement that generated the exception
			}
		else
			System.out.println(zip + " is either too long or too short: defaulted to zero.");
		
		return zipCode;
	}
	
	public int getZip() {
		return zipCode;
	}
	
	public static void main(String args[]) {
		ZipCode zc1 = new ZipCode("221a1");
		ZipCode zc2 = new ZipCode("11111");
		System.out.println("zc1: " + zc1.getZip());
		System.out.println("zc2: " + zc2.getZip());
	}

}
