class EqualsTester {
	public static void main(String[] args) {
		String str1, str2;
		str1 = "Free the bound periodicals.";
		str2 = str1;

		System.out.println("str2 = str1;\n");
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);

		System.out.println("== (Same object) " + (str1 == str2) + "\n"); 		//Yes because str2 references str1

		str2 = new String(str1); //New instanciation, different
		//references
		System.out.println("str2 = new String(str1);\n");
		System.out.println("str2: " + str2);
		System.out.println("str1: " + str1);
		System.out.println("== " + (str1 == str2));
		System.out.println("Same value? " + str1.equals(str2));
		
	}

}
