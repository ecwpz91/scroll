import javax.swing.*;

@SuppressWarnings("serial")
public class Authenticator extends JFrame {
	private JTextField username = new JTextField(15);
	private JPasswordField password = new JPasswordField(15);
	private JTextArea comments = new JTextArea(4, 15);
	private JScrollPane scroll = new JScrollPane(comments, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private JButton submit = new JButton("Sumbit");
	private JButton cancel = new JButton("Cancel");
	
	public Authenticator() {
		//container
		super("Account Information");
		setSize(300, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel
		JPanel pane = new JPanel();
		//labels
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel commentsLabel = new JLabel("Comments: ");
		//text area
		comments.setLineWrap(true);
		comments.setWrapStyleWord(true);
		//password
		password.setEchoChar('*');
		//add to panel
		pane.add(usernameLabel);
		pane.add(username);
		pane.add(passwordLabel);
		pane.add(password);
		pane.add(commentsLabel);
		pane.add(scroll);
		pane.add(submit);
		pane.add(cancel);
		
		//add to container
		add(pane);
		setContentPane(pane);
		//make visible
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Authenticator();
	}
}