import java.awt.*;

public class Shape {

        protected int locx, locy; // coordinates of upper left rectangle
                        // corners

        protected int width, height; // width and height of rectangle

        protected Color myColor; // color of rectangle

	public Shape(int x, int y, int w, int h, Color c) {
                locx = x;
                locy = y;
                width = w;
                height = h;
                myColor = c;
	}

        public void danceStep() {
                // does nothing
        }

	public void paint(Graphics g) {
		// does nothing
	}


}
