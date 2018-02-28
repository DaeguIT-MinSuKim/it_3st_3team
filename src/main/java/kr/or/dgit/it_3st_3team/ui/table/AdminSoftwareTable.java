package kr.or.dgit.it_3st_3team.ui.table;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminSoftwareTable extends AbtractTableComp<Software> {
	private Object[][] rows;
	
	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0,1,2,3,4,5,6);
		setTableRowHeight(30);
		setTableCellWidth(100,100,200,100,150,150,200);
		
	}

	@Override
	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"품목번호","분류","품목명","수량","공급가격","판매가격","공급회사"};
	}

	@Override
	public Object[][] getRows(List<Software> list) {
		rows = new Object[list.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		
		return rows;
	}
	
}
