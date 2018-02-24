package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminStatusContent extends JPanel {

	public AdminStatusContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		AdminStatusSearch p1 = new AdminStatusSearch();
		p1.setBounds(12, 10, 1178, 96);
		add(p1);
		
		AdminStatusLists p2 = new AdminStatusLists();
		p2.setBounds(12, 116, 1176, 418);
		add(p2);
		
		PagingComp p3 = new PagingComp();
		p3.setBounds(12, 544, 1176, 40);
		add(p3);
	}
}
