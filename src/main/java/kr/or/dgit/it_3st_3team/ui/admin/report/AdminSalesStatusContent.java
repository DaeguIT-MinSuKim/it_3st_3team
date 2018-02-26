package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import kr.or.dgit.it_3st_3team.ui.table.AdminSalesStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminSalesStatusContent extends JPanel {

	public AdminSalesStatusContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		AdminSalesStatusSearch panel = new AdminSalesStatusSearch();
		panel.setBounds(12, 10, 1178, 96);
		add(panel);

		AdminSalesStatusLists panel_1 = new AdminSalesStatusLists();
		panel_1.setBounds(12, 116, 1176, 418);
		add(panel_1);

		PagingComp panel_2 = new PagingComp();
		panel_2.setBounds(12, 544, 1176, 40);
		add(panel_2);
	}

}
