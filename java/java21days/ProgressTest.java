import javax.swing.*;

@SuppressWarnings("serial")
public class ProgressTest extends JFrame {
	
	public ProgressTest() throws InterruptedException {
		super("Prgress Bar Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		JProgressBar pbar = new JProgressBar(SwingConstants.HORIZONTAL,0,100);
		pbar.setStringPainted(true);
		setLookAndFeel();
		add(pbar);
		pack();
		setVisible(true);
		
		for(int i=0; i<=100; i++) {
			Thread.sleep(100);
			pbar.setValue(i);
		}
	}
	
	public static void main(String[] args) {
		try {
			new ProgressTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
