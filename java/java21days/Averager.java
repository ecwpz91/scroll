class Averager {
	public static void main(String[] args) {
		int sum = 0;
		
		if (args.length > 0) {
			for (int i=0; i<args.length; i++)
				sum += Integer.parseInt(args[i]);
			
			System.out.println("The sum is: " + sum);
			System.out.println("The average is: " + (float)sum/args.length);
		} else
			System.out.println("Enter arguments please.");
	}

}
