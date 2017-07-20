import java.awt.FlowLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class ProgressMonitor extends JFrame {
	
	private JProgressBar current;
	@SuppressWarnings("unused")
	private JTextArea out;
	@SuppressWarnings("unused")
	private JButton finder;
	private int num;
	
	public ProgressMonitor() {
		super("Progess Monitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(205,68);
		setLayout(new FlowLayout());
		
		current = new JProgressBar(0, 2000);
		current.setStringPainted(true);
		add(current);
	}
	
	public void iterate() {
		while(num < 2000) {
			current.setValue(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			num += 95;
		}
	}
	
	public static void main(String[] args) {
		ProgressMonitor pm = new ProgressMonitor();
		pm.setVisible(true);
		pm.iterate();
	}
	
}