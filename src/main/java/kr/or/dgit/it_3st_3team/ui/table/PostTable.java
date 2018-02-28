package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.ui.SearchPostUI;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class PostTable extends AbtractTableComp<Address> {
	private SearchPostUI ui;
	private Object[][] rows;
	
	public PostTable(SearchPostUI ui) {
		this.ui = ui;
		initComponents();
	}

	private void initComponents() {
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				ListSelectionModel model = table.getSelectionModel();
				String addr1 = (String)rows[model.getAnchorSelectionIndex()][0];
				ui.getpInputAddr().setTfAddress1(addr1);
				
			}

		});
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
		rows = new Object[list.size()][];

		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}

}
