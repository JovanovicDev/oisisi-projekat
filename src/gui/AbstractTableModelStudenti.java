package gui;

import javax.swing.table.AbstractTableModel;
import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {


	private static final long serialVersionUID = -6481089898389356408L;
	
	
	public AbstractTableModelStudenti() {
		BazaStudenata.getInstance();
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
		
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount()+1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}

}
