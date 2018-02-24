package kr.or.dgit.it_3st_3team.ui.table;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

public class AdminSoftwareTable extends JPanel {
	private JTable SWTable;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareTable() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pSWTable = new JPanel();
		pSWTable.setBackground(Color.WHITE);
		pSWTable.setBounds(0, 0, 1200, 605);
		add(pSWTable);
		pSWTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(12, 10, 1165, 573);
		pSWTable.add(scrollPane);
		
		SWTable = new JTable();
		SWTable.setBackground(Color.WHITE);
		SWTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		scrollPane.setViewportView(SWTable);
		
		PagingComp pPaging = new PagingComp();
		pPaging.setBackground(new Color(255, 255, 255));
		pPaging.setBounds(0, 603, 1200, 42);
		add(pPaging);
	}
	
	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		SWTable.setModel(model);
		setAlignWidth();

	}

	private Object[][] getRows() {
		
		return new Object[][] {
			{"1", "게임", "오버워치", "1", "계좌이체", "100,000원"},
			{"2", "게임", "오버워치", "5", "계좌이체", "100,000원"},
			{"3", "게임", "오버워치", "3", "계좌이체", "100,000원"}
		};
	}

	public String[] getColumNames() {

		return new String[] { "품목번호", "분류", "품목명", "공급가격", "판매가격","공급회사"};
	}

	private void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);

		tableCellWidth(200, 300, 500, 200, 400, 500);

	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = SWTable.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = SWTable.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 테이블 내용을 수정하지 못하게 하는 클래스
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
