/*
 * Example of overriding the superclass's method in the subclass.
 */
class Printer {
	int x = 0;
	int y = 1;
	
	void printMe() {
		System.out.println("x is " + x + ", and y is " + y + ".");
		System.out.println("I am an instance of the class: " +
					this.getClass().getName());
	}
}

class SubPrinter extends Printer {
	int z = 4;
	
	void printMe() {
		//super.printMe(); //Example of calling the original method in the body of
		//the overriding method, this can be used to add what might be necessary without
		//having to write as much code.
		System.out.println("x is " + x + ", and y is " + y +
				", z is " + z + ".");
		System.out.println("I am an instance of the class: " +
					this.getClass().getName());
	}
	
	public static void main(String[] args) {
		SubPrinter obj = new SubPrinter();
		obj.printMe();
	}
}