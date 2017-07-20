import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*try {
			
			Value val1 = new Value();
			Value val2 = new Value();
			Value val3 = new Value();
			val1.setValue("4");
			val2.setValue("0");
			
			System.out.println("Val1: " + val1);
			System.out.println("Val1 Tag: " + val1.getTag());
			System.out.println("Val2: " + val2);
			System.out.println("Val2 Tag: " + val2.getTag());
			
			val3 = val1.slash(val2);
			System.out.println("\nVal3 : " + val3);
			if (val3 != null)
				System.out.println("Val3 Tag: " + val3.getTag());
			
		}catch (NumberFormatException nfe) {
			System.out.println("nfe");
			System.out.println(nfe.getMessage());
			
		}
		
		for (int i=1; i<2; i++)
			System.out.println(i);*/
		System.out.print("enter a string:");
		String str = scan.next();
		
		System.out.print("enter a number: ");
		String number = scan.nextLine();
		System.out.println(number);
	}
}