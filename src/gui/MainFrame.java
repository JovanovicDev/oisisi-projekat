package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setTitle("Studentska slu�ba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		MyMenuBar barMenu = new MyMenuBar();
		this.setJMenuBar(barMenu);

		
		setVisible(true);
	}
}
