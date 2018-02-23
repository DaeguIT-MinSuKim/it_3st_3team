package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.it_3st_3team.ui.table.CompanyStatusLists;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.Color;

public class CompanyStatusContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public CompanyStatusContent() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		CompanyStatusSearch panel = new CompanyStatusSearch();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1188, 107);
		add(panel);
		
		CompanyStatusLists panel_1 = new CompanyStatusLists();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 118, 1165, 428);
		add(panel_1);
		
		PagingComp panel_2 = new PagingComp();
		panel_2.setBounds(0, 559, 1188, 40);
		add(panel_2);
	}

}
