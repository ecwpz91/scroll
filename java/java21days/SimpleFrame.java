//import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SimpleFrame extends JFrame {
	
	public SimpleFrame (String title) {
		super(title);
		//pack();
		setBounds(500, 350, 300, 100);
		//setSize(new Dimension(300,100));
		//setSize(300,100);
		//setLocation(500,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	} 
	
	public static void main(String[] args) {
		SimpleFrame sf = new SimpleFrame("Simple Frame");
		sf.setVisible(true);
	}

}