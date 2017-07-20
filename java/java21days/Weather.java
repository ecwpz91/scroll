public class Weather {
	public static void main (String[] args) {
		float fah = 86;
		System.out.println(fah + " degrees Fahrenheit is ...");
		
		//To convert Farhenheit into Celsius
		fah = fah - 32; //Subtract 32
		fah = fah / 9; //Divide that answer by 9
		fah = fah * 5; //Multiply that answer by 5
		//Print
		System.out.println(fah + " degrees Celsius.\n");

		float cel = 33;
		System.out.println(cel + " degrees Celsius is ...");
		//To convert Celsius to Farhenheit
		cel = cel / 5; //Divide by 5
		cel = cel * 9; //Multiply that answer by 9
		cel = cel + 32; //Add 32 to that answer
		//Print
		System.out.println(cel + " degrees Farhenheit.");

	}

}

