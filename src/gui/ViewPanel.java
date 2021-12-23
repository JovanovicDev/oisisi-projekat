package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;
import java.awt.BorderLayout;


public class ViewPanel extends JPanel {


	private static final long serialVersionUID = 7445755320045782268L;
	public static int tabIndex = 0;
	
	public static JTable studentiTable;
	public static JTable  profesoriTable;
	public static  JTable predmetiTable;
	public static JTabbedPane tabovi;
	
	public ViewPanel(Dimension d) {
	

		 tabovi=new JTabbedPane();
		tabovi.setPreferredSize(new Dimension(d.width *3/4 - 50,d.height * 3/4 - 140));
		
		studentiTable=new StudentiJTable();
		JScrollPane studentPane=new JScrollPane(studentiTable);
		
		studentiTable.setFillsViewportHeight(true);
		
	
		tabovi.addTab("Studenti",studentPane);
		this.add(BorderLayout.CENTER,tabovi);
		
		 profesoriTable = new ProfesoriJTable();
		JScrollPane profesorPane=new JScrollPane(profesoriTable);
		
		profesoriTable.setFillsViewportHeight(true);
		
		tabovi.addTab("Profesori",profesorPane);
		this.add(BorderLayout.CENTER,tabovi);
		

		 predmetiTable = new PredmetiJTable();
		JScrollPane predmetiPane=new JScrollPane(predmetiTable);
		
		predmetiTable.setFillsViewportHeight(true);
		
		tabovi.addTab("Predmeti",predmetiPane);
		this.add(BorderLayout.CENTER,tabovi);
		
		tabovi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tabIndex = tabovi.getSelectedIndex();
			}
		});
		
		setVisible(true);
	}
	

	


}

