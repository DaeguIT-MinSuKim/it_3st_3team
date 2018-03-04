package kr.or.dgit.it_3st_3team.ui.admin.user;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminUserContent extends JPanel {

	public AdminUserContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		AdminUserRegister pInputArea = new AdminUserRegister();
		pInputArea.setBounds(12, 10, 1178, 230);
		add(pInputArea);

		AdminUserSearch pSearch = new AdminUserSearch();
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
