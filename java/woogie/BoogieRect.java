import java.awt.*;

public class BoogieRect extends DancingRect {
	// direction of motion
	private static final byte UP = 0;
	private static final byte DOWN = 1;
	private static final byte LEFT = 2;
	private static final byte RIGHT = 3;

	private byte state; //state of rectangle

	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	public BoogieRect(int x, int y, int w, int h, Color c) {
		super(x,y,w,h,c);
		minX = x - 13;
		maxX = x + 13;
		minY = y - 13;
		maxY = y + 13;
	}

	// override danceStep()
	public void danceStep() {
		switch(state) {
			case DOWN:
				locy += 2;
				if (locy >= maxY)
					state = UP;
				break;
			case UP:
				locy -= 2;
				if (locy <= minY)
					state = RIGHT;
				break;
			case RIGHT:
				locx += 2;
				if (locx >= maxX)
					state = LEFT;
				break;
			case LEFT:
				locx -= 2;
				if (locx <= minX)
					state = DOWN;
				break;
		}
	}

}
