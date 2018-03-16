package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.SalesReportUI;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.table.AdminSalesStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CustomerStatusLists;

@SuppressWarnings("serial")
public class AdminStatusContent extends JPanel implements ActionListener {
	private JButton btnSearch;
	private JButton btnReset;
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
		pAllListTable = new AdminStatusLists();
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

		btnReset = new JButton("초기화");
		btnReset.addActionListener(this);
		btnReset.setBounds(565, 60, 80, 30);
		pSearch.add(btnReset);

		resetAll();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset) {
			actionPerformedBtnReset(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	// 검색버튼 액션
	protected void actionPerformedBtnSearch(ActionEvent e) {
		callGetSelectedValues();
	}

	private void callGetSelectedValues() {
		SoftwareGroup swg = pSearch.getSelectedSoftwareGrp();
		startDate = pSearch.getStartDate();
		endDate = pSearch.getEndDate();
		name = pSearch.getSearchText();
		searchBy = pSearch.getSelectedString();
		
		Map<String, String> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("name", name);
		
		if (!swg.getSgName().equals("분류")) {
			map.put("sgName", swg.getSgName());
		}
		String searchByText = null;
		if (searchBy.equals("고객명")) {
			searchByText = "customer";
		} else if (searchBy.equals("공급회사명")) {
			searchByText = "company";
		} else if (searchBy.equals("품목명")) {
			searchByText = "softwarename";
		}
		map.put("searchBy", searchByText);
		
		if (admin != null) {
			// 총관리자라면

			for (Entry<String, String> e : map.entrySet()) {
				System.out.println(e.getKey() + " " + e.getValue());
			}
			if (admin.getAdminGroup().getAgNo() == 1) {
				Admin ad = pSearch.getSelectedAdmin();

				if (!ad.getAdminName().equals("관리자")) {
					map.put("adminName", ad.getAdminName());
				}
				
				pAllListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pAllListTable);
			} else {
				// 영업
				map.put("adminId", admin.getAdminId());

				pSalesAllListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pSalesAllListTable);
			}
		} else {
			if (user.getUserGroup().getValue() == 1) {
				// 사용자 고객이라면
				map.put("userId", user.getUserId());

				pCustomerListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pCustomerListTable);

			} else {
				// 사용자 공급회사라면
				map.put("comId", user.getUserId());

				pCompanyListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pCompanyListTable);
			}
		}
	}

	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}

	protected void actionPerformedBtnReset(ActionEvent e) {
		resetAll();
	}

	private void resetAll() {
		pSearch.clearItem();
		Map<String, String> map = new HashMap<>();
		if (admin != null) {
			if (admin.getAdminGroup().getAgAuth() == AdminGroupAuth.ADMINISTRATOR) {
				// 총관리자
				pAllListTable.setBounds(12, 116, 1157, 670);
				pAllListTable.loadTableDatas(soService.findSaleOrderAllByType(map));
				add(pAllListTable);
			} else {
				// 영업사원
				map.put("adminId", admin.getAdminId());
				pSalesAllListTable.setBounds(12, 116, 1157, 670);
				pSalesAllListTable.loadTableDatas(soService.findSaleOrderAllByType(map));
				add(pSalesAllListTable);
			}
		} else {
			if (user.getUserGroup() == UserGroup.CUSTOMER) {
				// 고객
				map.put("userId", user.getUserId());
				pCustomerListTable.setBounds(12, 116, 1157, 670);
				pCustomerListTable.loadTableDatas(soService.findSaleOrderAllByType(map));
				add(pCustomerListTable);
			} else {
				// 회사
				map.put("comId", user.getUserId());
				pCompanyListTable.setBounds(12, 116, 1157, 670);
				pCompanyListTable.loadTableDatas(soService.findSaleOrderAllByType(map));
				add(pCompanyListTable);
			}
		}
	}
}
