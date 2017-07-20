import javax.swing.*;

@SuppressWarnings("serial")
public class VCR extends JFrame {
	
	JButton play, stopEject, rewind, fastForward, pause;
	
	public VCR () {
		super("VCR");
		setSize(175, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		
		play = new JButton("Play");
		pane.add(play);
		stopEject = new JButton("Stop/Eject");
		pane.add(stopEject);
		rewind = new JButton("Rewind");
		pane.add(rewind);
		fastForward = new JButton("Fast Forward");
		pane.add(fastForward);
		pause = new JButton("Pause");
		pane.add(pause);
		
		setContentPane(pane);
	}
	
	public static void main(String[] args) {
		VCR vcr = new VCR();
		vcr.setVisible(true);
	}
}