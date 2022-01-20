package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;
import model.BazaStudenata;
import model.Student;

public class AbstractTableModelPolozeni extends AbstractTableModel {


	private static final long serialVersionUID = -6481089898389356408L;
	BazaOcena bo;
	
	public AbstractTableModelPolozeni() {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		 bo = new BazaOcena(s);
	}

	@Override
	public int getRowCount() {
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		int len = s.getPassedExams().size();
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
