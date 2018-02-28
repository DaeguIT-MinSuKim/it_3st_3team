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
	private JTextField tfSearch;
	protected DefaultComboBoxModel<SoftwareGroup> dcbm;
	private JComboBox<SoftwareGroup> cmbSwgType;
	private SoftwareGroupService swgService;
	private AdminService adService;
	private JComboBox<Admin> cmbAdmin;
	private JComboBox<String> cmbString;
	
	public TestSearch() {
		swgService = SoftwareGroupService.getInstance();
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		
				StartAndEndDate pCalendar = new StartAndEndDate();
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
		/*// 관리자 콤보박스 넣는 코드
		List<Admin> ad = new ArrayList<>();
		ad = adService
		ad.add(0, new SoftwareGroup("분류"));
		SoftwareGroup[] items = new SoftwareGroup[swg.size()];
		ad.toArray(items);
		DefaultComboBoxModel<Admin> dcbm = new DefaultComboBoxModel<>(items);
		cmbAdmin.setModel(dcbm);*/
	}
	
	public void settingAdmin() {
		
	}
}
