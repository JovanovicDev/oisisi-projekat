package view;

import javax.swing.JFrame;

import model.BazaAdresa;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = -888790554862002427L;
	private static MainFrame instance = null;
	
	private MainFrame() {
		super();
		
		this.addWindowListener(new WindowListener() {
			 
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					BazaStudenata.getInstance().save();
					BazaPredmeta.getInstance().save();
					BazaProfesora.getInstance().save();
					BazaKatedri.getInstance().save();
					BazaAdresa.getInstance().save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			 
			  });
		
		initialise();
	}
	
	private void initialise() {
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
