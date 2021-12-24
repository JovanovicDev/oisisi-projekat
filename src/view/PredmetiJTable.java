package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiJTable extends JTable {
	

	private static final long serialVersionUID = -7326079776292848557L;

	public PredmetiJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setSelectionBackground(new Color(245, 229, 193));
		this.setRowHeight(30);
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

}
