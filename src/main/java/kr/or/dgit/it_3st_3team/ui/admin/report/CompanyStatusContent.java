package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

public class CompanyStatusContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public CompanyStatusContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		CompanyStatusSearch panel = new CompanyStatusSearch();
		panel.setBounds(12, 10, 1178, 96);
		add(panel);
		
		CompanyStatusLists panel_1 = new CompanyStatusLists();
		panel_1.setBounds(12, 116, 1176, 418);
		add(panel_1);
		
		PagingComp panel_2 = new PagingComp();
		panel_2.setBounds(12, 544, 1176, 40);
		add(panel_2);
	}

}
