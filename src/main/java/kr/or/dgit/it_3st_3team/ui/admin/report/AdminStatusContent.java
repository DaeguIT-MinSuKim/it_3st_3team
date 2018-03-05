package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.SalesReportUI;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.table.AdminSalesStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CustomerStatusLists;


@SuppressWarnings("serial")
public class AdminStatusContent extends JPanel implements ActionListener {
	private JButton btnSearch;
	private AdminStatusSearch pSearch;	
	private StartAndEndDate calendar;
	private SalesReportUI ss;
	private SaleOrderService soService;
	private Admin admin;
	private User user;
	private SoftwareGroup swg;
	private String startDate;
	private String endDate;
	private String name;
	private String searchBy;
	private Admin ad;
	private AdminStatusLists pAllListTable;
	private AdminSalesStatusLists pSalesAllListTable;
	private CompanyStatusLists pCompanyListTable;
	private CustomerStatusLists pCustomerListTable;
	
	public AdminStatusContent(Object user) {
		this.soService = SaleOrderService.getInstance();
		setUsingUser(user);
		pSalesAllListTable = new AdminSalesStatusLists(); 
		pCompanyListTable = new CompanyStatusLists();
		pCustomerListTable = new CustomerStatusLists();
		initComponents(user);
	}

	private void initComponents(Object user) {
		setLayout(null);

		pSearch = new AdminStatusSearch(user);
		pSearch.setBounds(0, 10, 1190, 96);
		add(pSearch);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(471, 60, 80, 30);
		pSearch.add(btnSearch);
		
		pAllListTable = new AdminStatusLists(); 
		pAllListTable.setBounds(12, 116, 1157, 670);
		pAllListTable.loadTableDatas(soService.findSaleOrderByAll());
		add(pAllListTable);
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	
	//검색버튼 액션
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		callGetSelectedValues();
		
	}

	private void callGetSelectedValues() {
		
		
		if(admin != null) {
			//총관리자라면
			if(admin.getAdminGroup().getAgNo() == 1) {
				swg = pSearch.getSelectedSoftwareGrp();
				startDate = pSearch.getStartDate();
				endDate = pSearch.getEndDate();
				name = pSearch.getSearchText();
				searchBy = pSearch.getSelectedString();
				ad = pSearch.getSelectedAdmin();
				
				if(ad.getAdminName().equals("관리자")) {
					ad.setAdminName("");
				}
				if(swg.getSgName().equals("분류")) {
					swg.setSgName("");
				}
				if(searchBy.equals("고객명")) {
					searchBy = "customer";
				}else if(searchBy.equals("공급회사명")) {
					searchBy = "company";
				}else if(searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}	
				Map<String, String> map = new HashMap<>();
				map.put("sgName", swg.getSgName());
				map.put("adminName", ad.getAdminName());
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("searchBy", searchBy);
				map.put("name", name);
				pAllListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pAllListTable);
			}else {
				swg = pSearch.getSelectedSoftwareGrp();
				startDate = pSearch.getStartDate();
				endDate = pSearch.getEndDate();
				name = pSearch.getSearchText();
				searchBy = pSearch.getSelectedString();
				
				if(swg.getSgName().equals("분류")) {
					swg.setSgName("");
				}
				if(searchBy.equals("고객명")) {
					searchBy = "customer";
				}else if(searchBy.equals("공급회사명")) {
					searchBy = "company";
				}else if(searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}	
				Map<String, String> map = new HashMap<>();
				map.put("sgName", swg.getSgName());
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("searchBy", searchBy);
				map.put("name", name);
				
				remove(pAllListTable);
				revalidate();
				repaint();
				
				pSalesAllListTable.setBounds(12, 116, 1157, 670);
				pSalesAllListTable.loadTableDatas(soService.findSaleOrderWithoutadminName(map));
				add(pSalesAllListTable);
				
		
			}
		}else {
			//사용자 고객이라면
			if(user.getUserGroup().getValue() == 1) {
				swg = pSearch.getSelectedSoftwareGrp();
				startDate = pSearch.getStartDate();
				endDate = pSearch.getEndDate();
				name = pSearch.getSearchText();
				searchBy = pSearch.getSelectedString();
				
				if(swg.getSgName().equals("분류")) {
					swg.setSgName("");
				}
				if(searchBy.equals("공급회사명")) {
					searchBy = "company";
				}else if(searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				Map<String, String> map = new HashMap<>();
				map.put("sgName", swg.getSgName());
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("searchBy", searchBy);
				map.put("name", name);
				
				remove(pAllListTable);
				revalidate();
				repaint();
				
				pCustomerListTable.setBounds(12, 116, 1157, 670);
				pCustomerListTable.loadTableDatas(soService.findSaleOrderWithoutadminName(map));
				add(pCustomerListTable);
				
			}else {
			//사용자 공급회사라면	
				swg = pSearch.getSelectedSoftwareGrp();
				startDate = pSearch.getStartDate();
				endDate = pSearch.getEndDate();
				name = pSearch.getSearchText();
				searchBy = pSearch.getSelectedString();
				
				if(swg.getSgName().equals("분류")) {
					swg.setSgName("");
				}
				if(searchBy.equals("고객명")) {
					searchBy = "customer";
				}else if(searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				Map<String, String> map = new HashMap<>();
				map.put("sgName", swg.getSgName());
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("searchBy", searchBy);
				map.put("name", name);

				remove(pAllListTable);
				revalidate();
				repaint();
				
				pCompanyListTable.setBounds(12, 116, 1157, 670);
				pCompanyListTable.loadTableDatas(soService.findSaleOrderWithoutadminName(map));
				add(pCompanyListTable);
			}
		}
		
	/*	SoftwareGroup swg =  pSearch.getSelectedSoftwareGrp();
		Admin ad = pSearch.getSelectedAdmin();
		String searchBy = pSearch.getSelectedString();
		if(swg.getSgName().equals("분류")) {
			swg.setSgName("");
		}
		if(ad.getAdminName().equals("관리자")) {
			ad.setAdminName("");
		}
		
		if(searchBy.equals("고객명")) {
			searchBy = "customer";
		}else if(searchBy.equals("공급회사명")) {
			searchBy = "company";
		}else if(searchBy.equals("품목명")) {
			searchBy = "softwarename";
		}	
		String name = pSearch.getSearchText();
		String startDate = pSearch.getStartDate();
		String endDate = pSearch.getEndDate();
		System.out.println(String.format("%s %s %s %s %s %s", swg.getSgName(), ad.getAdminName(), startDate, endDate, searchBy, name));
		Map<String, String> map = new HashMap<>();
		map.put("sgName", swg.getSgName());
		map.put("adminName", ad.getAdminName());
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("searchBy", searchBy);
		map.put("name", name);
		List<SaleOrder> list = soService.findSaleOrderWithAllBySearch(map);
		System.out.println(list);
		pListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
		add(pListTable); */
		
	}
	
	
	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}
}
