public class SquareTool { //top-level class
	public SquareTool(String input) {
		try {
			float in = Float.parseFloat(input);
			Square sq = new Square(in);
			float result = sq.value;
			System.out.println("The square of " + input + " is " + 
						result + ".");
		} catch (NumberFormatException e) {
			System.out.println(input + " is not a valid number.");
		}
	}

	/*
	 * Isn't functionally different from a helper class included in the same source file as a
	 * programs main class file, the only difference is that the helper is defined inside the
	 * class file, resulting in a few advantages:
	 * ->Inner classes are invisible to all other classes, which means that you don't have to 
	 * worry about name conflicts between it and other classes.
	 * ->Inner classes can have access to variables and method within the scope of the top-level
	 * class that they would not have as a separate class.
	 * 
	 * The name of an inner class is associated with the name of the class in which it is contained,
	 * and it is assigned automatically when the program is compiled. The Square class is given the
	 * name SquareTool$Square.class by the Java compiler.
	 */
	class Square { //inner class
		float value;
	
		Square(float x) { //inner constructor
			value = x * x;
		}	
	}
	
	public static void main(String[] args) {
		if (args.length > 0) {
			@SuppressWarnings("unused")
			SquareTool dr = new SquareTool(args[0]);
		} else
			System.out.println("Usage: java SquareTool number.");
	}
}
