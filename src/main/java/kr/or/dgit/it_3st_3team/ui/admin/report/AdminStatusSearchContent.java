package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;

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
		
		
		
		AdminStatusLists panel_1 = new AdminStatusLists();
		panel_1.setBounds(0, 114, 1200, 401);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 525, 1200, 53);
		add(panel_2);
	}

}
