public class PowerStrip implements PSInterface {
	private boolean state;
	private final int OUTLETS = 6;

	public PowerStrip() {
		state = false;
	}

	public boolean isOn() {
		return state;
	}

	public void turnOn() {
		state = true;
	}

	public void turnOff() {
		state = false;
	}

	public int numOfOutlets() {
		return OUTLETS;
	}
}
