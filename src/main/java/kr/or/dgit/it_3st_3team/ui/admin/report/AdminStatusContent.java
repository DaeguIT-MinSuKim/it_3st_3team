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
		if (admin != null) {
			// 총관리자라면
			if (admin.getAdminGroup().getAgNo() == 1) {
				SoftwareGroup swg = pSearch.getSelectedSoftwareGrp();
				startDate = pSearch.getStartDate();
				endDate = pSearch.getEndDate();
				name = pSearch.getSearchText();
				searchBy = pSearch.getSelectedString();
				Admin ad = pSearch.getSelectedAdmin();

				Map<String, String> map = new HashMap<>();
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("name", name);

				if (!ad.getAdminName().equals("관리자")) {
					map.put("adminName", ad.getAdminName());
				}
				if (!swg.getSgName().equals("분류")) {
					map.put("sgName", swg.getSgName());
				}
				if (searchBy.equals("고객명")) {
					searchBy = "customer";
				} else if (searchBy.equals("공급회사명")) {
					searchBy = "company";
				} else if (searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				map.put("searchBy", searchBy);
				pAllListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pAllListTable);
			} else {
				swg = pSearch.getSelectedSoftwareGrp();
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
				if (searchBy.equals("고객명")) {
					searchBy = "customer";
				} else if (searchBy.equals("공급회사명")) {
					searchBy = "company";
				} else if (searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				map.put("searchBy", searchBy);
				pSalesAllListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pSalesAllListTable);
			}
		} else {
			// 사용자 고객이라면
			if (user.getUserGroup().getValue() == 1) {
				swg = pSearch.getSelectedSoftwareGrp();
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
				if (searchBy.equals("공급회사명")) {
					searchBy = "company";
				} else if (searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				map.put("searchBy", searchBy);
				pCustomerListTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
				add(pCustomerListTable);

			} else {
				// 사용자 공급회사라면
				swg = pSearch.getSelectedSoftwareGrp();
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
				if (searchBy.equals("고객명")) {
					searchBy = "customer";
				} else if (searchBy.equals("품목명")) {
					searchBy = "softwarename";
				}
				map.put("searchBy", searchBy);
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
		if (admin != null) {
			if (admin.getAdminGroup().getAgNo() == 1) {
				// 총관리자
				pAllListTable.setBounds(12, 116, 1157, 670);
				pAllListTable.loadTableDatas(soService.findSaleOrderByAll());
				add(pAllListTable);
			} else {
				// 영업사원
				pSalesAllListTable.setBounds(12, 116, 1157, 670);
				pSalesAllListTable.loadTableDatas(soService.findSaleOrderByAll());
				add(pSalesAllListTable);
			}
		} else {
			if (user.getUserGroup().getValue() == 1) {
				pCustomerListTable.setBounds(12, 116, 1157, 670);
				pCustomerListTable.loadTableDatas(soService.findSaleOrderByAll());
				add(pCustomerListTable);
			} else {
				pCompanyListTable.setBounds(12, 116, 1157, 670);
				pCompanyListTable.loadTableDatas(soService.findSaleOrderByAll());
				add(pCompanyListTable);
			}
		}
	}
}
