package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.SoftwareComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchBottom;
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchComboboxBottom;
import kr.or.dgit.it_3st_3team.ui.component.UserComboboxComponent;

public class AdminSalesStatusSearch extends JPanel {
	private UserComboboxComponent pUserGroup;
	private SoftwareComboboxComponent pSoftwareGroup;
	private StatusSearchComboboxBottom panel_1;
	
	public AdminSalesStatusSearch() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		pUserGroup = new UserComboboxComponent();
		pUserGroup.setBounds(12, 10, 125, 30);
		add(pUserGroup);
		
		pSoftwareGroup = new SoftwareComboboxComponent();
		pSoftwareGroup.setBounds(149, 10, 125, 30);
		add(pSoftwareGroup);
		
		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(769, 10, 428, 43);
		add(pCalendar);
		
		panel_1 = new StatusSearchComboboxBottom();
		panel_1.setBounds(12, 60, 1182, 40);
		add(panel_1);
		setUserData();
		setSoftwareGroupData();
	}
	
	public void setUserData() {
		User[] users = {new User("재밌는게임방"), new User("대전광역시교육청")};
		pUserGroup.loadData(users);
	}
	
	public void setSoftwareGroupData() {
		SoftwareGroup[] software = {new SoftwareGroup(1,"게임"), new SoftwareGroup(2,"사무")};
		pSoftwareGroup.loadData(software);
	}

}
