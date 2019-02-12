import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUITEST {
	private JFrame frame;
	private JPanel mainPanel;
	private JLabel label;
	private ImageIcon image;
	
	public static void main(String[] args) {
		GUITEST test = new GUITEST();
		test.init();
	}
	
	private void init() {
	frame = new JFrame("Test");
	image = new ImageIcon("puppy_golden_retriever.jpeg");
	mainPanel = new JPanel();
	label = new JLabel(image);
	mainPanel.add(label);
	
	frame.add(mainPanel);
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}

}
