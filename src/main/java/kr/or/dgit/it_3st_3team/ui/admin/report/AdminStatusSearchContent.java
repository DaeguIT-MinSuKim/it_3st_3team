package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.table.SupplyingCompanyLists;
import java.awt.Color;

public class AdminStatusSearchContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminStatusSearchContent() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		AdminStatusSearch panel = new AdminStatusSearch();
		panel.setBounds(0, 10, 1165, 106);
		add(panel);
		panel.setLayout(null);
		
		
		
		
		SupplyingCompanyLists panel_2 = new SupplyingCompanyLists();
		panel_2.setBounds(0, 116, 1165, 535);
		add(panel_2);
	}
}
