import java.util.Calendar;
import java.util.Locale;

public class NumberFormat {

	public static void main (String[] args) {

		int accountBalance = 5005;
		System.out.format("Balance: $%,d%n", accountBalance);//%n is 
		//a platform-independent newline character

		double pi = Math.PI;
		System.out.format("%.11f%n", pi);

		float floatVar = 5;
		int intVar = 4;
		String stringVar = "Mike";

		System.out.format("The value of the float variable is %f, " +
				"while the value of the intger variable is " +
				"%d, and the string is %s.%n", floatVar, intVar,
				stringVar);

		int i = 461012;
		System.out.format("The value of i is: %d%n", i);

		System.out.format("The local time is: %tD.%n", Calendar.getInstance());
		
		//Prints the numbers in the French system
		//The .1 after the % sign says to how many decimal places
		System.out.format(Locale.FRANCE, "The value of the float is: "+
				"%.1f, while the value of the integer is: %d, " +
				"and the string is: %s.%n", floatVar, intVar,
				stringVar);
	
	}

}
