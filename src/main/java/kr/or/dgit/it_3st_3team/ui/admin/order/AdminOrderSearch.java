package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.component.CmbAdminComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;

@SuppressWarnings("serial")
public class AdminOrderSearch extends JPanel implements ActionListener {
	private JTextField textField;
	private CmbSoftwareGroupComp pSearchSoftwareSort;
	private CmbAdminComp pAdmin;
	private StartAndEndDate pDate;
	private CmbStringComp pSortUserNameSWName;
	private JButton btnSearch;
	private AdminOrderContent parent;

	public AdminOrderSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pOrderSearch = new JPanel();

		pOrderSearch.setBounds(0, 0, 1183, 50);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);

		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		lists.add(0, new SoftwareGroup("분류"));
		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);

		pSearchSoftwareSort = new CmbSoftwareGroupComp();
		pSearchSoftwareSort.setBounds(12, 10, 120, 30);
		pSearchSoftwareSort.loadData(sgDatas);
		pOrderSearch.add(pSearchSoftwareSort);

		List<Admin> adli = AdminService.getInstance().listAdminAll();
		adli.add(0, new Admin("관리자"));
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

		btnSearch = new JButton("검색");
		btnSearch.setBounds(1072, 13, 97, 23);
		pOrderSearch.add(btnSearch);
		btnSearch.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		SoftwareGroup swg = (SoftwareGroup) pSearchSoftwareSort.getCmbItem();
		Admin ad = (Admin) pAdmin.getCmbItem();
		String searchBy = (String) pSortUserNameSWName.getCmbItem();

		Map<String, String> map = new HashMap<>();
		if (!swg.getSgName().equals("분류")) {
			map.put("sgName", swg.getSgName());
		}
		if (!ad.getAdminName().equals("관리자")) {
			map.put("adminName", ad.getAdminName());
		}
		if (searchBy.equals("고객명")) {
			searchBy = "customer";
		} else if (searchBy.equals("공급회사명")) {
			searchBy = "company";
		} else if (searchBy.equals("품목명")) {
			searchBy = "softwarename";
		}
		map.put("searchBy", searchBy);
		
		String name = textField.getText();
		String startDate = pDate.getStartDate();
		String endDate = pDate.getEndDate();
		
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		map.put("name", name);

		List<SaleOrder> list = SaleOrderService.getInstance().findSaleOrderWithAllBySearch(map);
		parent.setListBySearchData(list);

	}

	private void clearSearch() {

	}

	public void setParent(AdminOrderContent adminOrderContent) {
		this.parent = adminOrderContent;
	}

}
