package kr.or.dgit.it_3st_3team.ui.user;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbUserComp;
import javax.swing.JTextField;

import java.util.List;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustomerOrderSearch extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private CmbSoftwareGroupComp pCmbSwgroup;
	private CmbUserComp pCmbPC;
	private JButton btnSearch;
	private CustomerOrderContent parent;
	private JButton btnClear;


	public CustomerOrderSearch() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pSwSearch = new JPanel();
		pSwSearch.setBounds(0, 0, 1120, 42);
		add(pSwSearch);
		pSwSearch.setLayout(null);

		List<SoftwareGroup> softwaregroup = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		softwaregroup.add(0, new SoftwareGroup("분류"));
		SoftwareGroup[] sgDatas = softwaregroup.toArray(new SoftwareGroup[softwaregroup.size()]);

		pCmbSwgroup = new CmbSoftwareGroupComp();
		pCmbSwgroup.setBounds(58, 8, 137, 25);
		pCmbSwgroup.loadData(sgDatas);
		pSwSearch.add(pCmbSwgroup);

		List<User> user = UserService.getInstance().listUserAllByUserGroup(UserGroup.COMPANY);
		User username = new User();
		username.setName("제작사");
		user.add(0, username);
		User[] usDatas = user.toArray(new User[user.size()]);

		pCmbPC = new CmbUserComp();
		pCmbPC.setBounds(207, 8, 137, 25);
		pCmbPC.loadData(usDatas);
		pSwSearch.add(pCmbPC);

		tfSearch = new JTextField();
		tfSearch.setBounds(374, 8, 410, 27);
		pSwSearch.add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(809, 10, 97, 23);
		pSwSearch.add(btnSearch);

		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);
		btnClear.setBounds(918, 10, 97, 23);
		pSwSearch.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		SoftwareGroup swg = (SoftwareGroup) pCmbSwgroup.getCmbItem();
		User us = (User) pCmbPC.getCmbItem();
		String name = tfSearch.getText().trim();

		Software sw = new Software();

		if (!name.isEmpty()) {
			sw.setSwName(name);
		}
		if (swg.getSgName().equals("분류")) {
			swg = new SoftwareGroup();
		}
		if (us.getName().equals("제작사")) {
			us = new User();
		}

		sw.setSwGroup(swg);
		sw.setUserNo(us);

		List<Software> software = SoftwareService.getInstance().findSoftwareByOrder(sw);
		parent.setListBySearchData(software);
	}

	public void setParent(CustomerOrderContent customer) {
		this.parent = customer;
	}
	

	public void clearData() {
		pCmbSwgroup.setCmbSelectIndex(0);
		pCmbPC.setCmbSelectIndex(0);
		tfSearch.setText("");
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		parent.reFreshList();
		clearData();
	}
}
