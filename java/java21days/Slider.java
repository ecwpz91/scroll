import javax.swing.*;

@SuppressWarnings("serial")
public class Slider extends JFrame {
	
	public Slider() {
		super("Slider");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JSlider pickNum = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
		pickNum.setMajorTickSpacing(10);
		pickNum.setMinorTickSpacing(1);
		pickNum.setPaintTicks(true);
		pickNum.setPaintLabels(true);
		add(pickNum);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Slider();
	}
}
