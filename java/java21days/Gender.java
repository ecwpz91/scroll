import javax.swing.*;

@SuppressWarnings("serial")
public class Gender extends JFrame {
	String[] gender = {"Male", "Female", "None of Your Business"};

	public Test() {
		super("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPasswordField pass = new JPasswordField();
		pass.setEchoChar('*');
		JPanel pane = new JPanel();
		pane.add(pass);
		ImageIcon test = new ImageIcon("attach.gif");
		JOptionPane.showConfirmDialog(null, test, "Yes or no", JOptionPane.YES_NO_OPTION, 1);
		JOptionPane.showInputDialog(pane, pass, "Enter password", 1);
		int response = JOptionPane.showOptionDialog(null, "What is your gender?", "Gender", 0,
						JOptionPane.INFORMATION_MESSAGE, test, gender, gender[2]);
		JOptionPane.showMessageDialog(null, "Game Over");
		System.out.println(response);
	}

	public static void main(String[] args) {
		new Test();
	}

}
