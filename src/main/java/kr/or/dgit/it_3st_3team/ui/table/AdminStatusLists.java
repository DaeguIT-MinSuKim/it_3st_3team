package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComponent;

@SuppressWarnings("serial")
public class AdminStatusLists<T> extends AbtractTableComponent<T> {

	public AdminStatusLists() {

	}

	@Override
	public void setTableAlignWidth() {
		setTableRowHeight(30);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		setTableCellWidth(100, 300, 200, 300, 300, 200, 200, 200, 150, 200, 300, 300);

	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "번호", "상호명", "분류", "관리자", "품목명",
				"주문수량","공급가격","판매가격","결제수단","매출금","공급회사명","판매이윤","날짜","수정/삭제"};
	}

	@Override
	public Object[][] getRows(List<T> list) {
		
		return null;
	}

}
