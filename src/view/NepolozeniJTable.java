package view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import  java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.awt.Color;

public class NepolozeniJTable extends JTable {

	private static final long serialVersionUID = -2380068608318367706L;
	public static JTable nepolozeniTable;
	public static int rowSelectedIndex = -1;

public NepolozeniJTable() {	
	
	this.setRowSelectionAllowed(true);
	this.setColumnSelectionAllowed(true);
	this.getTableHeader().setReorderingAllowed(false);
	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.setModel(new AbstractTableModelNepolozeni());
	this.setSelectionBackground(new Color(245, 229, 193));
	this.setRowHeight(30);
	
	this.addMouseListener(new MouseAdapter() {
		public void mouseReleased(MouseEvent e) {
			nepolozeniTable = (JTable) e.getComponent();
			if(nepolozeniTable.getSelectedRow()!=-1) {
				rowSelectedIndex = nepolozeniTable.convertRowIndexToModel(nepolozeniTable.getSelectedRow());
			}
		}
		});
			
}

public static void azurirajPrikaz(String akcija, int vrednost) {
	AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) StudentDialog.nepolozeniIspitiTable.getModel();
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

}