package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.table.SupplyingCompanyLists;

public class AdminStatusSearchContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminStatusSearchContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		AdminStatusSearch panel = new AdminStatusSearch();
		panel.setBounds(0, 0, 1200, 106);
		add(panel);
		panel.setLayout(null);
		
		
		
		
		SupplyingCompanyLists panel_2 = new SupplyingCompanyLists();
		panel_2.setBounds(0, 116, 1200, 398);
		add(panel_2);
	}
}
