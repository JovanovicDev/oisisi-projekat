package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {

	

	private static final long serialVersionUID = 6795853659653572983L;

	public AbstractTableModelProfesori() {
		BazaProfesora.getInstance();	
	}
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
		
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount()+1;
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

}
