import javax.swing.*;

@SuppressWarnings("serial")
public class Test extends JFrame {
	JLabel label = new JLabel("Enter your password: ");
	JPasswordField pass = new JPasswordField(20);
	JButton button = new JButton("Submit");
	public Test() {
		super("Password Authentication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		pass.setEchoChar('*');
		panel.add(label);
		panel.add(pass);
		panel.add(button);
		add(panel);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Test t = new Test();
	}

}
