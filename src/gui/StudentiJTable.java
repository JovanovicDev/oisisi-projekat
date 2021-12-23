package gui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;

public class StudentiJTable extends JTable {

	
	private static final long serialVersionUID = -2380068608318367706L;

public StudentiJTable() {	
	
	this.setRowSelectionAllowed(true);
	this.setColumnSelectionAllowed(true);
	this.getTableHeader().setReorderingAllowed(false);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.setModel(new AbstractTableModelStudenti());
			
}

public static void azurirajPrikaz(String akcija, int vrednost) {
	AbstractTableModelStudenti model = (AbstractTableModelStudenti) ViewPanel.studentiTable.getModel();
	model.fireTableDataChanged();
	
}

@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	Component c = super.prepareRenderer(renderer, row, column);

	if (isRowSelected(row)) {
		c.setBackground(Color.LIGHT_GRAY);
	} else {
		c.setBackground(Color.WHITE);
	}
	
	return c;
	}
}
