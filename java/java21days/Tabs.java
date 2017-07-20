import javax.swing.*;

@SuppressWarnings("serial")
public class Tabs extends JFrame {
	
	public Tabs() {
		super("Tab Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main = new JPanel();
		JPanel next = new JPanel();
		JTextArea text = new JTextArea(5,40);
		next.add(text);
		JTabbedPane pane = new JTabbedPane();
		pane.add("Main", main);
		pane.add("Next", next);
		add(pane);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Tabs();
	}

}
