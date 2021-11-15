package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.*;



public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {
		
	
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		ImageIcon newIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\newImage.jpg");
		ImageIcon aboutIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\aboutImage.jpg");
		ImageIcon closeIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\closeImage.jpg");
		ImageIcon deleteIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\deleteImage.jpg");
		ImageIcon editIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\editImage.jpg");
		ImageIcon helpIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\helpImage.jpg");
		ImageIcon openIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\openImage.jpg");
		ImageIcon saveIcon = new ImageIcon("C:\\Users\\Zindovic\\eclipse-workspace\\oisisiProjekat\\oisisi-projekat\\src\\Images\\saveImage.jpg");
		
		JMenu open = new JMenu("Open");
		open.setIcon(openIcon);
		
		JMenuItem fileNew = new JMenuItem("New",newIcon);
		JMenuItem fileSave = new JMenuItem("Save",saveIcon);
		JMenuItem fileClose = new JMenuItem("Close",closeIcon);
		
		JMenuItem openStudenti = new JMenuItem("Studenti");
		JMenuItem openPredmeti = new JMenuItem("Predmeti");
		JMenuItem openProfesori = new JMenuItem("Profesori");
		JMenuItem openKatedre = new JMenuItem("Katedre");
		
		JMenuItem editEdit = new JMenuItem("Edit",editIcon);
		JMenuItem editDelete = new JMenuItem("Delete",deleteIcon);
		
		JMenuItem helpHelp = new JMenuItem("Help",helpIcon);
		JMenuItem helpAbout = new JMenuItem("About",aboutIcon);
		
		open.add(openStudenti);
		open.addSeparator();
		open.add(openPredmeti);
		open.addSeparator();
		open.add(openProfesori);
		open.addSeparator();
		open.add(openKatedre);

		file.add(fileNew);
		file.addSeparator();
		file.add(fileSave);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(fileClose);
		
		edit.add(editEdit);
		edit.addSeparator();
		edit.add(editDelete);
		
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);
		
		
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		fileClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		add(file);
		add(edit);
		add(help);
	
		setVisible(true);
	}
	
}