package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListenerAdd implements ActionListener {



	@Override
	public void actionPerformed(ActionEvent e) {
		switch(ViewPanel.tabIndex) {
		case 0: 
			new StudentDialog();
			break;
		case 1:
			new ProfesorDialog();
			break;
		default:
			
			break;
		}
		
	}

	
	
}
