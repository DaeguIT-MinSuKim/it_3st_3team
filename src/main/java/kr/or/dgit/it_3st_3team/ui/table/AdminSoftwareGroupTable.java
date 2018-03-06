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

import org.apache.ibatis.exceptions.PersistenceException;

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

		private String sg;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("삭제")) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "분류삭제", JOptionPane.OK_CANCEL_OPTION);
				if(result==0) {
					try {
						actionDeleteItem();
					} catch (PersistenceException e2) {
						JOptionPane.showMessageDialog(null, "기본 설정은 지울 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
				}
				
			}
			if (e.getActionCommand().equals("수정")) {
				int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "분류명 수정", JOptionPane.OK_CANCEL_OPTION);
				if(result==0) {
					actionUpdateItem();
				}
				

			}
		}

		private void actionUpdateItem() {
			ui.getpInput().setBtnTitle("수정");
			sg = table.getValueAt(table.getSelectedRow(), 0).toString();
			ui.getpInput().setTfText(sg);
			
			
			
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
