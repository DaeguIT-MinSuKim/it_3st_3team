package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;

@SuppressWarnings("serial")
public class AdminStatusContent extends JPanel {

	public AdminStatusContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		AdminStatusSearch pSearch = new AdminStatusSearch();
		pSearch.setBounds(12, 10, 1178, 96);
		add(pSearch);

		AdminStatusLists pListTable = new AdminStatusLists();
		pListTable.setBounds(12, 116, 1176, 418);
		add(pListTable);

		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 544, 1176, 40);
		add(pPaging);
	}
}
