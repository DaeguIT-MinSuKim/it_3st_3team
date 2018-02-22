package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchBottom;
import kr.or.dgit.it_3st_3team.ui.component.SoftwareComboboxComponent;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;

public class CompanyStatusSearch extends JPanel {

	
	private SoftwareComboboxComponent pSoftwareGroup;
	public CompanyStatusSearch() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		pSoftwareGroup = new SoftwareComboboxComponent();
		pSoftwareGroup.setBounds(12, 10, 125, 30);
		
		add(pSoftwareGroup);
		
		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(769, 0, 425, 43);
		add(pCalendar);
		
		StatusSearchBottom pStatusSearch = new StatusSearchBottom();
		pStatusSearch.setBounds(12, 60, 1176, 31);
		add(pStatusSearch);
		setSoftwareGroupData();
	}
	public void setSoftwareGroupData() {
		SoftwareGroup[] software = {new SoftwareGroup(1,"게임"), new SoftwareGroup(2,"사무")};
		pSoftwareGroup.loadData(software);
	}

}
