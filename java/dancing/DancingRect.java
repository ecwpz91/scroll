import java.awt.*;

public class DancingRect {
	// instance variables:
	int locx, locy; // coordinates of upper left rectangle
			// corners

	int width, height; // width and height of rectangle

	Color myColor; // color of rectangle

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

	}

	public void paint(Graphics g) {
		g.setColor(myColor);
		g.fillRect(locx,locy,width,height);

	}
}
