package gui;


import javax.swing.JFrame;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = -888790554862002427L;
	private static MainFrame instance = null;
	
	private MainFrame() {
		super();
		initialise();
	}
	
	private void initialise() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width * 3/4, height * 3/4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		MyMenuBar barMenu = new MyMenuBar();
		this.setJMenuBar(barMenu);
		setLayout(new BorderLayout());
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar statBar = new StatusBar(width,getTitle());
		add(statBar,BorderLayout.SOUTH);
		
	
		ViewPanel vp = new ViewPanel(screenSize);
		
		add(vp);
		
		
		
		
		setVisible(true);
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	
}
