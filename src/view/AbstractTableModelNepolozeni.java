package view;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozenih;
import model.BazaStudenata;
import model.Student;

public class AbstractTableModelNepolozeni extends AbstractTableModel {


	private static final long serialVersionUID = 6471159366595247891L;
	public static BazaNepolozenih bo;
	
	public AbstractTableModelNepolozeni() {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		 bo = new BazaNepolozenih(s);
	}

	@Override
	public int getRowCount() {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		int len = s.getFailedExams().size();
		return len;
	}

	@Override
	public int getColumnCount() {
		return bo.getColumnCount()+1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return bo.getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return bo.getColumnName(column);
	}
	

}
