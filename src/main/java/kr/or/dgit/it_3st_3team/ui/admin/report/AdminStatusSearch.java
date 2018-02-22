package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.component.AdminGroupComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.SoftwareComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchBottom;
import kr.or.dgit.it_3st_3team.ui.component.UserComboboxComponent;

public class AdminStatusSearch extends JPanel {
	private UserComboboxComponent pUserGroup;
	private SoftwareComboboxComponent pSoftwareGroup;
	private AdminGroupComboboxComponent pAdminGroup;
	
	
	public AdminStatusSearch() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
		pUserGroup = new UserComboboxComponent();
		pUserGroup.setBounds(12, 10, 125, 30);
		add(pUserGroup);
		
		pSoftwareGroup = new SoftwareComboboxComponent();
		pSoftwareGroup.setBounds(169, 10, 125, 30);
		add(pSoftwareGroup);
		
		pAdminGroup = new AdminGroupComboboxComponent();
		pAdminGroup.setBounds(324, 10, 125, 30);
		add(pAdminGroup);
		
		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(769, 0, 425, 43);
		add(pCalendar);
		
		StatusSearchBottom pStatusSerach = new StatusSearchBottom();
		pStatusSerach.setBounds(12, 60, 1176, 31);
		add(pStatusSerach);
		setUserData();
		setSoftwareGroupData();
		setAdminGroupData();
		

	}
	
	public void setUserData() {
		User[] users = {new User("재밌는게임방"), new User("대전광역시교육청")};
		pUserGroup.loadData(users);
	}
	
	public void setSoftwareGroupData() {
		SoftwareGroup[] software = {new SoftwareGroup(1,"게임"), new SoftwareGroup(2,"사무")};
		pSoftwareGroup.loadData(software);
	}
	
	
	public void setAdminGroupData() {
		AdminGroup[] admin = {new AdminGroup("영업1팀"), new AdminGroup("영업2팀")};
		pAdminGroup.loadData(admin);
	}
	
}
	
 

