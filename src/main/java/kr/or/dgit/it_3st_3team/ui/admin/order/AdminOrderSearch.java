package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.component.CmbAdminComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminOrderSearch extends JPanel {
	private JTextField textField;
	private CmbSoftwareGroupComp pSearchSoftwareSort;
	private CmbAdminComp pAdmin;
	private StartAndEndDate pDate;
	private CmbStringComp pSortUserNameSWName;

	public AdminOrderSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pOrderSearch = new JPanel();
		
		pOrderSearch.setBounds(0, 0, 1060, 50);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);

		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);
		
		pSearchSoftwareSort = new CmbSoftwareGroupComp();
		pSearchSoftwareSort.setBounds(12, 10, 120, 30);
		pSearchSoftwareSort.loadData(sgDatas);
		pOrderSearch.add(pSearchSoftwareSort);
		
		List<Admin> adli = AdminService.getInstance().selectAdminAll();
		Admin[] adDatas = adli.toArray(new Admin[adli.size()]);

		pAdmin = new CmbAdminComp();
		pAdmin.setBounds(144, 10, 120, 30);
		pAdmin.loadData(adDatas);
		pOrderSearch.add(pAdmin);

		pDate = new StartAndEndDate();
		pDate.setBackground(new Color(240, 240, 240));
		pDate.setBounds(402, 0, 434, 43);
		pOrderSearch.add(pDate);

		pSortUserNameSWName = new CmbStringComp();
		pSortUserNameSWName.setBounds(276, 10, 120, 30);
		String[] st = { "고객명", "공급회사명", "품목명" };
		pSortUserNameSWName.loadData(st);
		pOrderSearch.add(pSortUserNameSWName);
		
		textField = new JTextField();
		textField.setBounds(836, 10, 224, 30);
		pOrderSearch.add(textField);
		textField.setColumns(10);
	}
	
	
	public SoftwareGroup getSelectedSoftwareGrp() {
		return (SoftwareGroup) pSearchSoftwareSort.getCmbItem();
	}
	
	public Admin getSelectedAdmin() {
		return (Admin) pAdmin.getCmbItem();
	}
	
	public String getSelectedString() {
		return (String) pSortUserNameSWName.getCmbItem();
	}
	
	public String getStartDate() {
		return pDate.getStartDate();
	}
	
	public String getEndDate() {
		return pDate.getEndDate();
	}
	
	public String getSearchText() {
		return textField.getText().trim();
	}

	

}
