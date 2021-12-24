package view;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
		
		Action actionNew = new AbstractAction() {
			private static final long serialVersionUID = 7831669777280633909L;

			@Override
			   public void actionPerformed(ActionEvent e) {
					MyActionListenerAdd listener = new MyActionListenerAdd();
					listener.actionPerformed(e);
			   }

		};
	
		JButton btnNew = new JButton(actionNew);
		btnNew.setIcon(new ImageIcon("./src/Images/addSmall.jpg"));
		actionNew.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		btnNew.getActionMap().put("myAction", actionNew);
		btnNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) actionNew.getValue(Action.ACCELERATOR_KEY), "myAction");
		btnNew.setToolTipText("Nov unos.");
		this.add(btnNew);
		
		Action actionEdit = new AbstractAction() {

			private static final long serialVersionUID = 6368507878264246753L;
			@Override
			   public void actionPerformed(ActionEvent e) {
				
				
			MyActionListenerEdit listener = new MyActionListenerEdit();
			listener.actionPerformed(e);
					
			   }

		};
		
		JButton btnEdit = new JButton(actionEdit);
		btnEdit.setIcon(new ImageIcon("./src/Images/editSmall.jpg"));
		actionEdit.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		btnEdit.getActionMap().put("myAction", actionEdit);
		btnEdit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) actionEdit.getValue(Action.ACCELERATOR_KEY), "myAction");
		btnEdit.setToolTipText("Izmena postojecih podataka.");
		this.add(btnEdit);
		
		Action actionDelete = new AbstractAction() {

			private static final long serialVersionUID = -4406310354123286787L;
			@Override
			   public void actionPerformed(ActionEvent e) {
		
			   }

		};
		
		JButton btnDelete = new JButton(actionDelete);
		btnDelete.setIcon(new ImageIcon("./src/Images/deleteSmall.jpg"));
		actionDelete.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		btnDelete.getActionMap().put("myAction", actionDelete);
		btnDelete.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) actionDelete.getValue(Action.ACCELERATOR_KEY), "myAction");
		btnDelete.setToolTipText("Brisanje.");
		this.add(btnDelete);
		
		this.add(Box.createGlue());
	   
		JTextField search = new JTextField();
		search.setMaximumSize(new Dimension(5000,700));
		this.add(search);
		
		Action actionSearch = new AbstractAction() {

			private static final long serialVersionUID = -89102361834332284L;

			@Override
			   public void actionPerformed(ActionEvent e) {
			      System.out.println("Ctrl + S is pressed.");
			   }

		};
		
		addSeparator();
		setBackground(Color.LIGHT_GRAY);
		
		JButton btnSearch = new JButton(actionSearch);
		btnSearch.setIcon(new ImageIcon("./src/Images/searchSmall.jpg"));
		actionSearch.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		btnSearch.getActionMap().put("myAction", actionSearch);
		btnSearch.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) actionSearch.getValue(Action.ACCELERATOR_KEY), "myAction");
		btnSearch.setToolTipText("Pretraga.");
		this.add(btnSearch);
		
		setFloatable(false);
		setVisible(true);
	}
	
}
