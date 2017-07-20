public class Driver {

	public static void main (String[] args) {
		Lamp lamp; //a Lamp object (reference variable) name lamp
		lamp = new Lamp(); //the new key dynamically allocates memory for a Lamp object,
				   //and calls the Lamp() constructor for initialization

		System.out.printf("The lamp's state is: %b.\n", lamp.lampState()); //method invocation; prints out the state of the lamp

		StrobeLamp strobeLamp = new StrobeLamp(); //example of a class that extends Lamp

		System.out.printf("The strobe lamp's state is: %b.\n", strobeLamp.lampState()); //demostrates inheritence

	}

}
