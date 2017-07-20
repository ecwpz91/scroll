import javax.swing.*;

@SuppressWarnings("serial")
public class FormatFrame2 extends JFrame {
	String[] formats = {"Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0"};
	JComboBox<String> formatBox = new JComboBox<String>();

	public FormatFrame2 () {
		super("Format Frame 2");
		//setSize(220, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel
		JPanel pane = new JPanel();
		JLabel formatLabel = new JLabel("Output formats: ");
		pane.add(formatLabel);
		
		for (String obj : formats)
			formatBox.addItem(obj);
		
		pane.add(formatBox);
		add(pane);
		pack();
	}
	
	public static void main(String[] args) {
		FormatFrame2 ff = new FormatFrame2();
		ff.setVisible(true);
	}
}
