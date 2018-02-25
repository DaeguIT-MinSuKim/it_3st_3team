package kr.or.dgit.it_3st_3team.ui.table;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable.NonEditableModel;

public class AdminOrderTable extends JPanel {
	private JTable TblOrder;

	/**
	 * Create the panel.
	 */
	public AdminOrderTable() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pOrderTable = new JPanel();
		pOrderTable.setBackground(Color.WHITE);
		pOrderTable.setBounds(0, 0, 1200, 600);
		add(pOrderTable);
		pOrderTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 1165, 533);
		pOrderTable.add(scrollPane);
		
		TblOrder = new JTable();
		TblOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		scrollPane.setViewportView(TblOrder);
		
		PagingComp pPaging = new PagingComp();
		pPaging.setBackground(new Color(255, 255, 255));
		pPaging.setBounds(0, 603, 1200, 42);
		add(pPaging);
	}
	
	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		TblOrder.setModel(model);
		setAlignWidth();

	}

	private Object[][] getRows() {
		
		return new Object[][] {
			{"1", "게임", "오버워치", "1", "계좌이체", "100,000원", "2018-02-23","수정/삭제"},
			{"2", "게임", "오버워치", "5", "계좌이체", "100,000원", "2018-02-23","수정/삭제"},
			{"3", "게임", "오버워치", "3", "계좌이체", "100,000원", "2018-02-23","수정/삭제"}
		};
	}

	public String[] getColumNames() {

		return new String[] { "주문 번호", "주문 일자", "분류", "품목명", "주문수량","고객명","결제수단","담당자","공급회사"};
	}

	private void setAlignWidth() {
		// 셀의 너비와 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6,7,8);

		tableCellWidth(200, 500, 200, 400, 200, 400, 300, 400,400);

	}

	protected void tableCellWidth(int... width) {
		TableColumnModel model = TblOrder.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = TblOrder.getColumnModel();
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
