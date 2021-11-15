package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	public MainFrame() {
		super();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width * 3/4, height * 3/4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
