package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;

@SuppressWarnings("serial")
public class AdminManagementSearch extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JButton button;
	private CmbStringComp cmbSearchBy;
	private AdminManagementContent parent;

	public AdminManagementSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1160, 50);

		String[] items = { "아이디", "이름", "직책" };
		cmbSearchBy = new CmbStringComp();
		cmbSearchBy.setBounds(231, 9, 125, 30);
		cmbSearchBy.loadData(items);
		add(cmbSearchBy);

		tfSearch = new JTextField();
		tfSearch.setHorizontalAlignment(SwingConstants.LEFT);
		tfSearch.setColumns(10);
		tfSearch.setBounds(392, 10, 500, 30);
		add(tfSearch);

		button = new JButton("검색");
		button.addActionListener(this);
		button.setBounds(932, 9, 97, 30);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
	}

	protected void actionPerformedButton(ActionEvent e) {
		Map<String, String> map = new HashMap<>();
		
		tfSearch.setText(tfSearch.getText().trim());
		if (!tfSearch.getText().isEmpty()) {
			String item = (String) cmbSearchBy.getCmbItem();
			switch (item) {
			case "아이디" : 
				map.put("searchBy", "id");
				break;
			case "이름" : 
				map.put("searchBy", "name");
				break;
			case "직책" :
				map.put("searchBy", "agName");
				break;
			}
		}
		map.put("searchText", tfSearch.getText());
		
		List<Admin> listAdmin = AdminService.getInstance().listAdminBySearch(map);
		
		parent.setListBySearchData(listAdmin);
	}
	
	public void setParent(AdminManagementContent adminMgn) {
		this.parent = adminMgn;
	}
}
