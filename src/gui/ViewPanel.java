package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.BorderLayout;


public class ViewPanel extends JPanel {


	private static final long serialVersionUID = 7445755320045782268L;

	public ViewPanel(Dimension d) {
	

		JTabbedPane tabovi=new JTabbedPane();
		tabovi.setPreferredSize(new Dimension(d.width *3/4 - 50,d.height * 3/4 - 140));
		
		StudentiJTable studentiTable=new StudentiJTable();
		JScrollPane studentPane=new JScrollPane(studentiTable);
		
		studentiTable.setFillsViewportHeight(true);
		
	
		tabovi.addTab("Studenti",studentPane);
		this.add(BorderLayout.CENTER,tabovi);
		
		ProfesoriJTable profesoriTable = new ProfesoriJTable();
		JScrollPane profesorPane=new JScrollPane(profesoriTable);
		
		profesoriTable.setFillsViewportHeight(true);
		
		tabovi.addTab("Profesori",profesorPane);
		this.add(BorderLayout.CENTER,tabovi);
		

		PredmetiJTable predmetiTable = new PredmetiJTable();
		JScrollPane predmetiPane=new JScrollPane(predmetiTable);
		
		predmetiTable.setFillsViewportHeight(true);
		
		tabovi.addTab("Predmeti",predmetiPane);
		this.add(BorderLayout.CENTER,tabovi);
		
		
		setVisible(true);
	}

}

