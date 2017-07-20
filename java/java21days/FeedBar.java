import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class FeedBar extends JFrame {
	private ImageIcon loadImg = new ImageIcon("load.gif");
	private JButton load = new JButton("Load", loadImg);
	private ImageIcon saveImg = new ImageIcon("save.gif");
	private JButton save = new JButton("Save", saveImg);
	private ImageIcon subscribeImg = new ImageIcon("subscribe.gif");
	private JButton subscribe = new JButton("Subscribe", subscribeImg);
	private ImageIcon unsubscribeImg = new ImageIcon("unsubscribe.gif");
	private JButton unsubscribe = new JButton("Unsubscribe", unsubscribeImg);
	private JTextArea text = new JTextArea(5, 40);
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Feeds");
	
	public FeedBar() {
		super("Feed Bar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		//create tool bar
		JToolBar bar = new JToolBar();
		bar.add(load);
		bar.add(save);
		bar.add(subscribe);
		bar.add(unsubscribe);
		
		//create scroll bar
		text.setWrapStyleWord(true);
		text.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(text);
		
		//create menu
		JMenuItem j0 = new JMenuItem("Load");
		JMenuItem j1 = new JMenuItem("Save");
		JMenuItem j2 = new JMenuItem("subscribe");
		JMenuItem j3 = new JMenuItem("Unsubscribe");
		menu.add(j0);
		menu.add(j1);
		menu.addSeparator();
		menu.add(j2);
		menu.add(j3);
		menuBar.add(menu);
		
		setLayout(new BorderLayout());
		setJMenuBar(menuBar);
		add("North", bar);
		add("Center", scroll);
		setLookAndFeel();
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FeedBar();
	}
	
	private void setLookAndFeel() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println("Can't set look and feel: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
