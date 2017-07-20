import java.awt.*;

public class DancingRect extends Shape {
	public DancingRect(int x, int y, int w, int h, Color c) {
		super (x,y,w,h,c);
	}

	public void paint(Graphics g) {
		g.setColor(myColor);
		g.fillRect(locx,locy,width,height);
	}
}
