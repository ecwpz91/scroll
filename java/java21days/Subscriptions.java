import javax.swing.*;

@SuppressWarnings("serial")
public class Subscriptions extends JFrame {
	
	String[] subs = {"0xDECAFBAD", "Cafe au Lait", "Hack the Planet", "Ideoplex",
			"Inessential", "Intertwingly", "Markpasc", "Postneo", "RC3", "Workbench"};
	JList<String> subList = new JList<String>(subs);
	
	public Subscriptions() {
		super("Subscriptions");
		setSize(150,175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		JLabel subLabel = new JLabel("RSS Subscriptions: ");
		pane.add(subLabel);
		
		subList.setVisibleRowCount(5);
		JScrollPane scroller = new JScrollPane(subList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		pane.add(scroller);
		add(pane);
	}
	
	public static void main(String[] args) {
		Subscriptions app = new Subscriptions();
		app.setVisible(true);
	}

}
