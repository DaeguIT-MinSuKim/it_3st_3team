package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.table.CustomerOrderTable;

@SuppressWarnings("serial")
public class CustomerOrderContent extends JPanel {
	private CustomerOrderTable pTable;
	private CustromerOrderRegister pRegister;
	private CustomerOrderSearch pSearch;
	
	
	public CustomerOrderContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 900);
		
		pRegister = new CustromerOrderRegister();
		pRegister.setBounds(0, 0, 1200, 192);
		add(pRegister);
		
		pTable = new CustomerOrderTable();
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		pTable.setBounds(12, 233, 1164, 612);
		add(pTable);
		
		
		pSearch = new CustomerOrderSearch();
		pSearch.setParent(this);
		pSearch.setBounds(0, 191, 1200, 43);
		add(pSearch);
		
	}

	public void reFreshList() {
		List<Software> li = SoftwareService.getInstance().selectSoftwareByAll();
		pTable.loadTableDatas(li);
	}
	
	public void setListBySearchData(List<Software> serachData) {
		pTable.loadTableDatas(serachData);
	}
}
