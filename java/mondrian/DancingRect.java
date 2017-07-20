import java.awt.*;

public class DancingRect {
	// instance variables:
	protected int locx, locy; // coordinates of upper left rectangle
			// corners

	private int width, height; // width and height of rectangle

	private Color myColor; // color of rectangle

	// constructor
	public DancingRect(int x, int y, int w, int h, Color c) {
		locx = x;
		locy = y;
		width = w;
		height = h;
		myColor = c;
	}

	// methods:
	public void danceStep() {
		// does nothing
	}

	public void paint(Graphics g) {
		g.setColor(myColor);
		g.fillRect(locx,locy,width,height);
	}
}
