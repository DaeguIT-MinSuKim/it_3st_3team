package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

public class AdminSalesStatusLists extends AbtractTableComp<Admin> {

	@Override
	public void setTableAlignWidth() {
		// 셀의 너비와 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6,7,8,9,10,11);

		setTableCellWidth(200, 500, 300, 500, 200, 500, 500, 500, 500, 500, 500, 500);		
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "번호", "상호명", "분류", "품목명", "주문수량", "공급가격","판매가격","결제수단","매출금","날짜","공급회사명","판매이윤"};

	}

	@Override
	public Object[][] getRows(List<Admin> list) {
		return new Object[][] {
			{"1", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원"},
			{"2", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원"},
			{"3", "재밌는PC방", "게임", "오버워치", "3", "120,000원","150,000원","계좌이체","100,000원","2018-02-23","알럽소프트","100,000원"}
		};
	}
	

}
