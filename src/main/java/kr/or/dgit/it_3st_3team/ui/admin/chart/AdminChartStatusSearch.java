package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;

@SuppressWarnings("serial")
public class AdminChartStatusSearch extends JPanel {
	protected JTextField tfSearch;
	protected DefaultComboBoxModel<SoftwareGroup> dcbm;
	private SoftwareGroupService swgService;
	private AdminService adService;
	private JComboBox<SoftwareGroup> cmbSwgType;
	private JComboBox<Admin> cmbAdmin;
	private JComboBox<String> cmbSearchBy;
	private StartAndEndDate pCalendar;
	private Admin admin;
	private User user;

	public AdminChartStatusSearch(Object who) {
		setUsingUser(who);
		swgService = SoftwareGroupService.getInstance();
		adService = AdminService.getInstance();
		initComponents();
	}
	
	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
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

		cmbSearchBy = new JComboBox<>();
		cmbSearchBy.setBounds(12, 60, 125, 30);
		add(cmbSearchBy);
		setCmbString();
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(160, 60, 300, 30);
		add(tfSearch);
		
		
		if (admin != null) {
			System.out.println(admin);
			// 관리자
			if (admin.getAdminGroup().getAgNo() == 1) {
				// 총관리자
				cmbAdmin = new JComboBox<>();
				cmbAdmin.setBounds(161, 10, 125, 30);
				add(cmbAdmin);
				setCmbAdGroup();
			}
			
		} else {
			if(user.getUserGroup().getValue() == 1) {
				//고객
				cmbSearchBy.removeItemAt(0);
			//	revalidate();
			//	repaint();
			}else {
				//공급회사
				cmbSearchBy.removeItemAt(1);
			//	revalidate();
			//	repaint();
			}
		}
		
		
		
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
		ad = adService.listAdminAll();
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
		cmbSearchBy.setModel(dcbm);
	}


	//get 메소드
	public SoftwareGroup getSelectedSoftwareGrp() {
		return (SoftwareGroup) cmbSwgType.getSelectedItem();
	}
	
	public Admin getSelectedAdmin() {
		return (Admin) cmbAdmin.getSelectedItem();
	}
	
	public String getSelectedString() {
		return (String) cmbSearchBy.getSelectedItem();
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
