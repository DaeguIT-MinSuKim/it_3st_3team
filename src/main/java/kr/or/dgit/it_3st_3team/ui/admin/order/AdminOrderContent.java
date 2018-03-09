package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.jfree.ui.StrokeSample;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
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
public class AdminOrderContent extends JPanel implements ActionListener {
	private SaleOrderService soService;
	private AdminOrderSearch pOrderSearch;
	private AdminOrderRegister pOrderRegi;
	private AdminOrderManagementLists pOrderTable;
	private JMenuItem modifyMenu;
	private JMenuItem deleteMenu;

	
	public AdminOrderContent() {
		this.soService = SaleOrderService.getInstance();
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setBounds(0, 0, 1187, 896);
		
		pOrderRegi = new AdminOrderRegister();
		pOrderRegi.setBackground(new Color(240, 240, 240));
		pOrderRegi.setBounds(0, 0, 1187, 179);
		pOrderRegi.setAdOrder(this);
		add(pOrderRegi);
		pOrderRegi.setLayout(null);
		
		pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(240, 240, 240));
		pOrderSearch.setBounds(0, 180, 1187, 50);
		pOrderSearch.setParent(this);
		add(pOrderSearch);
		
		pOrderTable = new AdminOrderManagementLists();
		pOrderTable.loadTableDatas(soService.findSaleOrderByAll());
		pOrderTable.setBounds(10, 230, 1165, 617);
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
		
		
		
		
	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modifyMenu) {
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
	
	public void reFreshList() {
		List<SaleOrder> li = SaleOrderService.getInstance().findSaleOrderByAll();
		pOrderTable.loadTableDatas(li);
	}
	
	public void setListBySearchData(List<SaleOrder> searchData) {
		pOrderTable.loadTableDatas(searchData);
	}
	
	/*public void setData(SaleOrder sr) {
		AdminOrderRegister.setOrderData(sr);
	}
	*/
}
