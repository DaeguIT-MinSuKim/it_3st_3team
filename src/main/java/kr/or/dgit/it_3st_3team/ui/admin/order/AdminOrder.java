package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminOrder extends JPanel implements ActionListener {
	private SaleOrderService soService;
	private JButton btnSearch;
	private AdminOrderSearch pOrderSearch;
	private AdminOrderRegister pCorrection;
	private AdminStatusLists pOrderTable;

	public AdminOrder() {
		this.soService = SaleOrderService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		pCorrection = new AdminOrderRegister();
		pCorrection.setBackground(new Color(240, 240, 240));
		pCorrection.setBounds(0, 0, 962, 176);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(240, 240, 240));
		pOrderSearch.setBounds(0, 176, 1060, 50);
		add(pOrderSearch);
		
		pOrderTable = new AdminStatusLists();
		pOrderTable.loadTableDatas(soService.findSaleOrderByAll());
		pOrderTable.setBounds(0, 226, 1200, 585);
		add(pOrderTable);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(1072, 193, 97, 23);
		add(btnSearch);
		
		JButton btnRewrite = new JButton("수정");
		btnRewrite.setBounds(981, 143, 97, 23);
		add(btnRewrite);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(1090, 143, 97, 23);
		add(btnCancel);
		
		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(0, 810, 1176, 40);
		add(pPaging);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		SoftwareGroup swg =  pOrderSearch.getSelectedSoftwareGrp();
		Admin ad = pOrderSearch.getSelectedAdmin();
		String searchBy = pOrderSearch.getSelectedString();
		if(swg.getSgName().equals("분류")) {
			swg.setSgName("");
		}if(ad.getAdminName().equals("관리자")) {
			ad.setAdminName("");
		}if(searchBy.equals("고객명")) {
			searchBy = "customer";
		}else if(searchBy.equals("공급회사명")) {
			searchBy = "company";
		}else if(searchBy.equals("품목명")) {
			searchBy = "softwarename";
		}	
		String name = pOrderSearch.getSearchText();
		String startDate = pOrderSearch.getStartDate();
		String endDate = pOrderSearch.getEndDate();
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
		pOrderTable.loadTableDatas(soService.findSaleOrderWithAllBySearch(map));
		add(pOrderTable);
		
		
		/*String  sg = (String) pOrderSearch.getpSearchSoftwareSort().getCmbBox();
		String	ad = (String) pOrderSearch.getpAdmin().getCmbBox();
		String	us = (String) pOrderSearch.getpSortUserNameSWName().getCmbBox();
		
		Map<String, String> map = new HashMap<>();*/
		
	}
}
