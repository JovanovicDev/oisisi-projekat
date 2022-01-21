package view;


import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Profesor;

public class AbstractTableModelPredavaniPredmeti extends AbstractTableModel {


	private static final long serialVersionUID = -6481089898389356408L;
	public static BazaPredmeta bp;
	public static BazaProfesora bprof;
	
	public AbstractTableModelPredavaniPredmeti() {
		Profesor p = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
		bp = new BazaPredmeta(p);
		bprof = BazaProfesora.getInstance();
	}

	@Override
	public int getRowCount() {
		Profesor p = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
		int len = p.getSubjectsList().size();
		return len;
	}

	@Override
	public int getColumnCount() {
		return bp.getColumnCount()+1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return bp.getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return bp.getColumnName(column);
	}

}
