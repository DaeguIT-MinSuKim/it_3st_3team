package kr.or.dgit.it_3st_3team.ui.admin.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;

@SuppressWarnings("serial")
public class AdminUserContent extends JPanel implements ActionListener {

	private AdminUserList pList;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;
	private AdminUserRegister pInputArea;

	public AdminUserContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1180, 850);

		pInputArea = new AdminUserRegister();
		pInputArea.setBounds(12, 10, 1156, 230);
		add(pInputArea);

		AdminUserSearch pSearch = new AdminUserSearch();
		pSearch.setParent(this);
		pSearch.setBounds(12, 250, 1156, 50);
		add(pSearch);

		pList = new AdminUserList();
		pList.setBounds(12, 310, 1156, 530);
		add(pList);
		
		JPopupMenu menu = new JPopupMenu();
		modifyMenu = new JMenuItem("     수정   ");
		deleteMenu = new JMenuItem("     삭제   ");
		modifyMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		menu.add(modifyMenu);
		menu.add(deleteMenu);
		pList.setPopupMenu(menu);
		
		List<User> userList = UserService.getInstance().listUserAll();
		pList.loadTableDatas(userList);
	}
	
	public void setListBySearchData(List<User> searchData) {
		pList.loadTableDatas(searchData);
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
		int no = pList.getSelectedNo();
		
		int res = JOptionPane.showConfirmDialog(null, "사용자를 삭제하시겠습니까?", "사용자 삭제", JOptionPane.OK_CANCEL_OPTION);
		if (res == JOptionPane.OK_OPTION) {
			int result = UserService.getInstance().removeUser(new User(no));
			if (result != 1) {
				JOptionPane.showMessageDialog(null, "사용자를 삭제하지 못했습니다.");
				return;
			}
			pList.removeRow(pList.getSelectedRow());
			JOptionPane.showMessageDialog(null, "사용자를 삭제하였습니다.");
		}
	}

	private void actionPerformedBtnModifyMenu(ActionEvent e) {
		int no = pList.getSelectedNo();
		
		User user = UserService.getInstance().findUserByNo(new User(no));
		pInputArea.setUserData(user);
	}
}
