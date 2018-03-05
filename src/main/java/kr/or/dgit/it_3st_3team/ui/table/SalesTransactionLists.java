package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class SalesTransactionLists extends AbtractTableComp<SaleOrder> {

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);

		setTableRowHeight(30);

		setTableCellWidth(300, 300, 200, 300, 200, 300, 300, 300);

	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "주문날짜", "고객명", "분류", "품목명", "주문수량", "공급가격", "세금", "총납품금액" };
	}

	@Override
	public Object[][] getRows(List<SaleOrder> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArrayTransaction();
		}
		return rows;
	}

}
