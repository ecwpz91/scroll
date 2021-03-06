import javax.swing.*;

@SuppressWarnings("serial")
public class IconFrame extends JFrame {
	JButton load, save, subscribe, unsubscribe;
	
	public IconFrame() {
		super("Icone Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		//create icons
		ImageIcon loadIcon = new ImageIcon("load.gif");
		ImageIcon saveIcon = new ImageIcon("save.gif");
		ImageIcon subscribeIcon = new ImageIcon("subscribe.gif");
		ImageIcon unsubscribeIcon = new ImageIcon("unsubscribe.gif");
		//create buttons
		load = new JButton("Load", loadIcon);
		save = new JButton("Save", saveIcon);
		subscribe = new JButton("Subscribe", subscribeIcon);
		unsubscribe = new JButton("Unsubscribe", unsubscribeIcon);
		//add to panel
		panel.add(load);
		panel.add(save);
		panel.add(subscribe);
		panel.add(unsubscribe);
		//add panel to frame
		add(panel);
		//setSize(200,200);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IconFrame iFrame = new IconFrame();
	}

}