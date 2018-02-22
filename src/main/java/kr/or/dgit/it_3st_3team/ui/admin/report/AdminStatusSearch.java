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
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchComboboxBottom;
import kr.or.dgit.it_3st_3team.ui.component.UserComboboxComponent;

public class AdminStatusSearch extends JPanel {
	private SoftwareComboboxComponent pSoftwareGroup;
	private AdminGroupComboboxComponent pAdminGroup;
	private StatusSearchComboboxBottom pComboSerach;
	
	
	public AdminStatusSearch() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		pSoftwareGroup = new SoftwareComboboxComponent();
		pSoftwareGroup.setBounds(12, 10, 125, 30);
		add(pSoftwareGroup);
		
		pAdminGroup = new AdminGroupComboboxComponent();
		pAdminGroup.setBounds(149, 10, 125, 30);
		add(pAdminGroup);
		
		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(769, 0, 428, 43);
		add(pCalendar);
		
		pComboSerach = new StatusSearchComboboxBottom();
		pComboSerach.setBounds(12, 60, 1182, 30);
		add(pComboSerach);
		
		setSoftwareGroupData();
		setAdminGroupData();
		

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
	
 

