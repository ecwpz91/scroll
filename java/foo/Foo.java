public class Foo {
	private int x = 0;
	public static float y;

	public Foo() { //default Foo constructor
		y = 0;
	}

	public Foo(int inX, float inY) {
		x = inX;
		y = inY;
	}

	public void setX (int inX) { //method to change the value of x
		x = inX;
	}

	public static String print() { //class or static method - invoked
				       //even if there aren't any instances of the class
		return "Y is \"" + y + ".\"";
	}

	//overrides Object toString() method
	public String toString() {
		return "X is \"" + x + "\", and Y is \"" + y + ".\"";
	}
}
