package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.Color;

@SuppressWarnings("serial")
public class CompanyStatusContent extends JPanel {

	public CompanyStatusContent() {

		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		CompanyStatusSearch pSearch = new CompanyStatusSearch();
		pSearch.setBackground(new Color(255, 255, 255));
		pSearch.setBounds(0, 0, 1188, 107);
		add(pSearch);

		CompanyStatusLists pListTable = new CompanyStatusLists();
		pListTable.setBackground(new Color(255, 255, 255));
		pListTable.setBounds(10, 118, 1165, 428);
		add(pListTable);

		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(0, 559, 1188, 40);
		add(pPaging);
	}

}
