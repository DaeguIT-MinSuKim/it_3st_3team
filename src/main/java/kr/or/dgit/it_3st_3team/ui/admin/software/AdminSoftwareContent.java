package kr.or.dgit.it_3st_3team.ui.admin.software;

import javax.swing.JPanel;
import java.awt.Color;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel {

	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1200, 850);
		setLayout(null);

		AdminSoftwareRegister pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 1190, 198);
		add(pRegister);

		AdminSoftwareSearch pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(0, 194, 1190, 52);
		add(pSearch);

		AdminSoftwareTable pTable = new AdminSoftwareTable();
		pTable.setBackground(Color.WHITE);
		pTable.setBounds(0, 242, 1190, 572);
		add(pTable);

		PagingComp pPageing = new PagingComp();
		pPageing.setBackground(Color.WHITE);
		pPageing.setBounds(0, 814, 1190, 52);
		add(pPageing);
	}
}
