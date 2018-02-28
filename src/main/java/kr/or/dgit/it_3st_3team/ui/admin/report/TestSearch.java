package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;

@SuppressWarnings("serial")
public class TestSearch extends JPanel {
	protected JTextField tfSearch;
	protected DefaultComboBoxModel<SoftwareGroup> dcbm;
	private SoftwareGroupService swgService;
	private AdminService adService;
	private JComboBox<SoftwareGroup> cmbSwgType;
	private JComboBox<Admin> cmbAdmin;
	private JComboBox<String> cmbString;
	private StartAndEndDate pCalendar;

	public TestSearch() {
		swgService = SoftwareGroupService.getInstance();
		adService = AdminService.getInstance();
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pCalendar = new StartAndEndDate();
		pCalendar.setBounds(744, 0, 434, 43);
		add(pCalendar);

		cmbSwgType = new JComboBox<>();
		cmbSwgType.setBounds(12, 10, 125, 30);
		add(cmbSwgType);
		setCmbSgGroup();

		cmbAdmin = new JComboBox<>();
		cmbAdmin.setBounds(161, 10, 125, 30);
		add(cmbAdmin);
		setCmbAdGroup();

		cmbString = new JComboBox<>();
		cmbString.setBounds(12, 58, 125, 30);
		add(cmbString);
		setCmbString();

		tfSearch = new JTextField();
		tfSearch.setBounds(161, 59, 300, 30);
		add(tfSearch);
		tfSearch.setColumns(10);
	}

	public void setCmbSgGroup() {
		// 분류 콤보박스 넣는 코드
		List<SoftwareGroup> swg = new ArrayList<>();
		swg = swgService.selectSoftwareGroupByAll();
		swg.add(0, new SoftwareGroup("분류"));
		SoftwareGroup[] items = new SoftwareGroup[swg.size()];
		swg.toArray(items);
		DefaultComboBoxModel<SoftwareGroup> dcbm = new DefaultComboBoxModel<>(items);
		cmbSwgType.setModel(dcbm);
	}

	public void setCmbAdGroup() {
		// 관리자 콤보박스 넣는 코드
		List<Admin> ad = new ArrayList<>();
		ad = adService.selectAdminAll();
		ad.add(0, new Admin("관리자"));
		Admin[] items = new Admin[ad.size()];
		ad.toArray(items);
		DefaultComboBoxModel<Admin> dcbm = new DefaultComboBoxModel<>(items);
		cmbAdmin.setModel(dcbm);
	}

	public void setCmbString() {
		// 검색필드 콤보박스 넣는 코드
		String[] st = { "고객명", "공급회사명", "품목명" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(st);
		cmbString.setModel(dcbm);
	}

	public void settingAdmin() {

	}

	//get 메소드
	public SoftwareGroup getSelectedSoftwareGrp() {
		return (SoftwareGroup) cmbSwgType.getSelectedItem();
	}
	
	public Admin getSelectedAdmin() {
		return (Admin) cmbAdmin.getSelectedItem();
	}
	
	public String getSelectedString() {
		return (String) cmbString.getSelectedItem();
	}
	
	public String getStartDate() {
		return pCalendar.getStartDate();
	}
	
	public String getEndDate() {
		return pCalendar.getEndDate();
	}
	
	public String getSearchText() {
		return tfSearch.getText().trim();
	}
}
