public class Lamp {
	private boolean lampIsOn; //an example of an instance variable

	public Lamp() { //constructor
		lampIsOn = false;
	}

	public void turnKnob() { //method
		lampIsOn = !lampIsOn;
	}

	public boolean lampState() {

		return lampIsOn;

	}

}
