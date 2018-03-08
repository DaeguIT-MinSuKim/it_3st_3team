package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class CustomerStatusLists extends AbtractTableComp<SaleOrder> {

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 6, 7, 8);
		setTableCellAlign(SwingConstants.RIGHT, 4, 5);
		setTableRowHeight(40);

		setTableCellWidth(150, 200, 300, 150, 300, 300, 300, 300, 300);

	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "주문번호", "분류", "품목명", "주문수량", "구매금액", "부가세액", "결제수단", "공급회사명", "날짜" };
	}

	@Override
	public Object[][] getRows(List<SaleOrder> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rows[i] = list.get(i).toArrayCustomerLists();
		}
		return rows;
	}

}
