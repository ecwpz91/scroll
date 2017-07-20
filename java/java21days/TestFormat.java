import java.util.Calendar;
import java.util.Locale;
/*
 * Except for %% and %n, all format specifiers must match an argument. If
 * they don't, an exception is thrown.
 */

public class TestFormat {

	public static void main(String[] args) {

		long n = 461012;
		System.out.println("Long:");
		System.out.format("%d%n", n);
		// --> 00461012
		System.out.format("%08d%n",n); //makes n length 8 with 
		//zero's in front
		// --> " +461012"
		System.out.format("%+8d%n",n); //makes n length 8 with
		//a space and positive number
		// --> " 461,012"
		System.out.format("%,8d%n", n); //makes n length 8 with
		//',' seperation 
		// --> "+461,012"
		System.out.format("%+,8d%n%n", n); //makes n length 8 with
		//',' seperation and '+' sign
		
		double pi = Math.PI;
		System.out.println("Pi:");
		System.out.format("%f%n", pi);
		System.out.format("%.3f%n", pi);
		System.out.format("%10.3f%n", pi); //makes pi length 8
		System.out.format("%-10.3f%n", pi);
		System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi); //French
		//number formating and 4 decimals displayed
		
		System.out.println("Calendar:");
		Calendar c = Calendar.getInstance();
		// --> "Month Day, Year"
		System.out.format("%tB %te, %tY%n", c, c, c);

		// --> "Time"
		System.out.format("%tl:%tM %tp%n", c, c, c);

		// --> "Month/Day/Year"
		System.out.format("%tD%n", c);


	}

}
