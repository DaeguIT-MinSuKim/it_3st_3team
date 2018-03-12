package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel implements ActionListener {

	private AdminSoftwareRegister pRegister;
	private AdminSoftwareSearch pSearch;
	private AdminSoftwareTable pTable;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;
	private User user;
	private Admin admin;

	public AdminSoftwareContent(Object who) {
		setUser(who);
		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1191, 929);
		setLayout(null);

		pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 1191, 245);
		pRegister.setParent(this);
		add(pRegister);
		
		Map<String, String> map = new HashMap<>();
		if (admin != null && admin.getAdminGroup().getAgAuth() == AdminGroupAuth.SALESMAN) {
			map.put("adminId", admin.getAdminId());
		}
		if (user != null) {
			map.put("userId", user.getUserId());
		}
		List<User> uslist = UserService.getInstance().listUserBySearch(map);
		User[] usDatas = uslist.toArray(new User[uslist.size()]);
		pRegister.loadDataByUserType(usDatas);

		pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(0, 245, 1191, 50);
		pSearch.setParent(this);
		add(pSearch);

		pTable = new AdminSoftwareTable();
		pTable.setBounds(10, 295, 1165, 554);
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
		Map<String, String> map = new HashMap<>();
		
		if (admin != null && admin.getAdminGroup().getAgAuth() == AdminGroupAuth.SALESMAN) {
			map.put("adminId", admin.getAdminId());
			pSearch.setUser(admin);
		}
		if (user != null) {
			map.put("userId", user.getUserId());
			pSearch.setUser(user);
		}
		List<Software> li = SoftwareService.getInstance().findSoftwareAllByType(map);
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

	public void setUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}

}
