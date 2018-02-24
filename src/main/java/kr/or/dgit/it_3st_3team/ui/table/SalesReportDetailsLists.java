package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SalesReportDetailsLists extends JPanel {
	protected JTable table;

	public SalesReportDetailsLists() {

		initComponents();

	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		scrollPane.setViewportView(table);
	}

	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		table.setModel(model);
		setAlignWidth();

	}

	private Object[][] getRows() {
		return new Object[][] { { "2018-02-23", "재밌는피시방", "한컴오피스", "3", "120,000원", "150,000원", "12,000원", "100,000원" },
				{ "2018-02-23", "아산시스템", "인디자인", "2", "120,000원", "150,000원", "12,000원", "100,000원" },
				{ "2018-02-23", "충청남도교육청", "바람의제국", "5", "120,000원", "150,000원", "12,000원", "100,000원" } };
	}

	public String[] getColumNames() {
		return new String[] { "기간", "분류", "품목명", "수량", "판매금액", "판매이윤", "매출금" };

	}

	private void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
		tableCellWidth(500, 500, 400, 500, 200, 500, 500, 500);

	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}
