package kr.or.dgit.it_3st_3team.ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;
import kr.or.dgit.it_3st_3team.ui.component.AbstractLblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;

@SuppressWarnings("serial")
public class AdminSoftwareGroupTable extends AbtractTableComp<SoftwareGroup> {
	private SoftwareGroupUI ui;

	
	public AdminSoftwareGroupTable() {
		initComponents();
	}

	private void initComponents() {
		table.setComponentPopupMenu(popup());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				ListSelectionModel model = table.getSelectionModel();
				String selSg = (String) rows[model.getAnchorSelectionIndex()][0];

			}
		});
	}

	private JPopupMenu popup() {
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem delMenu = new JMenuItem("삭제");
		popMenu.add(delMenu);
		JMenuItem updateMenu = new JMenuItem("수정");
		popMenu.add(updateMenu);
		delMenu.addActionListener(menuListener);
		updateMenu.addActionListener(menuListener);

		return popMenu;
	}

	ActionListener menuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("삭제")) {
				actionDeleteItem();
				JOptionPane.showMessageDialog(null, "삭제하셨습니다.");
			}
			if (e.getActionCommand().equals("수정")) {
				actionUpdateItem();

			}
		}

		private void actionUpdateItem() {
			ui.getpInput().setBtnTitle("수정");
			SoftwareGroup sg = (SoftwareGroup) table.getValueAt(table.getSelectedRow(), 0);
			System.out.println(sg);
			
			
		}

		private void actionDeleteItem() {
			
			String sg = table.getValueAt(table.getSelectedRow(), 0).toString();
			
			SoftwareGroupService.getInstance().deleteSoftwareGroup(new SoftwareGroup(sg));

			List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
			loadTableDatas(lists);

		}

		
	};

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
		return new String[] { "분류" };
	}

	@Override
	public Object[][] getRows(List<SoftwareGroup> list) {
		rows = new Object[list.size()][];

		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}

		return rows;
	}

	public void setUI(SoftwareGroupUI ui) {
		this.ui = ui;
	}
}
