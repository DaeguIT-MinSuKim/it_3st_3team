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

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.Software;
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
public class AdminSoftwareTable extends AbtractTableComp<Software>{
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
			if(e.getActionCommand().equals("삭제")) {
				actionDeleteItem();
				JOptionPane.showMessageDialog(null, "삭제버튼 선택");
			}if(e.getActionCommand().equals("수정")) {
				actionUpdateItem();
				
			}
			
		}

		private void actionDeleteItem() {
			// TODO Auto-generated method stub
			
		}

		private void actionUpdateItem() {
			int swNo = table.getSelectedColumn();
			Software software = SoftwareService.getInstance().selectSoftwareByNo(new Software(swNo));
			AdminSoftwareRegister ar = new AdminSoftwareRegister();
			ar.setItem(software);
			
			
			
		}
	};
	
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
