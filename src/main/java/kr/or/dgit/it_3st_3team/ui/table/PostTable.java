package kr.or.dgit.it_3st_3team.ui.table;

import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class PostTable extends AbtractTableComp<Address> {
	public PostTable() {
	}

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.LEADING, 0);

		setTableCellWidth(200);
	}

	@Override
	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "주소" };
	}

	@Override
	public Object[][] getRows(List<Address> list) {
		Object[][] rows = new Object[list.size()][];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}
	
	

}
