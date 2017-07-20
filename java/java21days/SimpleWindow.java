import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SimpleWindow extends JWindow {
	
	public SimpleWindow() {
		super();
		setBounds(500, 350, 10, 10);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SimpleWindow sw = new SimpleWindow();
		
		for (int i=10; i<400; i++)
			sw.setBounds(500 - (i/2), 350 - (i/2), i, i);
	}
	
}
