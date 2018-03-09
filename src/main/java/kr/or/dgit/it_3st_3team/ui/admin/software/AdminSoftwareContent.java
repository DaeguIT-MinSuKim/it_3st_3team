package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel {

	private AdminSoftwareRegister pRegister;
	private AdminSoftwareSearch pSearch;
	private AdminSoftwareTable pTable;
	
	

	
	


	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1191, 929);
		setLayout(null);

		pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 1191, 209);
		pRegister.setAc(this);
		add(pRegister);

		pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(0, 208, 1191, 50);
		pSearch.setParent(this);
		add(pSearch);

		pTable = new AdminSoftwareTable();
	
		pTable.setBounds(10, 258, 1165, 594);
		pTable.setAc(this);
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		add(pTable);
		
	}

	public void reFreshList() {
		List<Software> li = SoftwareService.getInstance().selectSoftwareByAll();
		pTable.loadTableDatas(li);
	}
	
	public void setListBySearchData(List<Software> searchData) {
		pTable.loadTableDatas(searchData);
	}
	
	public void setDate(Software software) {
		pRegister.setSoftwareData(software);
	}
	
	
}
