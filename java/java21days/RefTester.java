import java.awt.Point;

public class RefTester {
	public static void main(String[] args) {
		Point pt1, pt2; //Two point variables are created
		pt1 = new Point(100, 100); //A new Point object is assigned	
		pt2 = pt1; //The value of pt1 is assigned to pt2

		//pt2 is a reference to the same object as pt1
		//If wanted them to refer to two different objects then would
		//have to instantiate pt2 = new Point(xVal, yVal)

		pt1.x = 200;
		pt1.y = 200;

		System.out.println("Point1: " + pt1.x + ", " + pt1.y);
		System.out.println("Point2: " + pt2.x + ", " + pt2.y);

		//The Integer class is a staic class
		Integer dataCount = new Integer(4); //After creating an 
		//object in this manner, you can use it as you would any object
		//but you cannot change its value
		int newCount = dataCount.intValue();
		System.out.format("%d%n", newCount);

		//Object wrapper
		String pennsylvania = "65000";
		int penn = Integer.parseInt(pennsylvania);
		System.out.println(penn);

		//Autoboxing
		Float f1 = new Float(11.5F);
		Float f2 = new Float(44.4F);
		System.out.println("Lower number: " + Math.min(f1,f2)); //With
		//the Math.min() the Float objects are unboxed into primitive
		//values automatically, because Math.min() actually requires
		//two float primitive values as arguments

	}

}
