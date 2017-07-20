import javax.swing.*;

@SuppressWarnings("serial")
public class FormatFrame extends JFrame {
	JRadioButton[] teams = new JRadioButton[4];
	
	public FormatFrame() {
		//container
		super("Choose an Output Format");
		setSize(310,120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//radio buttons
		teams[0] = new JRadioButton("Atom");
		teams[1] = new JRadioButton("RSS 0.92");
		teams[2] = new JRadioButton("RSS 1.0");
		teams[3] = new JRadioButton("RSS 2.0", true);
		
		//panel
		JPanel pane = new JPanel();
		
		//label
		JLabel chooseLabel = new JLabel("Choose an output format " +
				"for syndicated news items.");
		pane.add(chooseLabel);
		
		//exclusive (button group)
		ButtonGroup group = new ButtonGroup();
		
		for (JRadioButton rb : teams) {
			group.add(rb);
			pane.add(rb);
		}
		
		//add to container
		add(pane);
	}
	
	public static void main(String[] args) {
		FormatFrame fFrame = new FormatFrame();
		fFrame.setVisible(true);
	}

}