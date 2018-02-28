package kr.or.dgit.it_3st_3team.ui.admin.software;

import javax.swing.JPanel;
import java.awt.Color;

import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;
import java.awt.SystemColor;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel {

	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1200, 850);
		setLayout(null);

		AdminSoftwareRegister pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 961, 195);
		add(pRegister);

		AdminSoftwareSearch pSearch = new AdminSoftwareSearch();
		pSearch.setBackground(new Color(240, 240, 240));
		pSearch.setBounds(0, 194, 961, 50);
		add(pSearch);

		AdminSoftwareTable pTable = new AdminSoftwareTable();
		pTable.setBackground(new Color(240, 240, 240));
		pTable.setBounds(0, 242, 1190, 572);
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		add(pTable);

		PagingComp pPageing = new PagingComp();
		pPageing.setBackground(new Color(240, 240, 240));
		pPageing.setBounds(0, 814, 1190, 52);
		add(pPageing);
		
		JButton btnRegister = new JButton("등록");
		btnRegister.setBounds(967, 162, 97, 23);
		add(btnRegister);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(1076, 162, 97, 23);
		add(btnCancel);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(985, 206, 97, 23);
		add(btnSearch);
	}
}
