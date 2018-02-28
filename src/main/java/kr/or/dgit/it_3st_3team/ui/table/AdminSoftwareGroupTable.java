package kr.or.dgit.it_3st_3team.ui.table;

import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AdminSoftwareGroupTable extends AbtractTableComp<SoftwareGroup> {
	
	
	public AdminSoftwareGroupTable() {
		initComponents();
	}
	private void initComponents() {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				ListSelectionModel model = table.getSelectionModel();
				String selSg = (String)rows[model.getAnchorSelectionIndex()][0];
				
				
			}
		});
	}
	private Object[][] rows;
	
	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0);
		setTableRowHeight(30);
		setTableCellWidth(200);
		
	}

	@Override
	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"분류"};
	}

	@Override
	public Object[][] getRows(List<SoftwareGroup> list) {
		rows = new Object[list.size()][];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		
		return rows;
	}


	
}
