package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminOrder extends JPanel {
	private SaleOrderService soService;

	public AdminOrder() {
		this.soService = SaleOrderService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		AdminOrderRegister pCorrection = new AdminOrderRegister();
		pCorrection.setBackground(new Color(240, 240, 240));
		pCorrection.setBounds(0, 0, 962, 176);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		AdminOrderSearch pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(240, 240, 240));
		pOrderSearch.setBounds(0, 176, 1060, 50);
		add(pOrderSearch);
		
		AdminStatusLists pOrderTable = new AdminStatusLists();
		pOrderTable.loadTableDatas(soService.findSaleOrderByAll());
		pOrderTable.setBounds(0, 226, 1200, 585);
		add(pOrderTable);
		
		JButton btnSearch = new JButton("검색");
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
}
