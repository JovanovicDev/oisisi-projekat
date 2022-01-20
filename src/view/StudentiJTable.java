package view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import  java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.awt.Color;

public class StudentiJTable extends JTable {

	private static final long serialVersionUID = -2380068608318367706L;
	public static JTable StudentTable;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<TableModel> rowSorter;

public StudentiJTable() {	
	
	this.setRowSelectionAllowed(true);
	this.setColumnSelectionAllowed(true);
	this.getTableHeader().setReorderingAllowed(false);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.setModel(new AbstractTableModelStudenti());
	this.setSelectionBackground(new Color(245, 229, 193));
	this.setRowHeight(30);
	rowSorter= new TableRowSorter<>(this.getModel());
	
	this.addMouseListener(new MouseAdapter() {
		public void mouseReleased(MouseEvent e) {
			StudentTable = (JTable) e.getComponent();
			if(StudentTable.getSelectedRow()!=-1) {
				rowSelectedIndex = StudentTable.convertRowIndexToModel(StudentTable.getSelectedRow());
			}
		}
	});
	this.setAutoCreateRowSorter(true);
	this.setRowSorter(rowSorter);
}

public static void azurirajPrikaz(String akcija, int vrednost) {
	rowSorter.setRowFilter(null);
	AbstractTableModelStudenti model = (AbstractTableModelStudenti) ViewPanel.studentiTable.getModel();
	model.fireTableDataChanged();
}

@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	Component c = super.prepareRenderer(renderer, row, column);
	
		if (isRowSelected(row)) {
			c.setBackground(new Color(245, 229, 193));
		} else {
			c.setBackground(Color.WHITE);
		}
		 
     Color color1 = Color.LIGHT_GRAY;
     Color color2 = Color.WHITE;
     if(!c.getBackground().equals(getSelectionBackground())) {
        Color color = (row % 2 == 0 ? color1 : color2);
        c.setBackground(color);
        color = null;
     }
	return c;
}

public static void Search(String p) {
	
	String delovi[] = p.split(",");
	String indeks = "";
	String ime = "";
	String prezime = "";
	int length = delovi.length;
	if(length == 3) {
		indeks = delovi[0];
		ime = delovi[1];
		prezime = delovi[2];
	} else if(length == 2) {
		prezime = delovi[0];
		ime = delovi[1];
	}
	else prezime = p;
	
	if(length == 1) {
		  if (p.trim().length() == 0) {
		     rowSorter.setRowFilter(null);
		  } else {
		     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ prezime,2));
		  }
	} else if(length == 2) {
		  if (p.trim().length() == 0) {
			 rowSorter.setRowFilter(null);
		  } else {
			 rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ ime,1));
			 rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ prezime,2));
		  }
	} else {
		if (p.trim().length() == 0) {
			 rowSorter.setRowFilter(null);
		  } else {
			 rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ indeks,0));
			 rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ ime,1));
			 rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ prezime,2));
		  }
	}
	
}

}
