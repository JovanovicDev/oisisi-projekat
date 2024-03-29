package view;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.BazaAdresa;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import java.awt.event.*;
import java.io.IOException;

public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = -7863806568418316202L;

	public MyMenuBar() {
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		ImageIcon newIcon = new ImageIcon("./src/Images/newImage.jpg");
		ImageIcon aboutIcon = new ImageIcon("./src/Images/aboutImage.jpg");
		ImageIcon closeIcon = new ImageIcon("./src/Images/closeImage.jpg");
		ImageIcon deleteIcon = new ImageIcon("./src/Images/deleteImage.jpg");
		ImageIcon editIcon = new ImageIcon("./src/Images/editImage.jpg");
		ImageIcon helpIcon = new ImageIcon("./src/Images/helpImage.jpg");
		ImageIcon openIcon = new ImageIcon("./src/Images/openImage.jpg");
		ImageIcon saveIcon = new ImageIcon("./src/Images/saveImage.jpg");
		
		ImageIcon studentIcon = new ImageIcon("./src/Images/imageStudent.png");
		ImageIcon subjectIcon = new ImageIcon("./src/Images/imageBook.jpg");
		ImageIcon tableIcon = new ImageIcon("./src/Images/imageTable.png");
		ImageIcon profIcon = new ImageIcon("./src/Images/imageProf.png");
			
		JMenu open = new JMenu("Open");
		open.setIcon(openIcon);
		
		JMenuItem fileNew = new JMenuItem("New",newIcon);
		MyActionListenerAdd listenerAdd = new MyActionListenerAdd();
		fileNew.addActionListener(listenerAdd);
		JMenuItem fileSave = new JMenuItem("Save",saveIcon);
		
		fileSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { 
					 BazaKatedri.getInstance().save();
					 BazaStudenata.getInstance().save();
					 BazaPredmeta.getInstance().save(); 
					 BazaProfesora.getInstance().save();
					 BazaAdresa.getInstance().save(); 
				} catch (IOException e1) { // TODO
					e1.printStackTrace(); 
				}
				
			}
	
		});
		JMenuItem fileClose = new JMenuItem("Close",closeIcon);
		
		JMenuItem openStudenti = new JMenuItem("Studenti",studentIcon);
		openStudenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPanel.tabovi.setSelectedIndex(0);
			}
		});
		JMenuItem openPredmeti = new JMenuItem("Predmeti",subjectIcon);
		openPredmeti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPanel.tabovi.setSelectedIndex(2);
			}
		});
		JMenuItem openProfesori = new JMenuItem("Profesori",profIcon);
		openProfesori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPanel.tabovi.setSelectedIndex(1);
			}
		});
		JMenuItem openKatedre = new JMenuItem("Katedre",tableIcon);
		openKatedre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new KatedraDialog();
			}
		});
		
		JMenuItem editEdit = new JMenuItem("Edit",editIcon);
		MyActionListenerEdit listenerEdit = new MyActionListenerEdit();
		editEdit.addActionListener(listenerEdit);
		JMenuItem editDelete = new JMenuItem("Delete",deleteIcon);
		MyActionListenerDelete listenerDelete = new MyActionListenerDelete();
		editDelete.addActionListener(listenerDelete);
		
		JMenuItem helpHelp = new JMenuItem("Help",helpIcon);
		helpHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HelpDialog();
			}
		});
		JMenuItem helpAbout = new JMenuItem("About",aboutIcon);
		helpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new AboutDialog();
			}
		});
		
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
