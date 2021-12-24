package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesoriJTable extends JTable {


	private static final long serialVersionUID = -5663696672979969804L;
	public static int rowSelectedIndex = -1;
	public static JTable profesorTable;

	public ProfesoriJTable() {
		
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				profesorTable = (JTable) e.getComponent();
				if(profesorTable.getSelectedRow()!=-1) {
					rowSelectedIndex = profesorTable.convertRowIndexToModel(profesorTable.getSelectedRow());
				}
			}
			});
	
	
	}
	
	public static void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) ViewPanel.profesoriTable.getModel();
		model.fireTableDataChanged();
		
	}
	
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
