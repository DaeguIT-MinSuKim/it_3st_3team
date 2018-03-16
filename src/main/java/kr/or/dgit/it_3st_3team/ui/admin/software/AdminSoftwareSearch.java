package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;

@SuppressWarnings("serial")
public class AdminSoftwareSearch extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private CmbStringComp pCmbSearch;
	private JButton btnSearch;
	private AdminSoftwareContent parent;
	private Admin admin;
	private User user;

	public AdminSoftwareSearch(Object who) {
		setUser(who);
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pSWSearch = new JPanel();
		pSWSearch.setBounds(0, 0, 1120, 42);
		add(pSWSearch);
		pSWSearch.setLayout(null);

		pCmbSearch = new CmbStringComp(); // 분류별,품목명
		pCmbSearch.setBounds(148, 9, 137, 25);
		String[] st = null;
		if (admin != null) {
			st = new String[] { "공급회사명", "품목명", "분류" };
		} else {
			st = new String[] { "품목명", "분류" };
		}
		pCmbSearch.loadData(st);
		pSWSearch.add(pCmbSearch);

		tfSearch = new JTextField();
		tfSearch.setBounds(312, 7, 615, 27);
		pSWSearch.add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.setBounds(980, 9, 97, 23);
		btnSearch.addActionListener(this);
		pSWSearch.add(btnSearch);
	}
	

	public String getTfSearch() {
		return tfSearch.getText().trim();
	}

	public void setTfSearch(String text) {
		tfSearch.setText(text);
	}

	public void requestTfFocus() {
		tfSearch.requestFocus();
	}

	public CmbStringComp getpCmbSearch() {
		return pCmbSearch;
	}

	public void setUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}

	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		Map<String, String> map = new HashMap<>();
		tfSearch.setText(tfSearch.getText().trim());

		if (!tfSearch.getText().isEmpty()) {
			String item = (String) pCmbSearch.getCmbItem();
			switch (item) {
			case "공급회사명":
				map.put("searchBy", "company");
				break;
			case "품목명":
				map.put("searchBy", "swName");
				break;
			case "분류":
				map.put("searchBy", "swGroup");
				break;
			default:
				JOptionPane.showMessageDialog(null, "그런건 없습니다.");
				return;
			}
		}
		map.put("searchText", tfSearch.getText());
		
		if (admin != null && admin.getAdminGroup().getAgAuth() == AdminGroupAuth.SALESMAN) {
			map.put("adminId", admin.getAdminId());
		}
		if (user != null) {
			map.put("userId", user.getUserId());
		}
		List<Software> li = SoftwareService.getInstance().selectSoftwareBySearch(map);
		parent.setListBySearchData(li);

	}

	public void setParent(AdminSoftwareContent parent) {
		this.parent = parent;
	}

}
