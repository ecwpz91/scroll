import java.awt.*;
import java.awt.Graphics2D;

public class DancingOval extends Shape {
	public DancingOval(int x, int y, int w, int h, Color c) {
		super(x,y,w,h,c);
	}

	public void paint(Graphics g) {
		g.setColor(myColor);
		g.fillOval(locx,locy,width,height);
	}
}
