import java.awt.*;

public class FoxtrotOval extends DancingOval {
        private static final byte UP = 0;
        private static final byte DOWN = 1;
        private static final byte LEFT = 2;
        private static final byte RIGHT = 3;

	private byte state;

        private int maxY;
        private int minY;
	private int middle;
        private int minX;
        private int maxX;

	private boolean backPass;

	public FoxtrotOval(int x, int y, int w, int h, Color c) {
		super(x,y,w,h,c);
		maxX = x;
		minX = x - 30;
		middle = maxX - 15;
		maxY = y - 30;
		minY = y;
		backPass = false;
	}

	public void danceStep() {
		if (backPass) {
			switch (state) {
				case RIGHT:
					locx++;
					if (locx == middle && locy == minY)
						state = UP;
					if (locx == maxX)
						state = DOWN;
					break;
				case UP:
					locy--;
					if (locy == maxY)
						state = RIGHT;
					break;
				case DOWN:
					locy++;
					if (locy == minY) {
						backPass = false;
						state = UP;
					}	
					break;

			}
		} else {
			switch (state) {
				case UP:
					locy--;
					if (locy == maxY)
						state = LEFT;
					break;
				case LEFT:
					locx--;
					if (locx == middle && locy == maxY)
						state = DOWN;
					if (locx == minX) {
						backPass = true;
						state = RIGHT;
					}
					break;
				case DOWN:
					locy++;
					if (locy == minY)
						state = LEFT;
			}
		}
	}

}
