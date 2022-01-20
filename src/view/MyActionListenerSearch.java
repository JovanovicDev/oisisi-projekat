package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListenerSearch implements ActionListener {

	private String s;
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		switch(ViewPanel.tabIndex) {
		case 0: 
			StudentiJTable.Search(s);
			break;
		case 1:			
			ProfesoriJTable.Search(s);			
			break;
		case 2:			
			PredmetiJTable.Search(s);
			break;
		default:
			break;
		}		
	}

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

}
