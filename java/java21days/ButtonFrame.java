import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	JButton load = new JButton("Load");
	JButton save = new JButton("Save");
	JButton unsubscribe = new JButton("Unsubscribe");
	
	public ButtonFrame(String title, int xCord, int yCord) {
		super(title);
		setBounds(xCord,yCord,140,170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.add(load);
		pane.add(save);
		pane.add(unsubscribe);
		add(pane);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ButtonFrame bf = new ButtonFrame("Button Frame", 500, 350);
	}

}
