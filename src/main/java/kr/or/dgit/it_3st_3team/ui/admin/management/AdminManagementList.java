package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class AdminManagementList extends AbtractTableComp<Admin> {

	public AdminManagementList() {

	}

	@Override
	public void setTableAlignWidth() {
		setTableRowHeight(40);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		setTableCellWidth(100, 200, 200, 200, 200);
	}

	@Override
	public Object[] getColumnNames() {
		return new String[] { "번호", "아이디", "이름", "전화번호", "관리자 그룹" };
	}

	@Override
	public Object[][] getRows(List<Admin> list) {
		Object[][] rows = null;
		rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}

}
