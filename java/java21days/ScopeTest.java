/*
 * When you declare a variable in Java, that variable always has
 * a limited scope. A variable with local scope, for example, 
 * can only be used inside the block in which it is defined.
 * Instance variables have a scope that extends to the entire
 * class, so that they can be used by any of the instance methods
 * within that class.
 */

/** This class shows the scope of the variable "test".
 * @author mike
 *
 */
class ScopeTest {
	/**
	 * @serial The integer test variable "10".
	 */
	int test = 10; //instance variable
	
	/** This method creates a variable of lower scope with the
	 * same name as the class's instance variable "test" and outputs the
	 * variable for the user to see how scope is interpreted. 
	 */
	void printTest() {
		int test = 20; //local variable - inner most scope
		//Because of the way java works, its possible to create
		//a variable in a lower scope that hides (replaces) the
		//original value of that variable and introduces subtle
		//and confusing bugs into code.
		System.out.println("Test: " + test);
		//Can avoid this problem by implementing "this." before test,
		//but the best way is to avoid the duplication of variable
		//names and definitions.
	}
	
	/** This method outputs the class's instance variable "test".
	 */
	void print() {
		System.out.println("Test: " + test); //instance variable
	}
	
	/** This method overrides Objects toString() in order to 
	 * facilitate easier printing.
	 * @return A String of the class's instance variable.
	 */
	public String toString() {
		String str = "Test: " + test; //instance vairable
		return str; 
	}
	
	public static void main(String[] args) {
		ScopeTest st = new ScopeTest();
		st.printTest();
		st.print();
		System.out.println(st);
	}

}
