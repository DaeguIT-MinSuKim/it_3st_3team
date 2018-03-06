package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbtractTableComp<T> extends JPanel {
	protected JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	public AbtractTableComp() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

	}

	public void loadTableDatas(List<T> list) {
		model = new NonEditableModel(getRows(list), getColumnNames());
		table.setModel(model);
		setTableAlignWidth();
	}

	protected void setTableRowHeight(int height) {
		table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), height));
		table.setRowHeight(height);
	}

	protected void setTableCellWidth(int... width) {
		TableColumnModel tcModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcRenderer = new DefaultTableCellRenderer();
		dtcRenderer.setHorizontalAlignment(align);

		TableColumnModel tcModel = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcModel.getColumn(idx[i]).setCellRenderer(dtcRenderer);
		}
	}

	public void setPopupMenu(JPopupMenu menu) {
		table.setComponentPopupMenu(menu);
	}

	public int getSelectedNo() {
		return (int) table.getValueAt(table.getSelectedRow(), 0);
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

	public void removeRow(int row) {
		model.removeRow(row);
	}

	public abstract void setTableAlignWidth();

	public abstract Object[] getColumnNames();

	public abstract Object[][] getRows(List<T> list);

	protected class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

}

