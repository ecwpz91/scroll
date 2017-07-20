class HexReader {
	String[] input = {"000A110D1D260219 ", "78700F1318141E0C ", "6A197D45B0FFFFFF "}; //FF is used
	//to fill out the end of a sequence
	
	void readLine(String code) {
		try {
			for (int i=0; i+1<code.length(); i+=2) {
				String sub = code.substring(i, i+2); //a call to substring(2, 5) would 
				//return the characters from index position 2 to index position 4
				//so substring is called it is first iteration it returns of the values of 0 and 1
				int num = Integer.parseInt(sub, 16); //16 is used for hexadecimal (base 16 conversion)
				if (num == 255)
					return; //return in a void statement returns null (nothing)
				System.out.print(num + " ");
			}
		} finally { //useful outside exceptions, it can execute cleanup code after a return, break,
			//or continue statement inside loops
			System.out.println("**");
		}
		return;
	}
	
	public static void main(String[] args) {
		HexReader hex = new HexReader();
		for (int i=0; i<hex.input.length; i++)
			hex.readLine(hex.input[i]);
	}
}