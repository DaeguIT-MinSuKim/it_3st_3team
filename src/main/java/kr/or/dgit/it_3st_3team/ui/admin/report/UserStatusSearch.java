package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchPrintComp;

@SuppressWarnings("serial")
public class UserStatusSearch extends JPanel {

	private CmbSoftwareGroupComp pSoftwareGroup;

	public UserStatusSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pSoftwareGroup = new CmbSoftwareGroupComp();
		pSoftwareGroup.setBounds(0, 10, 125, 30);

		add(pSoftwareGroup);

		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(758, 0, 425, 43);
		add(pCalendar);

		TfBtnSearchPrintComp pStatusSearch = new TfBtnSearchPrintComp();
		pStatusSearch.setBounds(0, 60, 1176, 31);
		add(pStatusSearch);
		setSoftwareGroupData();
	}

	public void setSoftwareGroupData() {
		SoftwareGroup[] software = { new SoftwareGroup(1, "게임"), new SoftwareGroup(2, "사무") };
		pSoftwareGroup.loadData(software);
	}

}
