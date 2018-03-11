package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel implements ActionListener{

	private AdminSoftwareRegister pRegister;
	private AdminSoftwareSearch pSearch;
	private AdminSoftwareTable pTable;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;
	
	

	
	


	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1191, 929);
		setLayout(null);

		pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 1191, 209);
		pRegister.setParent(this);
		add(pRegister);

		pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(0, 208, 1191, 50);
		pSearch.setParent(this);
		add(pSearch);

		pTable = new AdminSoftwareTable();
		pTable.setBounds(10, 258, 1165, 594);
		add(pTable);
		
		JPopupMenu menu = new JPopupMenu();
		modifyMenu = new JMenuItem("     수정   ");
		deleteMenu = new JMenuItem("     삭제   ");
		modifyMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		menu.add(modifyMenu);
		menu.add(deleteMenu);
		pTable.setPopupMenu(menu);
		
		reFreshList();
		
	}

	public void reFreshList() {
		List<Software> li = SoftwareService.getInstance().selectSoftwareByAll();
		pTable.loadTableDatas(li);
	}
	
	public void setListBySearchData(List<Software> searchData) {
		pTable.loadTableDatas(searchData);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modifyMenu) {
			actionPerformedBtnModifyMenu(e);
		} else if (e.getSource() == deleteMenu) {
			actionPerformedBtnDeleteMenu(e);
		}
	}

	private void actionPerformedBtnDeleteMenu(ActionEvent e) {
		int no = pTable.getSelectedNo();

		int res = JOptionPane.showConfirmDialog(null, "사용자를 삭제하시겠습니까?", "사용자 삭제", JOptionPane.OK_CANCEL_OPTION);
		if (res == JOptionPane.OK_OPTION) {
			int result = SoftwareService.getInstance().deleteSoftwareColumn(new Software(no));
			if (result != 1) {
				JOptionPane.showMessageDialog(null, "사용자를 삭제하지 못했습니다.");
				return;
			}
			reFreshList();
			pRegister.resetData();
			JOptionPane.showMessageDialog(null, "사용자를 삭제하였습니다.");
		}
	}
	
	private void actionPerformedBtnModifyMenu(ActionEvent e) {
		int no = pTable.getSelectedNo();

		Software software = SoftwareService.getInstance().selectSoftwareByNo(new Software(no));
		pRegister.setSoftwareData(software);
	}
	
	
	
}
