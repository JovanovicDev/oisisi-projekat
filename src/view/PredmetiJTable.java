package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PredmetiJTable extends JTable {
	

	private static final long serialVersionUID = -7326079776292848557L;
	public static int rowSelectedIndex = -1;
	public static JTable predmetiTable;
	public static TableRowSorter<TableModel> rowSorter;

	public PredmetiJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setSelectionBackground(new Color(245, 229, 193));
		this.setRowHeight(30);
		rowSorter
	    = new TableRowSorter<>(this.getModel());
		this.setRowSorter(rowSorter);
		this.setAutoCreateRowSorter(true);
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				predmetiTable = (JTable) e.getComponent();
				if(predmetiTable.getSelectedRow()!=-1) {
					rowSelectedIndex = predmetiTable.convertRowIndexToModel(predmetiTable.getSelectedRow());
				}
			}
			});
		
	}
	
	public static void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) ViewPanel.predmetiTable.getModel();
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

		  if (p.trim().length() == 0) {
		     rowSorter.setRowFilter(null);
		  } else {
		     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ p,1));
		  }
	}
}
