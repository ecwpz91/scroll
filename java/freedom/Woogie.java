import java.applet.*;
import java.awt.*;

// run this applet with width=300 height=300
public class Woogie extends Applet implements Runnable {
	private Thread animation;

	Graphics offscreen;
	Image image;

	static final int NUM_SHAPES = 9; // in ms

	static final int REFRESH_RATE = 100; // in ms

	Shape s[];

	public void init() {
		System.out.println(">> init <<");
		setBackground(Color.black);
		initShapes();
		image = createImage(300,300);
		offscreen = image.getGraphics();
	}

	public void initShapes() {
		s = new Shape[NUM_SHAPES];	

		s[0] = new FoxtrotOval(30,40,60,60,Color.yellow);
		s[1] = new BoogieRect(250,0,40,190,Color.yellow);
		s[2] = new WaltzRect(200,55,60,130,Color.yellow);
		s[3] = new BoogieRect(80,200,220,90,Color.blue);
		s[4] = new WaltzRect(100,10,90,80,Color.blue);
		s[5] = new BoogieRect(80,100,110,90,Color.gray);
		s[6] = new WaltzRect(200,0,45,45,Color.red);
		s[7] = new WaltzRect(0,100,70,200,Color.red);
		s[8] = new BoogieRect(200,55,60,135,Color.magenta);
	}

	public void start() {
		System.out.println(">> start >>");
		animation = new Thread(this);
		if (animation != null)
			animation.start();
	}

	// update each rectangles position
	// DYNAMIC METHOD BINDING OCCURS HERE
	public void updateShapes() {
		for (int i=0; i<NUM_SHAPES; i++)
			s[i].danceStep(); // each rectanles dance step

	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		offscreen.setColor(Color.black); // clear buffer
		offscreen.fillRect(0,0,300,300);

		for (int i=0; i<NUM_SHAPES; i++)
			s[i].paint(offscreen); //paints each rectangle

		g.drawImage(image,0,0,this);
	}

	public void run() {
		while (true) {
			repaint();
			updateShapes();
			try {
				Thread.sleep(REFRESH_RATE);
			} catch (Exception e) {}
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
