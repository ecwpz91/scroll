public class Constructors {
	private int x;
	private float y;
	private boolean valid = false;

	// default constructor
	public Constructors() {
		this(0,0);
	}

	// constructor 1
	public Constructors(int inX, float inY) {
		System.out.println(">> constructor 1 <<");
		x = inX;
		y = inY;
		System.out.printf("X is %d.\n", x);
		System.out.printf("Y is %f.\n", y);
	}

	// constructor 2
	public Constructors(float x) {
		this((int)x, x); // invoke constructor #1
	}

	// constructor 3
	public Constructors(int x) {
		this(x, (float)x);
	}

}
