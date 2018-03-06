package kr.or.dgit.it_3st_3team.ui.admin.user;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;


@SuppressWarnings("serial")
public class AdminUserList extends AbtractTableComp<User> {

	public AdminUserList() {
	}

	@Override
	public void setTableAlignWidth() {
		setTableRowHeight(40);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		setTableCellWidth(80, 150, 200, 200, 250, 200, 150, 100, 400);
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "번호", "아이디", "상호명", "전화번호", "이메일", "사용자 그룹", "담당자", "우편번호", "주소" };
	}

	@Override
	public Object[][] getRows(List<User> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}

}
