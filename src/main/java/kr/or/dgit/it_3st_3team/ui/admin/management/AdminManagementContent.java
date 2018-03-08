package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.service.AdminService;

@SuppressWarnings("serial")
public class AdminManagementContent extends JPanel implements ActionListener {

	private AdminManagementList pDataArea;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;
	private AdminManagementRegister pInputArea;

	public AdminManagementContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1180, 850);

		pInputArea = new AdminManagementRegister();
		//pInputArea.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		pInputArea.setBounds(10, 10, 1160, 235);
		pInputArea.setLayout(null);
		pInputArea.setParent(this);
		add(pInputArea);

		AdminManagementSearch pSearchArea = new AdminManagementSearch();
		pSearchArea.setBounds(10, 250, 1158, 50);
		pSearchArea.setLayout(null);
		pSearchArea.setParent(this);
		add(pSearchArea);

		pDataArea = new AdminManagementList();
		pDataArea.setBounds(10, 310, 1158, 530);
		add(pDataArea);
		
		JPopupMenu menu = new JPopupMenu();
		modifyMenu = new JMenuItem("     수정   ");
		deleteMenu = new JMenuItem("     삭제   ");
		modifyMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		menu.add(modifyMenu);
		menu.add(deleteMenu);
		
		pDataArea.setPopupMenu(menu);
		
		reFreshAdminList();
	}

	public void setListBySearchData(List<Admin> searchData) {
		pDataArea.loadTableDatas(searchData);
	}
	
	public void reFreshAdminList() {
		pDataArea.loadTableDatas(AdminService.getInstance().listAdminAll());
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
		int no = pDataArea.getSelectedNo();
		if (isDefaultAdmin(no)) {
			return;
		}

		int res = JOptionPane.showConfirmDialog(null, "관리자를 삭제하시겠습니까?", "관리자 삭제", JOptionPane.OK_CANCEL_OPTION);
		if (res == JOptionPane.OK_OPTION) {
			int result = AdminService.getInstance().removeAdmin(new Admin(no));
			if (result != 1) {
				JOptionPane.showMessageDialog(null, "관리자를 삭제하지 못했습니다.");
				return;
			}
			reFreshAdminList();
			pInputArea.resetData();
			JOptionPane.showMessageDialog(null, "관리자를 삭제하였습니다.");
		}
	}

	private boolean isDefaultAdmin(int no) {
		if (no == 1) {
			JOptionPane.showMessageDialog(null, "기본 관리자는 수정 및 삭제할 수 없습니다.");
			return true;
		}
		return false;
	}

	private void actionPerformedBtnModifyMenu(ActionEvent e) {
		int no = pDataArea.getSelectedNo();
		if (isDefaultAdmin(no)) {
			return;
		}
		
		Admin admin = AdminService.getInstance().findAdminByNo(new Admin(no));
		pInputArea.setAdminData(admin);
	}
}
