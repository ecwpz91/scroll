import java.applet.*;
import java.awt.*;

public class Broadway extends Applet implements Runnable {

	private Thread animation;
	private int locx, locy;
	private int width, height;

	private static final byte UP = 0; // direction of motion
	private static final byte DOWN = 1;
	private static final byte LEFT = 2;
	private static final byte RIGHT = 3;

	private byte state; // state the rect is in

	private static final int REFRESH_RATE = 15; // length of the pausing interval
						     // in ms

	private Graphics offscreen;
	private Image image;

	// applet methods:

	public void init() {
		setBackground(Color.black);
		locx = 80; // parameters of the center rect
		locy = 100;
		width = 110;
		height = 90;
		state = UP;
		image = createImage(300,300); // allocation of the offscreen
		offscreen = image.getGraphics();   // buffer
	}

	public void start() {
		animation = new Thread(this);
		if (animation != null)
			animation.start();
	}

	// Modified version of paint() such that it draws to the offscreen
	// buffer, instead of the original graphics context
	public void paint(Graphics g) {
		System.out.println(">> paint <<");

		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,300,300); // clear buffer

		offscreen.setColor(Color.yellow);
		offscreen.fillRect(0,0,90,90);
		offscreen.fillRect(250,0,40,190);
		offscreen.fillRect(80,110,100,20); // hidden rectangle

		offscreen.setColor(Color.blue);
		offscreen.fillRect(80,200,220,90);
		offscreen.fillRect(100,10,90,80);

		offscreen.setColor(Color.lightGray);
		offscreen.fillRect(locx,locy,width,height);

		offscreen.setColor(Color.red);
		offscreen.fillRect(200,0,45,45);
		offscreen.fillRect(0,100,70,200);

		offscreen.setColor(Color.magenta);
		offscreen.fillRect(200,55,60,135);

		g.drawImage(image,0,0,this); // draw offscreen buffer
					    // to screen
	}

	/*
	 * The problem with this cure is that there will be a 
	 * "trail" behind any animated object (or sprite) that
	 * that moves, since the previous frame is no longer
	 * erased, unless we "double-buffer" - use offscreen to
	 * buffer the actual image and... THEN draw offscreens 
	 * contents to the original graphics context
	 */
	public void update(Graphics g) {
		g.clipRect(70,90,130,110);
		paint(g);
	}

	// update the center rectangle

	void updateRectangle() {
		switch (state) {
			case DOWN:
				locy += 2;
				if (locy >= 110)
					state = UP;
				break;
			case UP:
				locy -= 2;
				if (locy <= 90)
					state = RIGHT;
				break;
			case RIGHT:
				locx += 2;
				if (locx >= 90)
					state = LEFT;
				break;
			case LEFT:
				locx -= 2;
				if (locx <= 70)
					state = DOWN;
				break;
		}
	}

	public void run() {
		while(true) {

			/*
			 * Broadway is a subclass of Applet,
			 * so it inherits all of the Applet's methods
			 * repaint() is one of these; and calling it has
			 * two effects:
			 * 1. It clears the screen.
			 * 2. It draws the current frame of the animcation, by calling paint().
			*/
			repaint(); 
			updateRectangle();
			try {
				Thread.sleep(REFRESH_RATE);
			} catch (Exception e) {};
		}
	}

	public void stop() {
		System.out.println(">> stop <<");
		if (animation != null) {
			animation.stop();
			animation = null;
		}
	}
}
