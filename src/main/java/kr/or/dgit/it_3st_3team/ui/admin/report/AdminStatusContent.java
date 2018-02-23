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
		
		AdminStatusSearch panel = new AdminStatusSearch();
		panel.setBounds(12, 10, 1178, 96);
		add(panel);
		
		AdminStatusLists panel_2 = new AdminStatusLists();
		panel_2.setBounds(12, 116, 1176, 418);
		add(panel_2);
		
		PagingComp panel_1 = new PagingComp();
		panel_1.setBounds(12, 544, 1176, 40);
		add(panel_1);
	}
}
