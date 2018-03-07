package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.table.AdminOrderManagementLists;
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
	private AdminOrderRegister pOrderRegi;
	private AdminOrderManagementLists pOrderTable;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;

	private JButton btnRewrite;
	private JButton btnCancel;
	public AdminOrder() {
		this.soService = SaleOrderService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		pOrderRegi = new AdminOrderRegister();
		pOrderRegi.setBackground(new Color(240, 240, 240));
		pOrderRegi.setBounds(0, 0, 962, 176);
		pOrderRegi.setAdOrder(this);
		add(pOrderRegi);
		pOrderRegi.setLayout(null);
		
		pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(240, 240, 240));
		pOrderSearch.setBounds(0, 176, 1060, 50);
		add(pOrderSearch);
		
		pOrderTable = new AdminOrderManagementLists();
		pOrderTable.loadTableDatas(soService.findSaleOrderByAll());
		pOrderTable.setBounds(0, 226, 1200, 585);
		add(pOrderTable);
		JPopupMenu menu = new JPopupMenu();
		modifyMenu = new JMenuItem("     수정   ");
		deleteMenu = new JMenuItem("     삭제   ");
		modifyMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		menu.add(modifyMenu);
		menu.add(deleteMenu);
		pOrderTable.setPopupMenu(menu);
		
		List<SaleOrder> orderList = SaleOrderService.getInstance().findSaleOrderByAll();
		pOrderTable.loadTableDatas(orderList);
		
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(1072, 193, 97, 23);
		add(btnSearch);
		
		btnRewrite = new JButton("수정");
		btnRewrite.setBounds(981, 143, 97, 23);
		add(btnRewrite);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(1090, 143, 97, 23);
		add(btnCancel);
	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}if (e.getSource() == modifyMenu) {
			actionPerformedBtnModifyMenu(e);
		} else if (e.getSource() == deleteMenu) {
			actionPerformedBtnDeleteMenu(e);
		}
	}
	
	

	private void actionPerformedBtnDeleteMenu(ActionEvent e) {
		int no = pOrderTable.getSelectedNo();
		
		int res = JOptionPane.showConfirmDialog(null, "사용자를 삭제하시겠습니까?", "사용자 삭제", JOptionPane.OK_CANCEL_OPTION);
		if (res == JOptionPane.OK_OPTION) {
			int result =SaleOrderService.getInstance().deleteSaleOrderByNo(new SaleOrder(no));
			if (result != 1) {
				JOptionPane.showMessageDialog(null, "사용자를 삭제하지 못했습니다.");
				return;
			}
			pOrderTable.removeRow(pOrderTable.getSelectedRow());
			JOptionPane.showMessageDialog(null, "사용자를 삭제하였습니다.");
		}
	}

	private void actionPerformedBtnModifyMenu(ActionEvent e) {
		int no = pOrderTable.getSelectedNo();
		
		SaleOrder saleOrder =SaleOrderService.getInstance().findSaleOrderByNo(new SaleOrder(no));
		
		pOrderRegi.setOrderData(saleOrder);
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
	}
	public String getBtnRewrite() {
		return btnRewrite.getText();
	}
	public void setBtnRewrite(String str) {
		this.btnRewrite.setText(str);
	}
	
	
}
