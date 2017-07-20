/*
 * When you call a method with an object as a parameter, the object is
 * passed into the body of the method by reference. Any change made to
 * the object inside the method will persist outside of the method. 
 * Keeping in mind that such objects include arrays and all objects
 * contained in arrays. That is when you pass an array into a method and
 * modify its contents the original array is affected.
 */

class Passer {
	
	void toUpperCase(String[] text) {
		for (int i=0; i<text.length; i++)
			text[i] = text[i].toUpperCase();
	}
	
	public static void main(String[] args) {
		Passer passer = new Passer();
		passer.toUpperCase(args); //Because a reference to the array object is
		//passed to the method, changing the value of each array element changes
		//the actual element (rather than a copy of it).
		for (int i=0; i<args.length; i++)
			System.out.print(args[i] + " ");
		System.out.println();
	}

}
