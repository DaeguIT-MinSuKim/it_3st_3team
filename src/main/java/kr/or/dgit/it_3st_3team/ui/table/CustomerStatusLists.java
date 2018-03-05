package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JCheckBox;
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

public class CustomerStatusLists extends AbtractTableComp<SaleOrder> {

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		setTableRowHeight(30);

		setTableCellWidth(400, 500, 300, 500, 400, 500, 500, 500, 500, 500);
		
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "주문번호", "분류", "품목명", "주문수량","공급가격","판매가격", "부가세액","판매이윤","결제수단","날짜"};
	}

	@Override
	public Object[][] getRows(List<SaleOrder> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i] = list.get(i).toArrayCustomerLists();
		}
		return rows;
	}
	
}
