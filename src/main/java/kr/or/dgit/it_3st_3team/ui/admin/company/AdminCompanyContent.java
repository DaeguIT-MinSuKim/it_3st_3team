package kr.or.dgit.it_3st_3team.ui.admin.company;

import javax.swing.JPanel;
import java.awt.Color;
import kr.or.dgit.it_3st_3team.ui.admin.customer.AdminCustomerSearch;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminCompanyContent extends JPanel {

	public AdminCompanyContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		AdminCompanyRegister pInputArea = new AdminCompanyRegister();
		pInputArea.setBackground(Color.WHITE);
		pInputArea.setBounds(12, 10, 1178, 230);
		add(pInputArea);

		AdminCustomerSearch pSearch = new AdminCustomerSearch();
		pSearch.setBounds(12, 250, 1176, 50);
		add(pSearch);

		JPanel pTable = new JPanel();
		pTable.setBounds(12, 310, 1174, 440);
		add(pTable);

		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 760, 1176, 40);
		add(pPaging);
	}
}
