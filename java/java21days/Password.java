import javax.swing.*;

@SuppressWarnings("serial")
public class Password extends JFrame {
	PasswordFrame pass = new PasswordFrame();
	
	public Password() {
		super("Asking Password");
		setSize(540,80);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pass.setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Password ask = new Password();
	}
}

@SuppressWarnings("serial")
class PasswordFrame extends JFrame {
	JTextField username = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	
	public PasswordFrame() {
		super("Password");
		setBounds(100, 100, 210, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		JLabel userLabel = new JLabel("Username : ");
		pane.add(userLabel);
		pane.add(username);
		JLabel passLabel = new JLabel("Password: ");
		pane.add(passLabel);
		password.setEchoChar('*');
		pane.add(password);
		
		setContentPane(pane);
	}
}