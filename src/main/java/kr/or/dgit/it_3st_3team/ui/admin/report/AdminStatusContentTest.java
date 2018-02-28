package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.SalesReportUI;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;


@SuppressWarnings("serial")
public class AdminStatusContentTest extends JPanel implements ActionListener {
	private JButton btnSearch;
	private TestSearch pSearch;	
	private StartAndEndDate calendar;
	private JButton btnReport;
	private SalesReportUI ss;
	private SaleOrderService soService;
	private AdminStatusLists pListTable;
	
	
	public AdminStatusContentTest() {
		this.soService = SaleOrderService.getInstance();
		
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pSearch = new TestSearch();
		pSearch.setBounds(12, 10, 1178, 96);
		add(pSearch);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(471, 60, 80, 30);
		pSearch.add(btnSearch);
		
		btnReport = new JButton("판매보고서");
		btnReport.addActionListener(this);
		btnReport.setBounds(1070, 60, 100, 30);
		pSearch.add(btnReport);

		pListTable = new AdminStatusLists(); 
		pListTable.setBounds(12, 116, 1176, 418);
		pListTable.loadTableDatas(soService.findSaleOrderByAll());
		add(pListTable);

		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 544, 1176, 40);
		add(pPaging);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReport) {
			actionPerformedBtnReport(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	
	//검색버튼 액션
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		callGetSelectedValues();
		
	}

	private SaleOrder callGetSelectedValues() {
		SoftwareGroup swg =  pSearch.getSelectedSoftwareGrp();
		Admin ad = pSearch.getSelectedAdmin();
		String searchBy = pSearch.getSelectedString();
		System.out.println(ad);
		if(swg.getSgName().equals("분류")) {
			swg.setSgName("");
		}if(ad.getAdminName().equals("관리자")) {
			ad.setAdminName("");
		}else if(searchBy.equals("고객명")) {
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
		return null;
	}
	
	//판매보고서 버튼 액션
	
	protected void actionPerformedBtnReport(ActionEvent e) {
		JFrame jf = new SalesReportUI();
		jf.setVisible(true);
	}
}
