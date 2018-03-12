package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private CustomerOrderRegister pRegister;
	private CustomerOrderSearch pSearch;
	private boolean flag = true;

	public CustomerOrderContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 900);

		pRegister = new CustomerOrderRegister();
		pRegister.setBounds(0, 0, 1200, 192);
		add(pRegister);
		pRegister.setEventListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() >= 1) {
					pRegister.removeAll();
					CustomerOrderRegister2 AnotherRegi = new CustomerOrderRegister2();
					AnotherRegi.setBounds(0, 0, 1200, 338);
					pRegister.add(AnotherRegi);
					pRegister.setBounds(0, 0, 1200, 338);
					pRegister.revalidate();
					pRegister.repaint();
					pSearch.setBounds(0, 338, 1200, 43);
					pTable.setBounds(12, 381, 1164, 460);
					pRegister.setBounds(0, 0, 1200, 338);
					add(pRegister);
				}else if(e.getSource()=="ee" ) {
					pRegister.removeAll();
					CustomerOrderRegister pMain = new CustomerOrderRegister();
					pMain.setBounds(0, 0, 1200, 192);
					pRegister.add(pMain);
					pRegister.revalidate();
					pRegister.repaint();
				}
					
			}
		});
		

		pTable = new CustomerOrderTable();
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		pTable.setBounds(12, 233, 1164, 612);
		pTable.setEventListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int no = pTable.getSelectedNo();
					Software software = SoftwareService.getInstance().selectSoftwareByNo(new Software(no));

					pRegister.setOrderData(software);
				}
			}

		});

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
