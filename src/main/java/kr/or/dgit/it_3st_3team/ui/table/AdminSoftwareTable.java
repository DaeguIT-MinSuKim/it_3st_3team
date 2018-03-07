package kr.or.dgit.it_3st_3team.ui.table;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.ibatis.exceptions.PersistenceException;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareRegister;
import kr.or.dgit.it_3st_3team.ui.component.AbtractTableComp;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class AdminSoftwareTable extends AbtractTableComp<Software> {
	private AdminSoftwareContent ac;

	public AdminSoftwareTable() {
		initComponents();
	}

	private void initComponents() {
		table.setComponentPopupMenu(createPopUpMenu());

	}

	private JPopupMenu createPopUpMenu() {
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
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "소프트웨어 삭제", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					try {
						actionDeleteItem();
					} catch (PersistenceException e2) {
						JOptionPane.showMessageDialog(null, "기본 설정은 지울 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
			if (e.getActionCommand().equals("수정")) {
				int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "소프트웨어 수정", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					actionUpdateItem();
				}
			}
		}

		private void actionDeleteItem() {
			String val = table.getValueAt(table.getSelectedRow(), 2).toString();
			Software sw = new Software();
			SoftwareService.getInstance().deleteSoftware(new Software(val));
			List<Software> lists = SoftwareService.getInstance().selectSoftwareByAll();
			loadTableDatas(lists);
		}

		private void actionUpdateItem() {
			ac.setBtnRegister("수정");
			int no = getSelectedNo();
			Software so = SoftwareService.getInstance().selectSoftwareByNo(new Software(no));
			ac.getpRegister().setSoftwareData(so);
		}
	};

	private Object[][] rows;

	@Override
	public void setTableAlignWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		setTableRowHeight(30);
		setTableCellWidth(100, 100, 200, 100, 150, 150, 200);
	}

	@Override
	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "품목번호", "분류", "품목명", "수량", "공급가격", "판매가격", "공급회사" };
	}

	@Override
	public Object[][] getRows(List<Software> list) {
		rows = new Object[list.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}

	public void setAc(AdminSoftwareContent ac) {
		this.ac = ac;
	}

}
