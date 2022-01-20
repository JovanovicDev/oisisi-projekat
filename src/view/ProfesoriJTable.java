package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfesoriJTable extends JTable {


	private static final long serialVersionUID = -5663696672979969804L;
	public static int rowSelectedIndex = -1;
	public static JTable profesorTable;
    public static TableRowSorter<TableModel> rowSorter;
  
	public ProfesoriJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		this.setSelectionBackground(new Color(245, 229, 193));
		this.setRowHeight(30);
		rowSorter= new TableRowSorter<>(this.getModel());
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				profesorTable = (JTable) e.getComponent();
				if(profesorTable.getSelectedRow()!=-1) {
					rowSelectedIndex = profesorTable.convertRowIndexToModel(profesorTable.getSelectedRow());
				}
			}
		});
		this.setAutoCreateRowSorter(true);
		
    	this.setRowSorter(rowSorter);
		
	}
	
	public static void azurirajPrikaz(String akcija, int vrednost) {
		rowSorter.setRowFilter(null);
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) ViewPanel.profesoriTable.getModel();
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
		String ime = "";
		String prezime = "";
		int length = delovi.length;
		if(length == 2) {
			
			ime = delovi[0];
			prezime = delovi[1];
		}
		else prezime = p;
		
		if(length == 1) {
		  if (p.trim().length() == 0) {
		     rowSorter.setRowFilter(null);
		  } else {
		     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ p,1));
		  }
		}
		else {
			
			  if (p.trim().length() == 0) {
				     rowSorter.setRowFilter(null);
				  } else {
				     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ime ,0));
				     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+prezime ,1));
				  }
			
		}
		
	}
	
}
