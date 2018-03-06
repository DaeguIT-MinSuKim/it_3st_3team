package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel implements ActionListener {

	private AdminSoftwareRegister pRegister;
	private AdminSoftwareSearch pSearch;
	private AdminSoftwareTable pTable;
	private JButton btnRegister;
	private JButton btnCancel;
	private JButton btnSearch;

	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1200, 850);
		setLayout(null);

		pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 961, 195);
		add(pRegister);

		pSearch = new AdminSoftwareSearch();
		pSearch.setBackground(new Color(240, 240, 240));
		pSearch.setBounds(0, 194, 961, 50);
		add(pSearch);

		pTable = new AdminSoftwareTable();
		pTable.setBackground(new Color(240, 240, 240));
		pTable.setBounds(0, 244, 1190, 572);
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		add(pTable);

		PagingComp pPageing = new PagingComp();
		pPageing.setBackground(new Color(240, 240, 240));
		pPageing.setBounds(0, 814, 1190, 52);
		add(pPageing);

		btnRegister = new JButton("등록");
		btnRegister.addActionListener(this);

		btnRegister.setBounds(967, 162, 97, 23);
		add(btnRegister);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(1076, 162, 97, 23);
		add(btnCancel);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(985, 206, 97, 23);
		add(btnSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnRegister) {
			actionPerformedBtnRegister(e);
		}
	}

	// 등록버튼
	protected void actionPerformedBtnRegister(ActionEvent e) {
		
		User Company = (User) pRegister.getpCompany().getCmbSelectItem();
		SoftwareGroup swGroup = (SoftwareGroup) pRegister.getpSWsort().getCmbSelectItem();
		String swName = pRegister.getpSWName().getTfText();
		int swQuantity = Integer.parseInt(pRegister.getpCount().getTfText());
		int spPrice = Integer.parseInt(pRegister.getpSupplyPrice().getTfText());
		int slPrice = Integer.parseInt(pRegister.getpSalePrice().getTfText());
	
		
		Software sw = new Software(swName, spPrice, slPrice, swGroup, swQuantity, Company);
		SoftwareService.getInstance().insertSoftware(sw);
		List<Software> lists = SoftwareService.getInstance().selectSoftwareByAll();
		pTable.loadTableDatas(lists);
		
		
	

	}

	// 취소버튼
	protected void actionPerformedBtnCancel(ActionEvent e) {
		
	}

	// 검색버튼
	protected void actionPerformedBtnSearch(ActionEvent e) {
		
		String cmbSearch = (String) pSearch.getpCmbSearch().getCmbItem();
		
		Map<String, String> map = new HashMap<>();
		
		switch(cmbSearch) {
		case "공급회사명" :
			map.put("searchBy", "company");
			break;
		case "품목명" : 
			map.put("searchBy", "swName");
			break;
		case "분류" :
			map.put("searchBy", "swGroup");
			break;
		default: 
			JOptionPane.showMessageDialog(null, "그런건 없습니다.");
			return;
		}
		if(pSearch.getTfSearch().equals("")) {
			List<Software> li = SoftwareService.getInstance().selectSoftwareByAll();
			pTable.loadTableDatas(li);
		}else {
			map.put("searchText", pSearch.getTfSearch());
			List<Software> li = SoftwareService.getInstance().selectSoftwareBySearch(map);
			pTable.loadTableDatas(li);
			pSearch.setTfSearch("");
		}
		
		
	}
}
