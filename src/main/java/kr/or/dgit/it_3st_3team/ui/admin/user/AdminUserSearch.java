package kr.or.dgit.it_3st_3team.ui.admin.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;

@SuppressWarnings("serial")
public class AdminUserSearch extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JButton btnUserSearch;
	private CmbStringComp cmbSearchBy;
	private AdminUserContent parent;

	public AdminUserSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1160, 50);

		String[] arrSearch = { "아이디", "상호명", "전화번호" };
		cmbSearchBy = new CmbStringComp();
		cmbSearchBy.loadData(arrSearch);
		cmbSearchBy.setBounds(12, 10, 150, 30);
		add(cmbSearchBy);

		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(174, 11, 852, 30);
		add(tfSearch);

		btnUserSearch = new JButton("검색");
		btnUserSearch.addActionListener(this);
		btnUserSearch.setBounds(1051, 10, 97, 30);
		add(btnUserSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUserSearch) {
			actionPerformedBtnUserSearch(e);
		}
	}

	protected void actionPerformedBtnUserSearch(ActionEvent e) {
		Map<String, String> map = new HashMap<>();
		
		tfSearch.setText(tfSearch.getText().trim());
		if (!tfSearch.getText().isEmpty()) {
			String item = (String) cmbSearchBy.getCmbItem();
			switch (item) {
			case "아이디" : 
				map.put("searchBy", "id");
				break;
			case "상호명" : 
				map.put("searchBy", "name");
				break;
			case "전화번호" :
				map.put("searchBy", "phone");
				break;
			}
		}
		map.put("searchText", tfSearch.getText());
		List<User> listUser = UserService.getInstance().listUserBySearch(map);
		
		parent.setListBySearchData(listUser);
	}

	public void setParent(AdminUserContent adminUserContent) {
		this.parent = adminUserContent;
	}
}
