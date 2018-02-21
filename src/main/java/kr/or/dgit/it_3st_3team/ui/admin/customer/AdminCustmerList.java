package kr.or.dgit.it_3st_3team.ui.admin.customer;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Customer;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComponent;

@SuppressWarnings("serial")
public class AdminCustmerList extends AbtractTableComponent<Customer> {

	/**
	 * Create the panel.
	 */
	public AdminCustmerList() {
	}

	@Override
	public void setTableAlignWidth() {
		setTableRowHeight(30);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setTableCellWidth(100, 200, 200, 200, 200, 200, 200, 200, 150, 200);
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "번호", "아이디", "상호명", "전화번호", "주소" };
	}

	@Override
	public Object[][] getRows(List<Customer> list) {
		Object[][] rows = {
				{ "1", "c_id1", "재밌는게임방", "02-2233-1123", "서울시 도봉구 어쩌구 저쩌구"},
				{ "2", "c_id2", "재없는게임방", "03-2233-1123", "서울시 도봉구 어쩌구 저쩌구"},
				{ "3", "c_id3", "재밌는게임방", "04-2233-1123", "서울시 도봉구 어쩌구 저쩌구"}
		};
		return rows;
	}

}
