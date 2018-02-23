package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;

import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbUserComp;

import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;

import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchPrintComp;

public class AdminSalesStatusSearch extends JPanel {

	private CmbUserComp pUserGroup;
	private CmbSoftwareGroupComp pSoftwareGroup;

	public AdminSalesStatusSearch() {

		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		pUserGroup = new CmbUserComp();
		pUserGroup.setBounds(12, 10, 125, 30);
		add(pUserGroup);

		pSoftwareGroup = new CmbSoftwareGroupComp();
		pSoftwareGroup.setBounds(169, 10, 125, 30);

		add(pSoftwareGroup);

		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(769, 10, 428, 43);
		add(pCalendar);

		TfBtnSearchPrintComp pStatusSearch = new TfBtnSearchPrintComp();
		pStatusSearch.setBounds(12, 60, 1176, 40);
		add(pStatusSearch);

		setUserData();
		setSoftwareGroupData();
	}

	public void setUserData() {
		User[] users = { new User("재밌는게임방"), new User("대전광역시교육청") };
		pUserGroup.loadData(users);
	}

	public void setSoftwareGroupData() {
		SoftwareGroup[] software = { new SoftwareGroup(1, "게임"), new SoftwareGroup(2, "사무") };
		pSoftwareGroup.loadData(software);
	}

}
