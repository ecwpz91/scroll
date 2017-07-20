public class StringChecker {

	public static void main (String[] args) {

		String str = "Nobody ever went broke by buying IBM";

		System.out.println("The string is: " + str);
		System.out.println("Length of the string is: " + str.length());
		System.out.println("The character at position 5: " +
				str.charAt(5));
		System.out.println("The substring from 26 to 32: " + 
				str.substring(26,32));
		System.out.println("The index of the character v: " +
				str.indexOf('v'));
		System.out.println("The index of the beginning of the " +
				"substring \"IBM\": " + str.indexOf("IBM"));
		//Even though this is a string of length 3, indexOf() returns
		//the beginning index of the string
		System.out.println("The string in upper case: " +
				str.toUpperCase());

		String s, s2;
		s = "item";
		s2 = s.valueOf(550);
		s2 = String.valueOf(550);
		System.out.println(s2);

	}

}
