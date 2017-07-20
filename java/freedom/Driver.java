import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		PowerStrip ps1 = new PowerStrip();

		if (ps1.isOn())
			System.out.println("The powerstrip is on.");
		else
			System.out.println("The powerstrip is off.");

		String answer;

		System.out.println("Turn the power strip on?");
		System.out.println("1. yes");
		System.out.println("2. no");

		answer = s.next();
		boolean valid = false;
		if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("2"))
			valid = true;

		while(!valid) {
			System.out.println("Invalid input, please try again.");
			answer = s.next();
	                if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("2"))
        	                valid = true;

		}

		if (answer.equalsIgnoreCase("1"))
			ps1.turnOn();

                if (ps1.isOn())
                        System.out.println("The powerstrip is on.");
                else
                        System.out.println("The powerstrip is off.");

	}
}
