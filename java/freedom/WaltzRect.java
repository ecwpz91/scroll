import java.awt.*;

public class WaltzRect extends DancingRect {
	private static final byte SE = 0;
	private static final byte NE = 1;
	private static final byte W = 2;

	private byte state;

	private int bottomX;
	private int rightX;
	private int leftX;

	public WaltzRect(int x, int y, int w, int h, Color c) {
		super(x,y,w,h,c);
		bottomX = locx + 17;
		rightX = bottomX + 17;
		leftX = locx;
	}

	// override danceStep()
	public void danceStep() {
		switch(state) {
			case SE:
				locx++;
				locy++;
				if (locx == bottomX)
					state = NE;
				break;
			case NE:
				locx++;
				locy--;
				if (locx == rightX)
					state = W;
				break;
			case W:
				locx--;
				if (locx == leftX)
					state = SE;
				break;
		}
	}

}
