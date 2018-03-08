package kr.or.dgit.it_3st_3team.ui.admin.chart;

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
import kr.or.dgit.it_3st_3team.ui.table.AdminSalesStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.table.CustomerStatusLists;


@SuppressWarnings("serial")
public class AdminChartContent extends JPanel implements ActionListener {
	private JButton btnSearch;
	private AdminChartSearch pSearch;	
	private SalesReportUI ss;
	private SaleOrderService soService;
	private Admin admin;
	private User user;
	private SoftwareGroup swg;
	private Admin ad;
	private AdminChartBySwgType pAllSwgChart;
	private AdminChartBySwgTypeFullYear tt;
	private AdminSalesStatusLists pSalesAllListTable;
	private CompanyStatusLists pCompanyListTable;
	private CustomerStatusLists pCustomerListTable;
	
	public AdminChartContent(Object user) {
		this.soService = SaleOrderService.getInstance();
		setUsingUser(user);
		
		pSalesAllListTable = new AdminSalesStatusLists(); 
		pCompanyListTable = new CompanyStatusLists();
		pCustomerListTable = new CustomerStatusLists();
		initComponents(user);
	}

	private void initComponents(Object user) {
		setLayout(null);

		pSearch = new AdminChartSearch(user);
		pSearch.setBounds(0, 10, 1190, 96);
		add(pSearch);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(552, 10, 80, 30);
		pSearch.add(btnSearch);
		
		tt = new AdminChartBySwgTypeFullYear(); 
		tt.setBounds(12, 116, 1157, 670);
		add(tt);
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
				ad = pSearch.getSelectedAdmin();
				
				if(ad.getAdminName().equals("관리자")) {
					ad.setAdminName("");
				}
				
				Map<String, String> map = new HashMap<>();
				
				map.put("adminName", ad.getAdminName());
				add(tt);
			}else {

				remove(pAllSwgChart);
				revalidate();
				repaint();
				
				pAllSwgChart.setBounds(12, 116, 1157, 670);
				add(pAllSwgChart);
				
			}
		}else {
			//사용자 고객이라면
			if(user.getUserGroup().getValue() == 1) {
				
				remove(pAllSwgChart);
				revalidate();
				repaint();
				
				pAllSwgChart.setBounds(12, 116, 1157, 670);
				add(pAllSwgChart);
				
			} else {
			//사용자 공급회사라면	
				remove(pAllSwgChart);
				revalidate();
				repaint();
				
				pAllSwgChart.setBounds(12, 116, 1157, 670);
				add(pAllSwgChart);
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
}
