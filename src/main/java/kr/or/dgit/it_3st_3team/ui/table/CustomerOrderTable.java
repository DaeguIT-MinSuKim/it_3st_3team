package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class CustomerOrderTable extends AbtractTableComp<Software>{
	
	
	
	public CustomerOrderTable() {
	
	}
	
	private Object[][] rows;

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		setTableRowHeight(40);
		setTableCellWidth(100, 100, 200, 100, 150, 200);
	}

	@Override
	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"상품 번호","분류","품목명","수량","판매가격","공급회사"};
	}

	@Override
	public Object[][] getRows(List<Software> list) {
		rows = new Object[list.size()][];
		for (int i = 0; i < rows.length; i++) {
			
			rows[i] = list.get(i).toArrayOrder();
			
		}
		return rows;
	}

}
