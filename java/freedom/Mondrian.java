import java.applet.*;
import java.awt.*;

public class Mondrian extends Applet {

	private int increment;
	private Color cArray[] = {Color.red, Color.yellow, Color.blue, Color.green, Color.white, Color.lightGray, Color.magenta, Color.pink};

	public void init() { //overrides Applet constructor
		System.out.println(">> init <<");
		setBackground(Color.black);
		increment = 0;
	}

	public void start() {
		System.out.println(">> start <<");
	}

	// get a random number 0 - 7
	private Color randColor() {
		boolean valid = false;
		int index = 0;
		while(!valid) {
			index = (int) (Math.random() * 100);
			if ((index >= 0) && (index <=7))
				valid = true;
		}

		return cArray[index];
	}	

	//paint squares of varying colors
	public void paint(Graphics g) {
		System.out.println(">> paint <<");
		for (int i=0; i<3; i++) {

			g.setColor(randColor());
			g.fillOval(0+increment,0+increment,90,90);
			g.fillRect(250+increment,0+increment,40,190);
			g.fillRect(80+increment,110+increment,100,20);

			g.setColor(randColor());
			g.fillRect(80,200,220,90);
			g.fillRect(100,10,90,80);

			g.setColor(randColor());
			g.fillRect(80,100,110,90);

			g.setColor(randColor());
			g.fillRect(200,0,45,45);
			g.fillOval(0,100,70,200);

			g.setColor(randColor());
			g.fillRect(200,55,60,135);

			increment += 10;
		}
	}

	public void stop() {

		System.out.println(">> stop <<");

	}

	public void destroy() {

		System.out.println(">> destroy <<");

	}
}
